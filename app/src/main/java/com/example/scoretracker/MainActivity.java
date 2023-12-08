package com.example.scoretracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button plusBtn = findViewById(R.id.plus_btn);
        Button minusBtn = findViewById(R.id.minus_btn);
         result = findViewById(R.id.result);
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

    //attach menu item to app bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
//make menu functionality work

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.reset:
                count=0;
                result.setText(String.valueOf(count));
                break;
            case R.id.setscore:
                count=100;
                result.setText(String.valueOf(count));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT", count);
    }
}