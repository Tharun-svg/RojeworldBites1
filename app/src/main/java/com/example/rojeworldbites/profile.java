package com.example.rojeworldbites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class profile extends AppCompatActivity {
ImageView r;
EditText e1,e2,e3,e4,e5;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        r=findViewById(R.id.gf);
        e1=findViewById(R.id.Name);
        e2=findViewById(R.id.Mobile);
        e3=findViewById(R.id.Email);
        e4=findViewById(R.id.Vehicle);
        e5=findViewById(R.id.Type);
        b=findViewById(R.id.f);
        r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }

        });
        AwesomeValidation va=new AwesomeValidation(ValidationStyle.BASIC);
        va.addValidation(this,R.id.Name, RegexTemplate.NOT_EMPTY,R.string.Invalid_name);
        va.addValidation(this,R.id.Mobile, "[5-9]{1}[0-9]{9}$",R.string.Invalid_mobile);
        va.addValidation(this,R.id.Email, Patterns.EMAIL_ADDRESS,R.string.Invalid_email);
        va.addValidation(this,R.id.Vehicle, RegexTemplate.NOT_EMPTY,R.string.Invalid_vehicle);
        va.addValidation(this,R.id.Type, RegexTemplate.NOT_EMPTY,R.string.Invalid_type);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               if(va.validate())
               {
                   Toast.makeText(getApplicationContext(), "validation sucess", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(getApplicationContext(), "validation", Toast.LENGTH_SHORT).show();
               }
            }

        });
    }
}