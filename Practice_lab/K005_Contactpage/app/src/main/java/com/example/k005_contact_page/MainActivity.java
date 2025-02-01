package com.example.k005_contact_page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactListView = findViewById(R.id.contactListView);

        // Dummy contacts
        ArrayList<com.example.k005_contact_page.Contact> contacts = new ArrayList<>();
        contacts.add(new com.example.k005_contact_page.Contact(R.drawable.img, "Jal Bafana", "9725498430", "pani@gmail.com"));
        contacts.add(new com.example.k005_contact_page.Contact(R.drawable.img_1, "Arjun Mehta", "9265598734", "juicy@gmail.com"));
        contacts.add(new com.example.k005_contact_page.Contact(R.drawable.img_1, "Dakshita Galotra", "8080419845", "kumbkaran@gmail.com"));
        contacts.add(new com.example.k005_contact_page.Contact(R.drawable.img_3, "Rhea Chavan", "6983590870", "dhobighatat@gmail.com"));
        contacts.add(new com.example.k005_contact_page.Contact(R.drawable.img_1, "Rajpreet Khurana", "970956489", "pajji@gmail.com"));
        contacts.add(new com.example.k005_contact_page.Contact(R.drawable.img_5, "Prakhar Mehta", "8879056789", "pathar@gmail.com"));
        contacts.add(new com.example.k005_contact_page.Contact(R.drawable.img_5, "Shivansh Jindal", "9987698769", "billo@gmail.com"));
        contacts.add(new com.example.k005_contact_page.Contact(R.drawable.img_7, "Aryan Mathre", "9089349875", "goat@gmail.com"));
        contacts.add(new com.example.k005_contact_page.Contact(R.drawable.img_3, "Saara Bait", "8709096784", "baited@gmail.com"));


        // Create and set the custom adapter for the ListView
        ContactAdapter contactAdapter = new ContactAdapter(this, contacts);
        contactListView.setAdapter(contactAdapter);

        // Set an item click listener to navigate to screen 2
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected contact
                com.example.k005_contact_page.Contact selectedContact = contacts.get(position);

                // Create an intent to navigate to the second screen (ContactDetailsActivity)
                Intent intent = new Intent(MainActivity.this, ContactDetailsActivity.class);
                intent.putExtra("contact_image", selectedContact.getImage());
                intent.putExtra("contact_name", selectedContact.getName());
                intent.putExtra("contact_number", selectedContact.getPhoneNumber());
                intent.putExtra("contact_email", selectedContact.getEmail());
                startActivity(intent);
            }
        });
    }
}