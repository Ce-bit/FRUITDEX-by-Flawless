package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Fruit> {


    public ListAdapter(Context context, ArrayList<Fruit> userArrayList){

        super(context,R.layout.list_item,userArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Fruit fruit = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.fruit_pic);
        TextView fruitName = convertView.findViewById(R.id.fruitName);
        TextView fruitFamily = convertView.findViewById(R.id.fruit_family);
        TextView region = convertView.findViewById(R.id.Species);

        imageView.setImageResource(fruit.imageId);
        fruitName.setText(fruit.name);
        fruitFamily.setText(fruit.family);
        region.setText(fruit.region);


        return convertView;
    }
}
