 package com.example.rojeworldbites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import de.hdodenhof.circleimageview.CircleImageView;

 public class login extends AppCompatActivity {
ImageView r;

Button b;
TextView t,t1;
EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        r=findViewById(R.id.gf);
        b=findViewById(R.id.b);
        t=findViewById(R.id.log);
        e1=findViewById(R.id.e);
        e2=findViewById(R.id.p);
       // rs=findViewById(R.id.c);
        t1=findViewById(R.id.order);
        r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

        });
        t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), dregister.class);
                startActivity(intent);
            }

        });
        AwesomeValidation va=new AwesomeValidation(ValidationStyle.BASIC);
             va.addValidation(this,R.id.e, Patterns.EMAIL_ADDRESS,R.string.Invalid_email);
        va.addValidation(this,R.id.p, RegexTemplate.NOT_EMPTY,R.string.Invalid_pass);
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
        t1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), order.class);
                startActivity(intent);
            }

        });
      /*  rs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
            }

        });*/
    }
}