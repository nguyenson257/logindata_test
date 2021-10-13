package com.example.login.Utils;

import com.example.login.Model.logindata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface logindataService {
    @GET("listar/")
    Call<List<logindata>> getlogindata();
}
