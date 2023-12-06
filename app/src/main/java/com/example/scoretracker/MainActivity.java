package com.example.scoretracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button plusBtn = findViewById(R.id.plus_btn);
        Button minusBtn = findViewById(R.id.minus_btn);
        TextView result = findViewById(R.id.result);
        if (savedInstanceState != null && savedInstanceState.containsKey("COUNT")) {
            count = savedInstanceState.getInt("COUNT");
            result.setText(String.valueOf(count));
        }
        plusBtn.setOnClickListener(view -> {
            count++;
            result.setText(String.valueOf(count));
        });

        minusBtn.setOnClickListener(view -> {
            count--;
            result.setText(String.valueOf(count));
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT", count);
    }
}