package com.silva.odevgabriel.izanamios.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.silva.odevgabriel.izanamios.R;

public class MainActivity extends AppCompatActivity {

    private final ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.mTextView = findViewById(R.id.text);

        this.setListeners();
    }

    private void setListeners() {
        mViewHolder.mTextView.setOnClickListener(
                v -> startActivity(new Intent(MainActivity.this, SplashScreenActivity.class))
        );
    }

    private static class ViewHolder {
        TextView mTextView;
    }
}