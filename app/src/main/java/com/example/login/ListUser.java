package com.example.login;

import static com.example.login.R.layout.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;


import com.example.login.Model.logindata;
import com.example.login.Utils.Api;
import com.example.login.Utils.logindataService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUser extends AppCompatActivity {

    logindataService logindataService;
    List<logindata> listLogindata=new ArrayList<>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        Toolbar toolbar = findViewById(R.id.toolbar);


        listView=(ListView)findViewById(R.id.ListView);

        listUser();

        FloatingActionButton fab = findViewById(R.id.fabe);
        fab.setOnClickListener((view -> {
            Snackbar.make(view, "Replace with your action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }));

    }
    public void listUser(){
        logindataService = Api.getlogindataServive();
        Call<List<logindata>> call=logindataService.getlogindata();
        call.enqueue(new Callback<List<logindata>>() {
            @Override
            public void onResponse(Call<List<logindata>> call, Response<List<logindata>> response) {
                listLogindata = response.body();
                listView.setAdapter(new logindataAdapter(ListUser.this, R.layout.activity_main,listLogindata));

            }

            @Override
            public void onFailure(Call<List<logindata>> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}