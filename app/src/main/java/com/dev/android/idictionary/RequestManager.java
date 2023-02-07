package com.dev.android.idictionary;

import android.content.Context;
import android.widget.Toast;

import com.dev.android.idictionary.Models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {
    private Context context;

    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    /*
    Method for handle calling
    Inside the method we will pass two parameter
    1.Listener that will capture the response inside the MainActivity
    2.Then we will pass word that we are searching for
   */
    public void getWordMeaning(OnFetchDataListener listener,String word){
        //create a object for interface CallDictionary
        CallDictionary callDictionary=retrofit.create(CallDictionary.class);
        Call<List<ApiResponse>> call=callDictionary.callMeanings(word);


        //Get Response
        try{
            call.enqueue(new Callback<List<ApiResponse>>() {
                @Override
                public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
                      if(!response.isSuccessful()){
                          Toast.makeText(context, "Error! Response is not Success ", Toast.LENGTH_SHORT).show();
                          return;
                      }
                      listener.onFetchData(response.body().get(0),response.message());
                }

                @Override
                public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                    listener.onError("Request Failure");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "An Error Occurred!!", Toast.LENGTH_SHORT).show();
        }

    }

    //Interface for API Calling
    public interface CallDictionary{
        @GET("entries/en/{word}")
        Call<List<ApiResponse>> callMeanings(
                @Path("word") String word
        );

    }
}
