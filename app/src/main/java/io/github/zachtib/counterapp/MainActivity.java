package io.github.zachtib.counterapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER_KEY = "COUNTER_KEY";

    private int counter = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = ApiKey.API_KEY;
        Log.d("MainActivity", apiKey);

        Button counterButton = findViewById(R.id.counterButton);
        TextView counterTextView = findViewById(R.id.counterTextView);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_KEY);
            counterTextView.setText(String.valueOf(counter));
        }

        counterButton.setOnClickListener(v -> counterTextView.setText(String.valueOf(++counter)));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY, counter);
    }
}
