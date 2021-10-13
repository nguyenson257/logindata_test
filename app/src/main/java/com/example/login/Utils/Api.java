package com.example.login.Utils;

public class Api {
    public static final String URL_001="http://localhost:8080/";

    public static logindataService getlogindataServive(){
        return Client.getClient(URL_001).create(logindataService.class);
    }
}
