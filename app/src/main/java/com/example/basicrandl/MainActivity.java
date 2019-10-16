package com.example.basicrandl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences sp  = getSharedPreferences("login",MODE_PRIVATE);

        final EditText etName = (EditText)findViewById(R.id.etName);
        final EditText etPass = (EditText)findViewById(R.id.etPassword);
        Button btnl = (Button)findViewById(R.id.BtnLogin);
        Button btnr = (Button)findViewById(R.id.BtnRegister);

        String ss = sp.getString("username","");
        if(!ss.equals(""))
        {
            Intent displays = new Intent(MainActivity.this , Display.class);
            startActivity(displays);
        }


        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etName.getText().toString();
                String pass = etPass.getText().toString();

                SharedPreferences preferences = getSharedPreferences("myPrefs",MODE_PRIVATE);
                String userDetails = preferences.getString(user + pass + "data" , "Username or password incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Display",userDetails);
                editor.commit();
                String d = preferences.getString("Display","");

                if(d.equals("Username or password incorrect"))
                {
                    Toast.makeText(getApplicationContext(), "Username or password incorrect", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,MainActivity.class));
                }
                else {

                    SharedPreferences.Editor editor2 = sp.edit();
                    editor2.putString("username", user);
                    editor2.commit();


                    Intent displays = new Intent(MainActivity.this, Display.class);
                    startActivity(displays);
                }

            }
        });

        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent rs = new Intent(MainActivity.this , Register.class);
                startActivity(rs);

            }
        });

    }
}
