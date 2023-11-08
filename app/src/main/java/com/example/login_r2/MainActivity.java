package com.example.login_r2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSplashHeading;
    public static final String FILENAME = "checklogin";
    public static final String NAME_KEY = "name_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSplashHeading = findViewById(R.id.tvSplashHeading);

        Animation bouncing = AnimationUtils
                .loadAnimation(MainActivity.this, R.anim.bouncing);

        tvSplashHeading.setAnimation(bouncing);

        SharedPreferences sPref = getApplicationContext()
                .getSharedPreferences(FILENAME, MODE_PRIVATE);
        String temp = sPref.getString(NAME_KEY,"");
        if(temp.isEmpty())
        {
            new Handler()
                    .postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this,
                                    LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 4000);
        }
        else
        {
            new Handler()
                    .postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this,
                                    HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 4000);
        }

    }
}