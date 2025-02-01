package com.example.k005_contact_page;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailsActivity extends AppCompatActivity {

    private ImageView contactImageView;
    private TextView contactNameTextView, contactNumberTextView, contactEmailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        contactImageView = findViewById(R.id.contactImageView);
        contactNameTextView = findViewById(R.id.contactNameTextView);
        contactNumberTextView = findViewById(R.id.contactNumberTextView);
        contactEmailTextView = findViewById(R.id.contactEmailTextView);

        // Get the contact data from the Intent
        int contactImage = getIntent().getIntExtra("contact_image", 0);
        String contactName = getIntent().getStringExtra("contact_name");
        String contactNumber = getIntent().getStringExtra("contact_number");
        String contactEmail = getIntent().getStringExtra("contact_email");

        // Set the contact data
        contactImageView.setImageResource(contactImage);
        contactNameTextView.setText(contactName);
        contactNumberTextView.setText(contactNumber);
        contactEmailTextView.setText(contactEmail);
    }
}
