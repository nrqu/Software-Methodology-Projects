package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        order = new Order();

        goToDonutActivity();
        goToCoffeeActivity();
        goToOrderDetailActivity();
        goToStoreOrdersActivity();
    }

    public void goToDonutActivity() {
        ImageButton donutButton = findViewById(R.id.orderDonutButton);
        donutButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, OrderDonut.class)));
    }

    public void goToCoffeeActivity() {
        ImageButton coffeeButton = findViewById(R.id.orderCoffeButton);
        Intent intent = new Intent(MainActivity.this, OrderCoffee.class);
        intent.putExtra("ORDER_REFERENCE",order);
        coffeeButton.setOnClickListener(v -> startActivity(intent));

    }

    public void goToOrderDetailActivity() {
        ImageButton orderButton = findViewById(R.id.orderButton);
        orderButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, OrderDetails.class)));

    }

    public void goToStoreOrdersActivity() {
        ImageButton storeButton = findViewById(R.id.storeOrdersButton);
        storeButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, StoreOrders.class)));
    }
    public Order getOrderReference(){
        return order;
    }

}