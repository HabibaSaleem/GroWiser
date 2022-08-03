package com.example.growiser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class logIn extends AppCompatActivity {
    private View view;
    private TextInputLayout layoutEmail,layoutPassword;
    private TextInputEditText txtEmail,txtPassword;
    private TextView txtSignUp,tv;
    private Button btnlogin;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        layoutPassword = findViewById(R.id.txtLayoutPasswordSignIn);
        layoutEmail = findViewById(R.id.txtLayoutEmailSignIn);
        txtPassword = findViewById(R.id.txtPasswordSignIn);
        txtSignUp = findViewById(R.id.txtSignUp);
        txtEmail = findViewById(R.id.txtEmailSignIn);
        btnlogin = findViewById(R.id.btnlogin);
        tv = findViewById(R.id.tv);
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);



//        for no action bar/appbar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }
        });

        //check user already exist? this is because of shared preference
        checkuserexistence();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateEmail() | !validatePassword()) {
                    return;
                }
                processdata(txtEmail.getText().toString(), txtPassword.getText().toString());
            }
        });
    }

    public void processdata(String email, String password)
    {
        Call<responsemodel> call= ApiController.getInstance()
                .getapi()
                .getlogin(email, password);

        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                responsemodel obj= response.body();
                String output= obj.getMessage();
                if(output.equals("incorrect credentials")){
                    txtEmail.setText("");
                    txtPassword.setText("");
                    tv.setTextColor(Color.RED);
                    tv.setText("Invalid username or password");
                }
                if (output.equals("Login successfully")){
                    SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE); //Remember this file name "credentials" for further use
                    SharedPreferences.Editor editor= sp.edit();
                    editor.putString("email",txtEmail.getText().toString());
                    editor.putString("password",txtPassword.getText().toString());
                    editor.commit();
                    editor.apply();

                    Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(logIn.this, "Welcome to GroWiser", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {
                tv.setText("Please check your Internet Connection");
                txtEmail.setText("");
                txtPassword.setText("");

            }
        });

    }

    void checkuserexistence(){
        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE); //here file name "credentials" must be same as mentioned above.
        if (sp.contains("email")){
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(i);
        }
        else{
            tv.setText("Please login");
            tv.setTextColor(Color.RED);
        }

    }



    private boolean validateEmail() {
        //Define Pattern for correct email address
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (txtEmail.getText().toString().isEmpty()) {
            txtEmail.setError("Email is required");
            return false;
        }else if (!txtEmail.getText().toString().matches(emailPattern)){
            txtEmail.setError("Invalid Email Address");
            return false;
        }else {
            txtEmail.setError(null);
            return true;
        }
    }

    //Method of Password Validation
    private boolean validatePassword() {
        if (txtPassword.getText().toString().isEmpty()) {
            txtPassword.setError("Password is required");
            return false;
        } else if (txtPassword.getText().toString().length() < 6) {
            txtPassword.setError("Invalid Password");
            return false;
        } else {
            txtPassword.setError(null);
            return true;
        }
    }


}