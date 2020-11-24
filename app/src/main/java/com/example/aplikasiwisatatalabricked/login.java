package com.example.aplikasiwisatatalabricked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    public static class Login extends AppCompatActivity implements View.OnClickListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            Button masuk = findViewById(R.id.login1);
            masuk.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.login1) {
                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }
}