package com.example.dictionery;

import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.widget.Toast;

import com.example.dictionery.Models.APIResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getWordMeaning(OnfetchDataListner listner, String word){
        CallDictionery callDictionery = retrofit.create(CallDictionery.class);
        Call<List<APIResponce>> call = callDictionery.callMeanings(word);

        try {
            call.enqueue(new Callback<List<APIResponce>>() {
                @Override
                public void onResponse(Call<List<APIResponce>> call, Response<List<APIResponce>> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listner.onFetchData(response.body().get(0),response.message());
                }

                @Override
                public void onFailure(Call<List<APIResponce>> call, Throwable t) {
                        listner.onError("Request Failed..!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "An Error occured", Toast.LENGTH_SHORT).show();
        }
    }



    public interface CallDictionery {
        @GET("entries/en/{word}")
        Call<List<APIResponce>> callMeanings (@Path("word") String word);
    }
}
