package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Class used as the main activity for the app
 *
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 */
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

    /**
     * Starts the donut activity when the button is pressed.
     * @param View
     */
    public void goToDonutActivity(View View) {
        Intent intent = new Intent(MainActivity.this, OrderDonut.class);
        intent.putExtra("ORDER_REFERENCE", order);
        startActivityForResult(intent, 101);
    }
    /**
     * Starts the Coffee activity when the button is pressed.
     * @param View
     */
    public void goToCoffeeActivity(View view) {
        Intent intent = new Intent(MainActivity.this, OrderCoffee.class);
        intent.putExtra("ORDER_REFERENCE", order);
        startActivityForResult(intent, 101);

    }
    /**
     * Starts the Order detail activity when the button is pressed.
     * @param View
     */
    public void goToOrderDetailActivity(View view) {
        Intent intent = new Intent(MainActivity.this, OrderDetails.class);
        intent.putExtra("ORDER_REFERENCE", order);
        intent.putExtra("STORE_REFERENCE", store);
        startActivityForResult(intent, 102);

    }
    /**
     * Starts the Store page activity when the button is pressed.
     * @param View
     */
    public void goToStoreOrdersActivity(View view) {
        Intent intent = new Intent(MainActivity.this, StoreOrders.class);
        intent.putExtra("ORDER_REFERENCE", order);
        intent.putExtra("STORE_REFERENCE", store);
        startActivityForResult(intent, 102);
    }

    /**
     * Receives the results back from the activites and stores them in the object insteated in this class.
     * @param requestCode
     * @param resultCode
     * @param data
     */
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