package com.example.login_r2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.PrivilegedAction;

public class HomeActivity extends AppCompatActivity {

    TextView tvUsername;
    Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUsername = findViewById(R.id.tvUsername);
        btnLogout= findViewById(R.id.btnLogout);

        SharedPreferences sPref = getApplicationContext()
                .getSharedPreferences(MainActivity.FILENAME, MODE_PRIVATE);
        tvUsername.setText(sPref.getString(MainActivity.NAME_KEY, ""));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sPref.edit();
                editor.remove(MainActivity.NAME_KEY);
                editor.commit();

                Intent intent = new Intent(HomeActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}