package com.example.lab02_5;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Activity context;
    private List<Thumbnail> my_Thumb;

    public ThumbnailAdapter(Activity context,int resource, List<Thumbnail> myList) {
        super(context,resource,myList);
        this.context = context;
        this.my_Thumb = myList;
    }
    @Override
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail,parent,false);
        TextView textView = convertView.findViewById(R.id.tv_Thumb);
        textView.setText(my_Thumb.get(position).toString());
        ImageView imageView = convertView.findViewById(R.id.img_Thumb);
        imageView.setImageResource(my_Thumb.get(position).getImg());
        return convertView;
    }
    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_selected_thumbnail,parent,false);
        TextView textView = convertView.findViewById(R.id.tv_ThumbSelected);
        Thumbnail thumbnail = my_Thumb.get(position);
        textView.setText(thumbnail.toString());
        return convertView;
    }

}