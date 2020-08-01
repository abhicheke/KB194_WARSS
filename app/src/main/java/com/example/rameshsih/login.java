package com.example.rameshsih;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class login extends AppCompatActivity {
    ImageView neweuser,videdemo;
    Button loginbutton;
    CheckBox checkBox;
    static EditText uname,passwordfeild;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uname=findViewById(R.id.uname);
        passwordfeild=findViewById(R.id.password);
        loginbutton=findViewById(R.id.button2);
        checkBox=findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // show password
                    passwordfeild.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    passwordfeild.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        pref=getSharedPreferences("user_details",MODE_PRIVATE);
        if(pref.contains("username") && pref.contains("password")){
            String username=pref.getString("username","");
            String password=pref.getString("password","");
            new SigninActivity(this).execute(username,password);
        }
    }
    public void loginfunction(View view){
        String mobile=uname.getText().toString();
        String password=passwordfeild.getText().toString();
        if(mobile.equals("")||password.equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error");
            builder.setMessage("Wrong user id or Password");
            builder.setPositiveButton("OK", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {
            new SigninActivity(this).execute(mobile,password);
        }
    }
}