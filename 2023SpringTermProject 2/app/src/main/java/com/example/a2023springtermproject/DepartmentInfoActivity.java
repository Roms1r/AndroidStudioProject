package com.example.a2023springtermproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DepartmentInfoActivity extends AppCompatActivity {
    private TextView departmentNameTextView, departmentInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_info);

        departmentNameTextView = findViewById(R.id.departmentNameTextView);
        departmentInfoTextView = findViewById(R.id.departmentInfoTextView);

        String departmentCode = getIntent().getStringExtra("departmentCode");
        if (isValidDepartment(departmentCode)) {
            String departmentInfo = DepartmentDataProvider.getDepartmentInfo(departmentCode);
            departmentNameTextView.setText(departmentCode + " Department");
            departmentInfoTextView.setText(departmentInfo);
        } else {
            departmentNameTextView.setText("Invalid department code.");
            departmentInfoTextView.setText("");
        }
    }

    private boolean isValidDepartment(String departmentCode) {
        return departmentCode.equals("CIS") || departmentCode.equals("BUS") || departmentCode.equals("NUR") || departmentCode.equals("MAT");
    }
}

