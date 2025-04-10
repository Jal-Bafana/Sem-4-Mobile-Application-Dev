package com.example.k005_db_lab;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import  android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText txtroll, txtname, txtmarks;

    Button btnadd, btnmodify, btnview, btndelete, btnviewall;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnadd = findViewById(R.id.btn_add);
        btndelete = findViewById(R.id.btn_delete);
        btnmodify = findViewById(R.id.btn_modify);
        btnview = findViewById(R.id.btn_view);
        btnviewall = findViewById(R.id.btn_viewall);

        txtroll = findViewById(R.id.txt_roll);
        txtname = findViewById(R.id.txt_name);
        txtmarks = findViewById(R.id.txt_marks);

        db = openOrCreateDatabase("Studentdb", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + "student(rollno text, name text, marks real);");
    }
    public void add(View v){
        if(check()){
            db.execSQL("insert into student values('"
                    +txtroll.getText().toString()
                    +"','"+ txtname.getText().toString()
                    +"',"+ Float.parseFloat(txtmarks.getText().toString()) +");");
            showmsg("Added", "Record saved");
        }
    }

    public void delete(View v){
        if(txtroll.getText().toString().isEmpty()){
            showmsg("Error", "Roll No not entered");
        }
        else{
            Cursor c = db.rawQuery("select * from student where rollno ='"
                    +txtroll.getText().toString()+"';",null);
            if(c.moveToFirst()){
                db.execSQL("delete from student where rollno ='"
                        +txtroll.getText().toString()+"';");
                showmsg("Deleted",
                        "Record Deleted" + txtroll.getText().toString());
            }
            else{
                showmsg("Error",txtroll.getText().toString()+"does not exist");
            }
        }

    }
    public boolean check(){
        if (txtroll.getText().toString().isEmpty() || txtname.getText().toString().isEmpty() || txtmarks.getText().toString().isEmpty()){
            showmsg("Error","Fields cannot be blank");
            return false;
        }else{
            return true;
        }
    }

    public void showmsg(String title, String msg){
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(title);
            builder.setMessage(msg);
            builder.show();
        }
    }

    public void viewall(View v){
        Cursor c = db.rawQuery("select * from student; ",null);
        if(c.getCount() == 0){
            showmsg("Error", "Table Empty");
        }else{
            StringBuffer buffer = new StringBuffer();
            while(c.moveToNext()){
                buffer.append("Roll No: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Marks: "+c.getString(2)+"\n");
                buffer.append("--------------------- \n");
            }
            showmsg("Records", buffer.toString());
        }
    }

    public void view(View v){
        if(txtroll.getText().toString().isEmpty()){
            showmsg("Error", "Roll No cannot be blank");
        }
        else{
            Cursor c = db.rawQuery("select * from student where rollno ='"+txtroll.getText().toString()+"';",null);
            if(c.moveToFirst()){
                txtname.setText(c.getString(1));
                txtmarks.setText(c.getString(2));
            }else{
                showmsg("Error","does not exist");
            }
        }
    }

    public void modify(View v){
        if(v == btnmodify) {
            int r=Integer.parseInt(txtroll.getText().toString());
            String n= txtname.getText().toString();
            float m=Float.parseFloat(txtmarks.getText().toString());
            if(txtroll.getText().toString().isEmpty() ||txtname.getText().toString().isEmpty() || txtmarks.getText().toString().isEmpty()) {
                showmsg("Error","Input all fields");
            }
            else {
                Cursor c=db.rawQuery("select * from student where rollno="+r+";",null);
                if(c.getCount()==0) {
                    showmsg("Error","Rollno not existing");
                }
                else { //update student set name='n', marks=67 where rollno=r
                    db.execSQL("update student set name='" + n + "' , marks="+ m +" where rollno=" + r +";");
                    showmsg("Success","Record updated");
                }
            }
        }
    }

}
