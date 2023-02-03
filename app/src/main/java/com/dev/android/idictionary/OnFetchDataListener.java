package com.dev.android.idictionary;

import com.dev.android.idictionary.Models.ApiResponse;

public interface OnFetchDataListener {
     void  onFetchData(ApiResponse apiResponse,String message);
     void onError(String message);
}
