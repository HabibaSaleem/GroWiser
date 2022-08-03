package com.example.growiser;

import static java.security.AccessController.*;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.AccessController;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    private TextInputLayout layoutUsername,layoutEmail,layoutPassword,layoutConfirmPassword;
    private TextInputEditText txtUsername,txtEmail,txtPassword,txtConfirmPassword;
    private TextView txtLogin, tv;
    private Button btnSignUp;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        layoutUsername = findViewById(R.id.txtLayoutUsernameSignUp);
        layoutPassword = findViewById(R.id.txtLayoutPasswordSignUp);
        layoutEmail = findViewById(R.id.txtLayoutEmailSignUp);
        layoutConfirmPassword = findViewById(R.id.txtLayoutConfirmPasswordSignUp);
        txtUsername = findViewById(R.id.txtUsernameSignUp);
        txtEmail = findViewById(R.id.txtEmailSignUp);
        txtPassword = findViewById(R.id.txtPasswordSignUp);
        txtConfirmPassword = findViewById(R.id.txtConfirmPasswordSignUp);
        btnSignUp = findViewById(R.id.btnSignUp);
        txtLogin = findViewById(R.id.txtLogin);
        tv = findViewById(R.id.tv);
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);

//        for no action bar/appbar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), logIn.class);
                startActivity(i);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateUserName() | !validateEmail() | !validatePassword() | !validateConfirmPassword()) {
                    return;
                }
                processdata(txtUsername.getText().toString(), txtEmail.getText().toString(), txtPassword.getText().toString(), txtConfirmPassword.getText().toString());
            }
        });
    }

    public void processdata(String name, String email, String password, String confirm_password)
    {
            Call<responsemodel> call= ApiController.getInstance()
                    .getapi()
                    .getregister(name, email, password, confirm_password);

            call.enqueue(new Callback<responsemodel>() {
                @Override
                public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                    responsemodel obj= response.body();
                    Toast.makeText(SignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    txtUsername.setText("");
                    txtEmail.setText("");
                    txtPassword.setText("");
                    txtConfirmPassword.setText("");
                    Intent i = new Intent(getApplicationContext(), logIn.class);
                    startActivity(i);
                    finish();

                }


                @Override
                public void onFailure(Call<responsemodel> call, Throwable t) {
                    tv.setText("Something went wrong");
                    txtUsername.setText("");
                    txtEmail.setText("");
                    txtPassword.setText("");
                    txtConfirmPassword.setText("");


                }
            });




    }

    //Validations Methods

    //Method of Username Validation
    private boolean validateUserName() {
        if (txtUsername.getText().toString().isEmpty()) {
            txtUsername.setError("Username is required");
            return false;
        }
        return true;
    }

    //Method of Email Validation
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
            txtPassword.setError("Password must be of 6 characters");
            return false;
        } else {
            txtPassword.setError(null);
            return true;
        }
    }

    //Method of Confirm Password Validation
    private boolean validateConfirmPassword() {
        if (txtConfirmPassword.getText().toString().isEmpty()) {
            txtConfirmPassword.setError("Confirm Password is required");
            return false;
        } else if (!txtConfirmPassword.getText().toString().equals(txtPassword.getText().toString())){
            txtConfirmPassword.setError("Password does not match");
            return false;
        } else {
            txtConfirmPassword.setError(null);
            return true;
        }
    }






}

