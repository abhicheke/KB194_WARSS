package com.example.rameshsih;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class pro1 extends AppCompatActivity {
    TextView name,aadhar,dob,mobile,house,road,land,pin,vill,taluk,dist,mname,lname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro1);
        name=findViewById(R.id.textView5);
        aadhar=findViewById(R.id.textView12);
        dob=findViewById(R.id.textView13);
        mobile=findViewById(R.id.textView14);
        house=findViewById(R.id.textView15);
        road=findViewById(R.id.textView16);
        land=findViewById(R.id.textView20);
        pin=findViewById(R.id.textView21);
        vill=findViewById(R.id.textView22);
        taluk=findViewById(R.id.textView23);
        dist=findViewById(R.id.textView24);
        Globalclass Globalclass = com.example.rameshsih.Globalclass.getInstance();
        String n =Globalclass.getName();
        String n1 =Globalclass.getaathar();
        String n2 =Globalclass.getDob();
        String n3 =Globalclass.getmob();
        String n4 =Globalclass.gethouse();
        String n5 =Globalclass.getroad();
        String n6 =Globalclass.getland();
        String n7 =Globalclass.getpin();
        String n8 =Globalclass.getvillage();
        String n9 =Globalclass.gettaluk();
        String n10 =Globalclass.getdistrict();
        name.setText(n);
        aadhar.setText(n1);
        dob.setText(n2);
        mobile.setText(n3);
        house.setText(n4);
        road.setText(n5);
        land.setText(n6);
        pin.setText(n7);
        vill.setText(n8);
        taluk.setText(n9);
        dist.setText(n10);
    }
}