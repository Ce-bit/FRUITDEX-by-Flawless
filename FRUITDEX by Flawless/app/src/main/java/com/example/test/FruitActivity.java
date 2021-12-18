package com.example.test;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.databinding.ActivityFruitBinding;

public class FruitActivity extends AppCompatActivity {

    ActivityFruitBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFruitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String country = intent.getStringExtra("country");
            int imageid = intent.getIntExtra("imageid",R.drawable.akee);

            binding.nameProfile.setText(name);
            binding.familyProfile.setText(phone);
            binding.descriptionProfile.setText(country);
            binding.fruitImage.setImageResource(imageid);


        }

    }
}