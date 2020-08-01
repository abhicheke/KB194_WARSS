package com.example.rameshsih;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class transfer extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Spinner ani;
TextView count;
RadioGroup rg;
RadioButton buy,sale;
static EditText fromedit;
    static EditText toedit;
    EditText noaniedit;
    EditText amountedit;
Button changebutton;
String[] animals={"Cows","Buffalo","Goat","Sheep","Horse"};
    Globalclass obj=Globalclass.getInstance();
    String sendanimal=obj.getcows();
    String id=obj.getId();
    int change=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        ani=findViewById(R.id.animalname);
        count=findViewById(R.id.animalcount);
        rg=findViewById(R.id.radioGroupsale);
        buy=findViewById(R.id.buy);
        sale=findViewById(R.id.sale);
        fromedit=findViewById(R.id.fromedit);
        toedit=findViewById(R.id.toedit);
        noaniedit=findViewById(R.id.noaniedit);
        amountedit=findViewById(R.id.amountedit);
        changebutton=findViewById(R.id.changebutton);
        count.setText(obj.getcows());
        ani.setOnItemSelectedListener(this);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,animals);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ani.setAdapter(aa);
        buy.setChecked(true);
        toedit.setText(id);
        buy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                fromedit.setText(id);
                toedit.setText("");
            }
        });
        sale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                fromedit.setText("");
                toedit.setText(id);
            }
        });
    }
    public void changetheowner(View view){
        if(buy.isChecked()){
           // toedit.setText(id);
            //fromedit.setText("");
            String f=fromedit.getText().toString();
           String t=id;
            String changeani=sendanimal;
           String noanimal=noaniedit.getText().toString();
           String amount=amountedit.getText().toString();
           new owner(this).execute(f,t,changeani,noanimal,amount);
        }
        if(sale.isChecked()){
            //toedit.setText("");
            //fromedit.setText(id);
            String changeani=sendanimal;
            String f=id;
            String t=toedit.getText().toString();
            String noanimal=noaniedit.getText().toString();
            String amount=amountedit.getText().toString();
            new owner(this).execute(f,t,changeani,noanimal,amount);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.sendanimal=animals[position];
        if(position==0){
            count.setText(obj.getcows());
        }
        if(position==1){
            count.setText(obj.getbuff());
        }
        if(position==2){
            count.setText(obj.getgoat());
        }
        if(position==3){
            count.setText(obj.getsheep());
        }
        if(position==4){
            count.setText(obj.gethorse());
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        this.sendanimal=animals[0];
    }
}