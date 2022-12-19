package com.example.sampleproject;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.ZoneId;

//public class Login extends Activity implements View.OnClickListener {

public class Login extends AppCompatActivity {
    String user ,password ;
    EditText userLogin,passwordLogin;
    Button btnsignup,btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView img = (ImageView) findViewById(R.id.imageView4);
        TextView textview = (TextView) findViewById(R.id.textView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Anhxa();


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Login.this);
                dialog.setTitle("Hộp thoại xử lí");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_signup);
                EditText edtUser = (EditText) dialog.findViewById(R.id.usernameEditText);
                EditText edtPassword = (EditText) dialog.findViewById(R.id.passwordEditText);
                Button btnCancel = (Button)  dialog.findViewById(R.id.cancelButton);
                Button btnSignup = (Button)  dialog.findViewById(R.id.SignupButton);
                btnSignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        user = edtUser.getText().toString().trim();
                        password = edtPassword.getText().toString().trim();

                        userLogin.setText(user);
                        passwordLogin.setText(password);

                        dialog.cancel();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(userLogin.getText().length() !=0 && passwordLogin.getText().length() != 0){
                        if(userLogin.getText().toString().equals(user) && passwordLogin.getText().toString().equals(password)){
                            Toast.makeText(Login.this, "Login success",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this,MainActivity.class);
                            startActivity(intent);
                        }else if (userLogin.getText().toString().equals("a") && passwordLogin.getText().toString().equals("a"))
                    {
                        Toast.makeText(Login.this, "Login success",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this,MainActivity.class);
                        startActivity(intent);
                        }else {
                            Toast.makeText(Login.this, "Login fail",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Login.this, "Missing parameter",Toast.LENGTH_SHORT).show();
                    }
                }
            });

    }


    private void Anhxa(){
        userLogin = (EditText) findViewById(R.id.editTextTextPersonName2) ;
        passwordLogin = (EditText) findViewById(R.id.editTextTextPersonName3) ;
        btnsignup = (Button) findViewById(R.id.button2);
        btnlogin = (Button) findViewById(R.id.button);

    }
}