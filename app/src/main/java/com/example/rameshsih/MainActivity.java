package com.example.rameshsih;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    public static  int Splah=1000;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pref=getSharedPreferences("user_details",MODE_PRIVATE);
                if(pref.contains("username") && pref.contains("password")){
                    String username=pref.getString("username","");
                    String password=pref.getString("password","");
                    new SigninActivity(MainActivity.this).execute(username,password);
                }
                else{
                Intent home = new Intent(MainActivity.this, login.class);
                startActivity(home);
                finish();
                }
            }
        }, Splah);
    }
}
