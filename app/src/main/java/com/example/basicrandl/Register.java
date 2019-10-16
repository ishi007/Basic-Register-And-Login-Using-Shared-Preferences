package com.example.basicrandl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regis);

        final EditText userName = (EditText)findViewById(R.id.etNewName);
        final EditText password = (EditText)findViewById(R.id.etNewPassword);
        final EditText email = (EditText)findViewById(R.id.etNewEmail);

        Button btnRegister = (Button)findViewById(R.id.btnNewRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("myPrefs",MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newUser + newPassword + "data" ,newUser + "\n" + newEmail);
                editor.commit();

                Intent loginScreen = new Intent(Register.this , MainActivity.class);
                startActivity(loginScreen);

            }
        });

    }
}
