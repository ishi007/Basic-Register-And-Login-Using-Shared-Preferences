package com.example.basicrandl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {

    Button bu=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        final SharedPreferences preferences = getSharedPreferences("login",MODE_PRIVATE);

        SharedPreferences sp = getSharedPreferences("myPrefs",MODE_PRIVATE);

        String display = preferences.getString("username","");


        TextView displayInfo = (TextView)findViewById(R.id.textViewName);


        displayInfo.setText("Hello\n"+display);

        bu=(Button)findViewById(R.id.button);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor e = preferences.edit();
                e.clear();
                e.commit();

                startActivity(new Intent(Display.this,MainActivity.class));
                finish();   //finish current activity
            }
        });

    }
}
