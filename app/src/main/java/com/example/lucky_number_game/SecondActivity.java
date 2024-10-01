package com.example.lucky_number_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textViewLuckyNumber;
    Button buttonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get intent data
        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        int luckyNumber = intent.getIntExtra("LUCKY_NUMBER", 0);

        // Set views
        TextView textViewUserName = findViewById(R.id.textViewUserName);
        textViewLuckyNumber = findViewById(R.id.textViewLuckyNumber);
        buttonShare = findViewById(R.id.buttonShare);

        textViewUserName.setText(userName + "'s Lucky Number");
        textViewLuckyNumber.setText(String.valueOf(luckyNumber));

        // Share button click event
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create sharing intent
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, userName + "'s lucky number is " + luckyNumber);
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, "Share your lucky number with:"));
            }
        });
    }
}
