package com.example.growiser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class testingActivity extends AppCompatActivity {
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        checkuserexistence();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                sp.edit().remove("email").commit();
                sp.edit().remove("password").commit();
                sp.edit().apply();
                Intent i = new Intent(getApplicationContext(), logIn.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void checkuserexistence(){
        SharedPreferences sp= getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("email"))
            tv.setText(sp.getString("email", ""));
        else{
            Intent i = new Intent(getApplicationContext(), logIn.class);
            startActivity(i);
        }

    }
}