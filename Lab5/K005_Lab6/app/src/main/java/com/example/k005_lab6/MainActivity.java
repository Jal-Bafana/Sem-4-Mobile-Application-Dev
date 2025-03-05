package com.example.k005_lab6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the XML layout

        // Get references to the views defined in the XML layout
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        // Add login button functionality
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if ("user".equals(username) && "password".equals(password)) {
                // On success, move to the second screen and pass the username
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            } else {
                // On failure, show a Toast message
                Toast.makeText(MainActivity.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
