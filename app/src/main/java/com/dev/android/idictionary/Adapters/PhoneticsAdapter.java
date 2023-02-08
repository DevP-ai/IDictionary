package com.dev.android.idictionary.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.android.idictionary.Models.Phonetics;
import com.dev.android.idictionary.R;
import com.dev.android.idictionary.ViewHolders.PhoneticViewHolder;

import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    private List<Phonetics> phoneticsList;

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
         holder.textView_phonetic.setText(phoneticsList.get(position).getText());
         holder.imageButton_audio.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 MediaPlayer player=new MediaPlayer();

                 try{
                     player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                 }catch (Exception e){
                     e.printStackTrace();
                 }
             }
         });
    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
