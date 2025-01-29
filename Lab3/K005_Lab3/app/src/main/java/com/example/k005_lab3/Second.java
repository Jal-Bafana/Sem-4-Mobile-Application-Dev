package com.example.k005_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
public class Second extends AppCompatActivity{

    ListView lvmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lvmenu=findViewById(R.id.lv_menu);
        String[] items=getResources().getStringArray(R.array.options);
        ArrayAdapter<String> adapt=
                new ArrayAdapter<>
                        (this,R.layout.listitem,items);
        lvmenu.setAdapter(adapt);
        lvmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(Second.this,Third.class));
                        break;
                    case 1://phone dialer
                        String str=tv.getText().toString();
                        str="tel:"+str;
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(str)));
                        break;
                    case 2://Email
                        Linkify.addLinks(tv,Linkify.EMAIL_ADDRESSES);
                        break;
                    case 3: //google_search
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http:www.google.co.in")));
                        break;
                    case 4: //android tutorial
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.tutorialspoint.com/android")));
                        break;

                }
            }
        });
    }
}
