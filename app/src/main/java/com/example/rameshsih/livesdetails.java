package com.example.rameshsih;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class livesdetails extends AppCompatActivity {
TextView cow,buffalo,goat,sheep,horse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livesdetails);
        cow=findViewById(R.id.textView8);
        buffalo=findViewById(R.id.textView9);
        goat=findViewById(R.id.textView10);
        sheep=findViewById(R.id.textView11);
        horse=findViewById(R.id.textView17);
        Globalclass Globalclass = com.example.rameshsih.Globalclass.getInstance();
        String cowt =Globalclass.getcows();
        String but =Globalclass.getbuff();
        String goatt =Globalclass.getgoat();
        String sheept =Globalclass.getsheep();
        String horset =Globalclass.gethorse();
        cow.setText(cowt);
        buffalo.setText(but);
        goat.setText(goatt);
        sheep.setText(sheept);
        horse.setText(horset);
    }
}