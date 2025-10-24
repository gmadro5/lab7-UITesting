package com.example.androiduitesting;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView cityNameText = findViewById(R.id.textView_cityName);
        Button backButton = findViewById(R.id.button_back);

        // Get city name from the intent
        Intent intent = getIntent();
        String cityName = intent.getStringExtra("city_name");

        cityNameText.setText(cityName);

        // Back button returns to MainActivity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // finishes this activity and goes back to MainActivity
            }
        });
    }
}