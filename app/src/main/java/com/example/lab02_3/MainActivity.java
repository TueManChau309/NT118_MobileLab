package com.example.lab02_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RadioButton rd_Chinhthuc, rd_Thoivu;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etId = (EditText) findViewById(R.id.ed_ID);
        EditText etName = (EditText) findViewById(R.id.et_Name);
        Button btnSubmit=(Button) findViewById(R.id.btn_Submit);
        RadioGroup rgType=(RadioGroup) findViewById(R.id.rdg_Type);
        ListView lvPerson=(ListView) findViewById(R.id.lv_person);
        ArrayList<Employee> employees=new ArrayList<Employee>();
        ArrayAdapter<Employee> adapter=new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,employees);
        lvPerson.setAdapter(adapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee;
                int radId = rgType.getCheckedRadioButtonId();
                String id = etId.getText().toString();
                String name = etName.getText().toString();
                if (radId == R.id.rd_Chinhthuc) {
                    //tạo instance là FullTime
                    employee = new EmployeeFulltime();
                } else {
                    //Tạo instance là Partime
                    employee = new EmployeeParttime();
                }
                //FullTime hay Partime thì cũng là Employee nên có các hàm này là hiển nhiên
                employee.setId(id);
                employee.setName(name);
                //Đưa employee vào ArrayList
                employees.add(employee);
                //Cập nhập giao diện
                adapter.notifyDataSetChanged();
                etId.setText("");
                etName.setText("");
                etName.clearFocus();
                rgType.clearCheck();
            }
        });
    }
}