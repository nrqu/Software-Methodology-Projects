package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToDonutActivity();
        goToCoffeeActivity();
    }

    public void goToDonutActivity() {
        ImageButton donutButton = (ImageButton) findViewById(R.id.orderDonutButton);
        donutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OrderDonut.class));
            }
        });
    }

    public void goToCoffeeActivity() {
        ImageButton coffeeButton = (ImageButton) findViewById(R.id.orderCoffeButton);
        coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OrderCoffee.class));
            }
        });
    }


}