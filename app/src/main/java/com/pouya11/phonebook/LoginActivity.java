package com.pouya11.phonebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText          txtPassword;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("com.pouya11.phonebook", MODE_PRIVATE);

        txtPassword = (EditText) findViewById(R.id.txt_password);
    }

    public void btnLoginClicked(View view) {
        if(txtPassword.getText().toString().equals(
                sharedPreferences.getString("password", "123456"))){
            startActivity(new Intent(this, MainActivity.class));
        }else{
            Toast.makeText(this, "Wrong password", Toast.LENGTH_LONG).show();
        }
    }
}
