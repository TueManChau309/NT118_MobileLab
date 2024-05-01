package com.example.lab02_7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private Context Context;
    private ArrayList<Employee> Employees;
    // tạo ra các biến cho danh sách các Hero và truyền chúng qua hàm khởi tạo:
    public EmployeeAdapter(Context Context, ArrayList<Employee> Employees) {
        this.Context = Context;
        this.Employees = Employees;
    }
    // Mọi Adapter sẽ có 3 phương thức quan trọng:
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View employeeView = LayoutInflater.from(Context).inflate(R.layout.item_employee, parent, false);
        ViewHolder viewHolder = new ViewHolder(employeeView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Employee employee = Employees.get(position);
        holder.text_name.setText(employee.getFullName());
        if (employee.isManager())
        {
            holder.image_Manager.setVisibility(View.VISIBLE);
            holder.text_position.setVisibility(View.GONE);
        } else
        {
            holder.image_Manager.setVisibility(View.GONE);
            holder.text_position.setVisibility(View.VISIBLE);
            holder.text_position.setText(Context.getString(R.string.staff));
        }
        //Đổi màu ô xen kẽ
        if (position%2==0)
        {
            holder.llParent.setBackgroundResource(R.color.white);
        }
        else
        {
            holder.llParent.setBackgroundResource(R.color.light_blue);
        }
    }
    @Override
    public int getItemCount() {
        return Employees.size();
    }
    // Tạo class viewholder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_Manager;
        private TextView text_name;
        private TextView text_position;
        private LinearLayout llParent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.item_employee_tv_fullname);
            text_position = itemView.findViewById(R.id.item_employee_tv_position);
            image_Manager = itemView.findViewById(R.id.item_employee_iv_manager);
            llParent = itemView.findViewById(R.id.item_employee_ll_parent);
        }
    }
}