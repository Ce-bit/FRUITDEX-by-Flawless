package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences dp;
    private TextView name;
    private TextView password2;
    public static final String MyPREFERENCES = "UserLogin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sp= getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String email=sp.getString("EMAIL","");
        String password=sp.getString("Password","");
        name = findViewById(R.id.textView6);
        password2=findViewById(R.id.textView5);

        name.setText(email);
        password2.setText(password);

    }


}