package com.example.rameshsih;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.*;
public class update extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner animals;
    TextView count,changeable;
    RadioButton clickedButton,newb,death;
    RadioGroup radioGroup;
    EditText newborn;
    Button updatebutton;
    int change=2;
    String ani[]={"Cows","Buffalo","Goat","Sheep","Horse"};
    Globalclass obj=Globalclass.getInstance();
    String sendanimal=obj.getcows();
    String ani1[]={"Cows","Buffalo","Goat","Sheep","Horse"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        changeable=findViewById(R.id.textView19);
        animals=findViewById(R.id.spinner3);
        count=findViewById(R.id.textView18);
        radioGroup=findViewById(R.id.radioGroup);
        newb=findViewById(R.id.born);
        death=findViewById(R.id.death);
        newborn=findViewById(R.id.editTextTextPersonName);
        updatebutton=findViewById(R.id.button99);
        animals.setOnItemSelectedListener(this);
        count.setText(obj.getcows());
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,ani1);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animals.setAdapter(aa);
        newb.setChecked(true);
        newb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeable.setText("How many Death?");
                change=1;
            }
        });
        death.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeable.setText("How many New Born?");
                change =2;
            }
        });
    }
    public void updatethechange(View view){
        int ids =radioGroup.getCheckedRadioButtonId();
        clickedButton=findViewById(ids);
        String name=clickedButton.getText().toString();
          if(name.equals("New Born")){
              int temp1=Integer.parseInt(count.getText().toString())+Integer.parseInt(newborn.getText().toString());
              String new_born_count=String.valueOf(temp1);
              Globalclass obj=Globalclass.getInstance();
              String mobile=obj.getmob();
              new new_born_and_death_changes(this).execute("1",new_born_count,mobile,sendanimal);
          }
          else{
              int temp1=Integer.parseInt(count.getText().toString())-Integer.parseInt(newborn.getText().toString());
              String death_count=String.valueOf(temp1);
              Globalclass obj=Globalclass.getInstance();
              String mobile=obj.getmob();
              new new_born_and_death_changes(this).execute("2",death_count,mobile,sendanimal);
          }
        }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.sendanimal=ani[position];
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
        this.sendanimal=ani[0];
    }
}
