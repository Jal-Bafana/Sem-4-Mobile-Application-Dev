package com.example.k005_spinner_lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spnpic;
    ImageView imgpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Spinner and ImageView
        spnpic = findViewById(R.id.Spinner);
        imgpic = findViewById(R.id.imageView);

        // Set up the Spinner with the array of items
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.photo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnpic.setAdapter(adapter);

        // Set an OnItemSelectedListener to handle selection
        spnpic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item from the Spinner
                String choice = String.valueOf(spnpic.getSelectedItem());

                // Set image based on selected item
                if (choice.equals("img1")) {
                    imgpic.setImageResource(R.drawable.img1);
                } else if (choice.equals("img2")) {
                    imgpic.setImageResource(R.drawable.img2);
                } else if (choice.equals("img3")) {
                    imgpic.setImageResource(R.drawable.img3);
                } else if (choice.equals("img4")) {
                    imgpic.setImageResource(R.drawable.img4);
                } else {
                    imgpic.setImageResource(R.drawable.img5);  // Default case if no match
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Optionally, set a default image or leave blank
                imgpic.setImageResource(R.drawable.img5);  // Example default image
            }
        });
    }
}
