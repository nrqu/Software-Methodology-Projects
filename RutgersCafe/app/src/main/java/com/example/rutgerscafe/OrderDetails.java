package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {
    Order order;
    Store store;
    ListView orderItemList;
    TextView subtotalTV;
    TextView taxTV;
    TextView totalTV;
    ArrayList<MenuItem> orderItems;
    ArrayAdapter arrayAdapter;
    int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        selectedIndex = -1;
        order = (Order) getIntent().getSerializableExtra("ORDER_REFERENCE");
        store = (Store) getIntent().getSerializableExtra("STORE_REFERENCE");

        orderItemList = findViewById(R.id.orderItemList);
        orderItems = order.getArr();

        arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, orderItems);
        orderItemList.setAdapter(arrayAdapter);

        orderItemList.setOnItemClickListener((parent, view, position, id) -> selectedIndex = position);
        setPrice();
    }

    /**
     * It removes a Donut or Coffee object from the Order object.
     *
     * @param view base class for widgets.
     */

    public void removeItem(View view) {
        if (selectedIndex > -1) {
            order.remove(orderItemList.getItemAtPosition(selectedIndex));
            arrayAdapter.notifyDataSetChanged();
            selectedIndex = -1;
            setPrice();
            Toast.makeText(getApplicationContext(), "Item removed!!!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * It adds Order objects into a Store object.
     *
     * @param view base class for widgets.
     */

    public void placeOrder(View view) {
        if (arrayAdapter.getCount() > 0) {
            if (store.add(order)) {
                order = new Order();
                arrayAdapter = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, order.getArr());
                orderItemList.setAdapter(arrayAdapter);
                Toast.makeText(getApplicationContext(), "Order placed!!!", Toast.LENGTH_SHORT).show();
                setPrice();
            }
        } else {
            Toast.makeText(getApplicationContext(), "No items in your order", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("order", order);
        intent.putExtra("store", store);

        setResult(RESULT_OK, intent);
        finish();
    }

    /**
     * calculates the sub-total,tax and total of the order
     **/

    void setPrice() {
        double subTotal = 0.0;
        double taxes = 0.0;
        double total;

        subtotalTV = findViewById(R.id.subtotalOrderTxtView);
        taxTV = findViewById(R.id.taxTxtView);
        totalTV = findViewById(R.id.totalTxtView);


        if (!order.getArr().isEmpty()) {
            for (MenuItem a : order.getArr()) {
                subTotal += a.getSubTotal();
            }
            if (subTotal > 0) {
                taxes = subTotal * 0.06625;
            }
            total = subTotal + taxes;
            order.setTotal(total);

        } else {
            subTotal = 0.0;
            taxes = 0.0;
            total = 0.0;
        }
        subtotalTV.setText("Subtotal: $" + String.format("%.2f", subTotal));
        taxTV.setText("Tax: $" + String.format("%.2f", taxes));
        totalTV.setText("Total: $" + String.format("%.2f", total));
    }
}