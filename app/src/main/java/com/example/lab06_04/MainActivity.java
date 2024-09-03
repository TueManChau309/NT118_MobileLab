package com.example.lab06_04;


import android.os.Bundle;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2Employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.viewPager2Employee = findViewById(R.id.vPager);
        Employee emp1 = new Employee("Elizabeth Johnson", "elizabethjohnson@example.com", "Project Manager");
        Employee emp2 = new Employee("Catherine Johnson", "catherinejohnson@example.com", "President of Sales");

        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        // Employee FragmentStateAdapter.
        EmployeeFragmentStateAdapter adapter = new EmployeeFragmentStateAdapter(this, list);
        this.viewPager2Employee.setAdapter(adapter);
    }
}