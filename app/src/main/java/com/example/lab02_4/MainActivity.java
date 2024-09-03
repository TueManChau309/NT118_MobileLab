package com.example.lab02_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etId = (EditText) findViewById(R.id.ed_ID);
        EditText etName = (EditText) findViewById(R.id.et_Name);
        CheckBox ckbManager= (CheckBox) findViewById(R.id.ckb_manager);
        Button btnSubmit=(Button) findViewById(R.id.btn_Submit);
        ListView lvPerson=(ListView) findViewById(R.id.lv_person);
        ArrayList<Employee> employees=new ArrayList<Employee>();
        EmployeeAdapter adapter=new EmployeeAdapter(this, android.R.layout.simple_list_item_1,employees);
        lvPerson.setAdapter(adapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String id = etId.getText().toString();
                if (!name.isEmpty() && !id.isEmpty())
                {
                    Employee employee = new Employee();
                    if (ckbManager.isChecked())
                    {
                        employee.setManager(true);
                    }
                    else
                    {
                        employee.setManager(false);
                    }
                   employee.setFullName(name);
                    //employee => ArrayList
                    employees.add(employee);
                    //update UI
                    adapter.notifyDataSetChanged();
                    etId.getText().clear();
                    etName.getText().clear();
                }
            }
        });
    }
}