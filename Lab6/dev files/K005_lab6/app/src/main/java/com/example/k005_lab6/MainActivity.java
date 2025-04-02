package com.example.k005_lab6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the views
        drawingView = findViewById(R.id.drawingView);
        Spinner colorSpinner = findViewById(R.id.colorSpinner);
        Button clearButton = findViewById(R.id.clearButton);

        // Set up Spinner to handle color selection
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Change the drawing pen color based on the selected color
                switch (position) {
                    case 0:
                        drawingView.setPenColor(0xFF000000); // Black
                        break;
                    case 1:
                        drawingView.setPenColor(0xFFFF0000); // Red
                        break;
                    case 2:
                        drawingView.setPenColor(0xFF0000FF); // Blue
                        break;
                    case 3:
                        drawingView.setPenColor(0xFF008000); // Green
                        break;
                    case 4:
                        drawingView.setPenColor(0xFFFFFF00); // Yellow
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Default behavior when nothing is selected
            }
        });

        // Set up the button click listener to clear the drawing
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.clear();  // Call the clear method to reset the drawing
            }
        });
    }
}