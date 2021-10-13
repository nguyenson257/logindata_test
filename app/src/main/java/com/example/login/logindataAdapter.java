package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.login.Model.logindata;

import java.util.List;

public class logindataAdapter extends ArrayAdapter<logindata> {

    private Context context;
    private List<logindata>logindata;

    public logindataAdapter(@NonNull Context context, int resource, @NonNull List<logindata> objects) {
        super(context, resource, objects);
        this.context=context;
        this.logindata=objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.content_main,parent,false);

        TextView  txtid=(TextView) rowView.findViewById(R.id.id);
        TextView  txtuser=(TextView) rowView.findViewById(R.id.user);
        TextView  txtpass=(TextView) rowView.findViewById(R.id.pass);
        TextView  txtname=(TextView) rowView.findViewById(R.id.name);

        txtid.setText(String.format("ID:%d",logindata.get(position).getId()));
        txtuser.setText(String.format("User:%s",logindata.get(position).getUser()));
        txtpass.setText(String.format("Password:%s",logindata.get(position).getPass()));
        txtname.setText(String.format("Name:%s",logindata.get(position).getName()));
        return rowView;
    }
}
