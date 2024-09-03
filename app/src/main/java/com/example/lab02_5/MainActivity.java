package com.example.lab02_5;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    EditText editText;
    CheckBox cbPromt;
    DishAdapter dishAdapter;
    Button btn;
    ThumbnailAdapter thumbnailAdapter;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spn_Thumb);
        List<Thumbnail> thumbnails = Arrays.asList(Thumbnail.values());
        thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_thumbnail,thumbnails);
        spinner.setAdapter(thumbnailAdapter);
        gridView = findViewById(R.id.gv_Show);
        editText = findViewById(R.id.edt_Name);
        cbPromt = findViewById(R.id.cb_Promotion);
        dishAdapter = new DishAdapter(this,R.layout.item_dish, new ArrayList<Dish>());
        gridView.setAdapter(dishAdapter);
        btn = findViewById(R.id.btn_Add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName(editText.getText().toString());
                if(cbPromt.isChecked())
                {
                    dish.setPromt(true);
                }
                dish.setThumb((Thumbnail) spinner.getSelectedItem());
                dishAdapter.add(dish);
                dishAdapter.notifyDataSetChanged();
                editText.setText("");
                editText.clearFocus();
                spinner.setSelection(0);
                cbPromt.setChecked(false);
                Toast.makeText(MainActivity.this, "Added successfully" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}