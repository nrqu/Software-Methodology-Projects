package com.example.rutgerscafe;

/**
 * StoreOrder activity to represent a store GUI with Orders objects.
 *
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 */

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StoreOrders extends AppCompatActivity {
    ListView storeOrders;
    ArrayList<Order> ordersList;
    ArrayAdapter ordersAdapter;
    Store store;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        storeOrders = findViewById(R.id.storeOrdersListView);
        store = (Store) getIntent().getSerializableExtra("STORE_REFERENCE");
        order = (Order) getIntent().getSerializableExtra("ORDER_REFERENCE");

        ordersList = store.getArr();
        ordersAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, ordersList);
        storeOrders.setAdapter(ordersAdapter);
        storeOrders.setOnItemLongClickListener((parent, view, position, id) -> {

            final int index = position;

            new AlertDialog.Builder(StoreOrders.this)
                    .setIcon(android.R.drawable.ic_delete)
                    .setTitle("Delete Order")
                    .setMessage("delete order?")
                    .setPositiveButton("YES", (dialog, which) -> {
                        store.remove(storeOrders.getItemAtPosition(index));
                        ordersAdapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("store", store);
        intent.putExtra("order", order);

        setResult(RESULT_OK, intent);
        finish();
    }
}