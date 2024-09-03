package com.example.lab02_5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
public class DishAdapter extends ArrayAdapter<Dish> {
    Activity context;
    ArrayList<Dish> dishes;

    public DishAdapter( Activity context,int positon, ArrayList<Dish> dishes ) {
        super(context, positon, dishes);
        this.context = context;
        this.dishes = dishes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_dish,parent,false);
        Dish myDish = dishes.get(position);
        ImageView imageView = convertView.findViewById(R.id.img_Dish);
        imageView.setImageResource(myDish.getThumb().getImg());
        TextView textView = convertView.findViewById(R.id.tv_Dish);
        textView.setText(myDish.getName());
        textView.setSelected(true);
        ImageView imgPromt = convertView.findViewById(R.id.item_Promotion);
        if(myDish.isPromt())
        {
            imgPromt.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}