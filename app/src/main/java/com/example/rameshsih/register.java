package com.example.rameshsih;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

public class register extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button b1, b2, close;
    EditText name, adharnum, mobile, housenum, road, landmark, pincode, remarks, cow, bufflo, goat, sheep, horse, eText, pass, confir,mname,lname;
    Button btnAdd, btnview;
    DatePickerDialog picker;
    String[] district = {"Anantapur", "Chittoor", "East_Godavari", "Guntur", "Krishna", "Kurnool", "Nellore", "Prakasam", "Srikakulam", "Visakhapatnam", "Vizianagaram", "West_Godavari", "YSR_Kadapa"};
    String[] taluk = {"East_Godavari", "Guntur", "Krishna", "Kurnool", "Nellore", "Prakasam"};
    String[] village = {"Prakasam", "Srikakulam", "Visakhapatnam", "Vizianagaram", "West_Godavari"};
    Spinner dis, tal, vill;
    String d=new String();
    String t=new String();
    String v=new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        lname = (EditText) findViewById(R.id.lname);
        close = (Button) findViewById(R.id.button7);
        name = (EditText) findViewById(R.id.name);
        adharnum = (EditText) findViewById(R.id.adnum);
        mobile = (EditText) findViewById(R.id.mobileno);
        housenum = (EditText) findViewById(R.id.houseno);
        road = (EditText) findViewById(R.id.road);
        landmark = (EditText) findViewById(R.id.landmark);
        pincode = (EditText) findViewById(R.id.pincode);
        cow = (EditText) findViewById(R.id.cowt);
        bufflo = (EditText) findViewById(R.id.buff);
        goat = (EditText) findViewById(R.id.goat);
        sheep = (EditText) findViewById(R.id.sheep);
        horse = (EditText) findViewById(R.id.horse);
        b1 = (Button) findViewById(R.id.button3);
        dis = (Spinner) findViewById(R.id.spinner);
        tal = (Spinner) findViewById(R.id.spinner1);
        vill = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, district);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dis.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, taluk);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tal.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, village);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vill.setAdapter(adapter2);
        eText = (EditText) findViewById(R.id.deob);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(register.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
    }

    public void cancel(View view) {
        Intent i = new Intent(this, AdminDashbord.class);
        startActivity(i);
    }

    public void reg1(View view) {
        String na = name.getText().toString();
        String lna = lname.getText().toString();
        String aathar = adharnum.getText().toString();
        String dob = eText.getText().toString();
        String mob = mobile.getText().toString();
        String honum = housenum.getText().toString();
        String ro = road.getText().toString();
        String lm = landmark.getText().toString();
        String pc = pincode.getText().toString();
        String villa = vill.getSelectedItem().toString();
        String talu = tal.getSelectedItem().toString();
        String dist = dis.getSelectedItem().toString();
        String co = cow.getText().toString();
        String buf = bufflo.getText().toString();
        String go = goat.getText().toString();
        String she = sheep.getText().toString();
        String hor = horse.getText().toString();
        String password = "";
        String confirm = "";
        if (na.equals("") || aathar.equals("") || dob.equals("") || mob.equals("") || honum.equals("") || ro.equals("") || lm.equals("") || pc.equals("") || dist.equals("") || talu.equals("") || villa.equals("") || co.equals("") || buf.equals("") || go.equals("") || she.equals("") || hor.equals("")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Error");
                builder.setMessage("Must Fill all the Fields");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
        } else {
            if(password.equals(confirm)!=true){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Error");
                builder.setMessage("Password or confirm password does not match");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else if(mob.length()==10){
                new Enter(this).execute(na,lna,aathar, dob, mob, honum, ro, lm, pc, villa, talu, dist, co, buf, go, she, hor, password);
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Error");
                builder.setMessage("Enter Vaild Mobile Number");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();

            }

        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.d=district[position];
        this.t=district[position];
        this.v=district[position];
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        this.d=district[0];
        this.t=district[0];
        this.v=district[0];
    }
}
