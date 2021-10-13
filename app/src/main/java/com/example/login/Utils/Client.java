package com.example.login.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public  static Retrofit getClient(String url){
        Retrofit retofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        return retofit;
    }
}
