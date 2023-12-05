package com.example.scoretracker;

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

        plusBtn.setOnClickListener(view -> {
            count++;
            result.setText(String.valueOf(count));
        });

        minusBtn.setOnClickListener(view -> {
            count--;
            result.setText(String.valueOf(count));
        });
    }
}