package com.example.lab02_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//
        EditText etNames= (EditText) findViewById(R.id.et_names);
        ListView lvPerson = (ListView) findViewById(R.id.lv_person);
        TextView tvSelect = (TextView) findViewById(R.id.tv_select);
        Button  btnSubmit = (Button) findViewById(R.id.btn_submit);
        ArrayList<String> names = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
//      Set ArrayAdapter to ListView
        lvPerson.setAdapter(adapter);
        // Handle button click event
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = etNames.getText().toString();
                if (!item.isEmpty()) {
                    names.add(item);
                    adapter.notifyDataSetChanged();
                    etNames.setText("");
                }
            }
        });
        // Handle item click event
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItem = (String) names.get(position);
                    tvSelect.setText("Position :" + position + "; Value =" + selectedItem);
            }
        });
        // Handle long click event
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                names.remove(position);
                adapter.notifyDataSetChanged();
                tvSelect.setText("");
                return true;
            }
        });
    }
}