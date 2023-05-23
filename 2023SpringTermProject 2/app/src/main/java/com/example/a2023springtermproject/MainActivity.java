package com.example.a2023springtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private EditText departmentSearchEditText;
    private Button departmentSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.idSearchView);
        departmentSearchEditText = findViewById(R.id.departmentSearchEditText);
        departmentSearchButton = findViewById(R.id.departmentSearchButton);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Create a Google Maps Fragment
                Bundle bundle = new Bundle();
                bundle.putString("address", query);
                Fragment fragment = new MapsFragment();
                fragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .commit();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        departmentSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String departmentCode = departmentSearchEditText.getText().toString().toUpperCase();

                if (isValidDepartment(departmentCode)) {
                    Intent intent = new Intent(MainActivity.this, DepartmentInfoActivity.class);
                    intent.putExtra("departmentCode", departmentCode);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid or non-existing department code.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidDepartment(String departmentCode) {
        return departmentCode.equals("CIS") || departmentCode.equals("BUS") || departmentCode.equals("NUR") || departmentCode.equals("MAT");
    }
}
