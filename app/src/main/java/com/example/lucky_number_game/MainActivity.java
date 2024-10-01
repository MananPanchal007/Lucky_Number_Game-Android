package com.example.lucky_number_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonWishMeLuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        buttonWishMeLuck = findViewById(R.id.buttonWishMeLuck);

        // Button click event
        buttonWishMeLuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextName.getText().toString();
                if (userName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter your Name", Toast.LENGTH_SHORT).show();
                } else {
                    // Generate random number
                    Random random = new Random();
                    int luckyNumber = random.nextInt(100); // Random number from 0 to 99

                    // Pass data to second activity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("USER_NAME", userName);
                    intent.putExtra("LUCKY_NUMBER", luckyNumber);
                    startActivity(intent);
                }
            }
        });
    }
}
