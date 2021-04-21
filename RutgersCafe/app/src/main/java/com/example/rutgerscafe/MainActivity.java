package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Order order;
    Store store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        order = new Order();
        store = new Store();
    }


    public void goToDonutActivity(View View) {
        Intent intent = new Intent(MainActivity.this, OrderDonut.class);
        intent.putExtra("ORDER_REFERENCE", order);
        startActivityForResult(intent, 101);
    }

    public void goToCoffeeActivity(View view) {
        Intent intent = new Intent(MainActivity.this, OrderCoffee.class);
        intent.putExtra("ORDER_REFERENCE", order);
        startActivityForResult(intent, 101);

    }

    public void goToOrderDetailActivity(View view) {
        Intent intent = new Intent(MainActivity.this, OrderDetails.class);
        intent.putExtra("ORDER_REFERENCE", order);
        intent.putExtra("STORE_REFERENCE", store);
        startActivityForResult(intent, 102);

    }

    public void goToStoreOrdersActivity(View view) {
        Intent intent = new Intent(MainActivity.this, StoreOrders.class);
        intent.putExtra("ORDER_REFERENCE", order);
        intent.putExtra("STORE_REFERENCE", store);
        startActivityForResult(intent, 102);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            //Toast.makeText(getApplicationContext(),"Level 1", Toast.LENGTH_SHORT).show();
            if (resultCode == RESULT_OK) {
                //Toast.makeText(getApplicationContext(),"Level 2", Toast.LENGTH_SHORT).show();
                if (data != null) {
                    //Toast.makeText(getApplicationContext(),"Level 3", Toast.LENGTH_SHORT).show();
                    this.order = (Order) data.getSerializableExtra("MyData");

                }
            }

        } else if (requestCode == 102) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    this.order = (Order) data.getSerializableExtra("order");
                    this.store = (Store) data.getSerializableExtra("store");
                }
            }
        }
    }
}