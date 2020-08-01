package com.example.rameshsih;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdminDashbord extends AppCompatActivity {
ImageView newenterybutton,logout;
Button verifybutton;
EditText phone;
    SharedPreferences pref;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashbord);
        newenterybutton=findViewById(R.id.newentry);
        verifybutton=findViewById(R.id.verification);
        logout=findViewById(R.id.log);
        phone =findViewById(R.id.phonenumber);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref=getSharedPreferences("user_details",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                Intent i=new Intent(AdminDashbord.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void reg(View view){
        startActivity(new Intent(this,register.class));
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
                System.exit(0);
            }
        }, 2000);
    }
    public void loginfunction(View view){
        String mobile=phone.getText().toString();
        if(mobile.equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error");
            builder.setMessage("Wrong user id or Password");
            builder.setPositiveButton("OK", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {
            new Adminview(this).execute(mobile);
        }
}
}