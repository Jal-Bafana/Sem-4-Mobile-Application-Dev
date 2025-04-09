package com.example.k005_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Declare the views
    EditText ed_num1, ed_num2;
    TextView lbout;
    Button btnadd, btnsubtract, btnmultiply, btndivide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Initialize the views
        ed_num1 = findViewById(R.id.ed_num1);
        ed_num2 = findViewById(R.id.ed_num2);
        lbout = findViewById(R.id.lbout);
        btnadd = findViewById(R.id.btn_add);
        btnsubtract = findViewById(R.id.btn_subtract);
        btnmultiply = findViewById(R.id.btn_multiply);
        btndivide = findViewById(R.id.btn_divide);
// Set onClickListeners for buttons
        btnadd.setOnClickListener(this);
        btnsubtract.setOnClickListener(this);
        btnmultiply.setOnClickListener(this);
        btndivide.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        String num1Str = ed_num1.getText().toString();
        String num2Str = ed_num2.getText().toString();
// Validate inputs
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Input boxes are empty", Toast.LENGTH_SHORT).show();
            return;
        }
        double num1, num2;
        try {
            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            return;
        }
        double result = 0;
// Use if-else instead of switch-case
        if (view.getId() == R.id.btn_add) {
            result = num1 + num2;
        } else if (view.getId() == R.id.btn_subtract) {
            result = num1 - num2;
        } else if (view.getId() == R.id.btn_multiply) {
            result = num1 * num2;
        } else if (view.getId() == R.id.btn_divide) {
            if (num2 == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
            result = num1 / num2;
        }
// Display the result
        lbout.setText(String.valueOf(result));
    }
}