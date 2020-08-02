package com.example.rameshsih;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
public class dashboard extends AppCompatActivity {
    ImageView profile,mylivestock,update,transfer,medical,statistics,verify,notverify;
    SharedPreferences pref;
    TextView Id;
    RadioGroup veripend;
    RadioButton veri,pend;
    Button ap;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        profile=findViewById(R.id.profile);
        update=findViewById(R.id.updateb);
        transfer=findViewById(R.id.transfer);
        //medical=findViewById(R.id.medical);
        Id=findViewById(R.id.textGrid);
        veripend=findViewById(R.id.veripend);
        veri=findViewById(R.id.veri);
        pend=findViewById(R.id.pend);
        ap=findViewById(R.id.approve);
        Globalclass obj=Globalclass.getInstance();
        Id.setText(obj.getId());
        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(veri.isChecked()){
                    new veripend(dashboard.this).execute("Verified");
                }
                if(pend.isChecked()){
                    new veripend(dashboard.this).execute("Not_Verified");
                }
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(dashboard.this,profile.class);
                startActivity(i);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(dashboard.this,update.class);
                startActivity(i);
            }
        });
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(dashboard.this,transfer.class);
                startActivity(i);
            }
        });
        /*medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(dashboard.this,medical.class);
                startActivity(i);
            }
        });*/

    }

}