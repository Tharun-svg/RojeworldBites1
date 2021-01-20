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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class dregister extends AppCompatActivity {
ImageView g;
TextView t;
EditText e1,e2,e3,e4,e5;
Button b;
CircleImageView cb;
String s,s1,s2,s3,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dregister);
        g=findViewById(R.id.img);
        t=findViewById(R.id.reg);
        e1=findViewById(R.id.regName);
        e2=findViewById(R.id.regMobile);
        e3=findViewById(R.id.regEmail);
        e4=findViewById(R.id.phone);
        e5=findViewById(R.id.regPwd);
        b=findViewById(R.id.rt);
        cb=findViewById(R.id.pay);
        AwesomeValidation va=new AwesomeValidation(ValidationStyle.BASIC);
        va.addValidation(this,R.id.regName, RegexTemplate.NOT_EMPTY,R.string.Invalid_name);
        va.addValidation(this,R.id.regMobile, "[5-9]{1}[0-9]{9}$",R.string.Invalid_mobile);
        va.addValidation(this,R.id.regEmail, Patterns.EMAIL_ADDRESS,R.string.Invalid_email);
        va.addValidation(this,R.id.phone, RegexTemplate.NOT_EMPTY,R.string.Invalid_password);
        va.addValidation(this,R.id.regPwd, RegexTemplate.NOT_EMPTY,R.string.type_samepassword);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               String s=e1.getText().toString();
                String s1=e2.getText().toString();
                String s2=e3.getText().toString();
                String s3=e4.getText().toString();
                String s4=e5.getText().toString();
                String url="http://localhost/CodeIgniter/api/User/";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                            }

            }) {
                    protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("data", s);
                            params.put("data", s1);
                            params.put("data", s2);
                            params.put("data", s3);
                            params.put("data", s4);

                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);

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

        g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }

        });
        t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }

        });

    }

}