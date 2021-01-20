package com.example.rojeworldbites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class order extends AppCompatActivity {
Button b,b1;
ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
       b= findViewById(R.id.p);
       i=findViewById(R.id.gf);
       b1=findViewById(R.id.close);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), orderHistory.class);
                startActivity(intent);
            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cart.class);
                startActivity(intent);
            }

        });
        i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }

        });
    }
}