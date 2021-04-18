package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        order = new Order();

        //goToDonutActivity();
        //goToCoffeeActivity();
        //goToOrderDetailActivity();
        goToStoreOrdersActivity();
    }

    public void goToDonutActivity(View View) {
        ImageButton donutButton = findViewById(R.id.orderDonutButton);
//        donutButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, OrderDonut.class)));
        Intent intent = new Intent(MainActivity.this, OrderDonut.class);
        intent.putExtra("ORDER_REFERENCE",order);
        startActivityForResult(intent,101);
    }

    public void goToCoffeeActivity(View view) {
        //ImageButton coffeeButton = findViewById(R.id.orderCoffeButton);
        Intent intent = new Intent(MainActivity.this, OrderCoffee.class);
        intent.putExtra("ORDER_REFERENCE",order);
        startActivityForResult(intent,101);

    }

    public void goToOrderDetailActivity(View view) {
        ImageButton orderButton = findViewById(R.id.orderButton);
        Intent intent = new Intent(MainActivity.this, OrderDetails.class);
        intent.putExtra("ORDER_REFERENCE2",order);
        startActivityForResult(intent,101);

    }

    public void goToStoreOrdersActivity() {
        ImageButton storeButton = findViewById(R.id.storeOrdersButton);
        storeButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, StoreOrders.class)));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 ) {
            Toast.makeText(getApplicationContext(),"Level 1", Toast.LENGTH_SHORT).show();
            if( resultCode == RESULT_OK ){
                Toast.makeText(getApplicationContext(),"Level 2", Toast.LENGTH_SHORT).show();

                if(data != null){
                    Toast.makeText(getApplicationContext(),"Level 3", Toast.LENGTH_SHORT).show();

                    this.order = (Order)data.getSerializableExtra("MyData");
                    order.print();
                }
            }

        }
    }
}