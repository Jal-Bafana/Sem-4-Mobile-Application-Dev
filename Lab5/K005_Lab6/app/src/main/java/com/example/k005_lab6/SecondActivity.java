package com.example.k005_lab6;

import android.view.View;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Dynamically create the layout container for the second screen
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 50, 50, 50);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);  // Center horizontally, but leave space at the top

        // Create a TextView for the welcome message
        TextView welcomeMessageTextView = new TextView(this);
        welcomeMessageTextView.setText("Welcome Student !!!");
        welcomeMessageTextView.setTextSize(30);
        welcomeMessageTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        // Create a Spinner for selecting background color
        Spinner colorSpinner = new Spinner(this);

        // Create a list of colors for the Spinner
        String[] colors = {"Select a color", "Red", "Green", "Blue", "Yellow", "White"};

        // Set up the Spinner with the list of colors
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapter);

        // Create a Button for going back to the main screen
        Button backButton = new Button(this);
        backButton.setText("Back");

        // Set the button's layout parameters with gravity centered horizontally
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        buttonLayoutParams.gravity = Gravity.CENTER;  // Center the button horizontally
        buttonLayoutParams.topMargin = 100;  // Add margin from the top to ensure space between the spinner and button
        backButton.setLayoutParams(buttonLayoutParams);

        // Set an OnItemSelectedListener for the Spinner to change the background color
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected color from the Spinner
                String selectedColor = parentView.getItemAtPosition(position).toString();

                // Change the background color based on the selection
                switch (selectedColor) {
                    case "Red":
                        layout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                        break;
                    case "Green":
                        layout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                        break;
                    case "Blue":
                        layout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                        break;
                    case "Yellow":
                        layout.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                        break;
                    case "White":
                        layout.setBackgroundColor(getResources().getColor(android.R.color.white));
                        break;
                    default:
                        layout.setBackgroundColor(getResources().getColor(android.R.color.background_light));  // Default color
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing if no color is selected
            }
        });

        // Add the views to the layout
        layout.addView(welcomeMessageTextView);
        layout.addView(colorSpinner); // Add the spinner between the welcome message and the button
        layout.addView(backButton);

        // Set the content view to this dynamically created layout
        setContentView(layout);

        // Set the onClickListener for the "Back" button to return to the main screen
        backButton.setOnClickListener(v -> {
            finish(); // Close SecondActivity and return to MainActivity
        });
    }
}
