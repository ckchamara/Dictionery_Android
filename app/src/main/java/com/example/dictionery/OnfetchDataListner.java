package com.example.dictionery;

import com.example.dictionery.Models.APIResponce;

public interface OnfetchDataListner {
    void onFetchData(APIResponce apiResponce, String message);
    void onError(String error);

}
