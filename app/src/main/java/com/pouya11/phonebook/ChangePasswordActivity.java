package com.pouya11.phonebook;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText txtNewPassword;
    EditText txtNewPasswordConfirm;
    EditText txtCurrentPassword;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        sharedPreferences = getSharedPreferences("com.pouya11.phonebook", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        txtNewPassword = (EditText) findViewById(R.id.txt_new_password);
        txtNewPasswordConfirm = (EditText) findViewById(R.id.txt_new_password_confirm);
        txtCurrentPassword = (EditText) findViewById(R.id.txt_current_password);
    }

    public void btnChangeClicked(View view) {
        String newPassword = txtNewPassword.getText().toString();
        String newPasswordConfirm = txtNewPasswordConfirm.getText().toString();
        String currentPassword = txtCurrentPassword.getText().toString();

        if(!newPassword.equals(newPasswordConfirm)){
            Toast.makeText(this, "new password and confrim are not same!",
                    Toast.LENGTH_LONG).show();
        }else if(!currentPassword.equals("123456")){
            Toast.makeText(this, "Current password is wrong!",
                    Toast.LENGTH_LONG).show();
        }else{
            sharedPreferencesEditor.putString("password", newPassword);
            sharedPreferencesEditor.commit();
        }
    }

    public void btnCancelClicked(View view) {
        finish();
    }
}
