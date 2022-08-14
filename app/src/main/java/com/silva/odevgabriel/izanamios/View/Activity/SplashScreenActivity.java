package com.silva.odevgabriel.izanamios.View.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.silva.odevgabriel.izanamios.Constants.App;
import com.silva.odevgabriel.izanamios.R;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        App.TAG = getResources().getString(R.string.app_name);

        this.mAuth = FirebaseAuth.getInstance();
        this.currentUser = mAuth.getCurrentUser();

        autoDelay();
    }

    private void autoDelay() {
        Intent intent;

        if(this.currentUser == null) {
            intent = new Intent(SplashScreenActivity.this, SignInAndSignUpActivity.class);
        } else {
            intent = new Intent(SplashScreenActivity.this, SplashScreenActivity.class);
        }

        final Runnable r = () -> {
            startActivity(intent);
            finish();
        };

        new Handler().postDelayed(r, 500);
    }
}