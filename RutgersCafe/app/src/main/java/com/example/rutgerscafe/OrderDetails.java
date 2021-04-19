package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {
    Order order;
    Store store;
    ListView orderItemList;
    TextView subtotalTV;
    TextView taxTV;
    TextView totalTV;
    Button remove;
    ArrayList<MenuItem> orderItems;
    ArrayAdapter arrayAdapter;
     static int flag = 0;
     int selectedIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        selectedIndex = -1;
        order = (Order)getIntent().getSerializableExtra("ORDER_REFERENCE");
        store = (Store) getIntent().getSerializableExtra("STORE_REFERENCE");

        orderItemList = (ListView) findViewById(R.id.orderItemList);
        orderItems = order.getArr();

        arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, orderItems);
        orderItemList.setAdapter(arrayAdapter);


        orderItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
            }
        });

        setPrice();
        /*
        if(flag == 0) {
            order.remove(orderItems.get(0));
            flag = 1;
        }
        */

//        order.remove(orderItems.);
 //       System.out.println("size of order:" + order.getArr().size());
  //      System.out.println("size of list:" + orderItems.size());
//        remove();



    }
    public void removeItem(View view) {
        if(selectedIndex > -1){
            order.remove(orderItemList.getItemAtPosition(selectedIndex));
            arrayAdapter.notifyDataSetChanged();
            selectedIndex = -1;
            setPrice();
        }
    }
    public  void placeOrder(View view){
        if(arrayAdapter.getCount() > 0){
            if(store.add(order)){
                order = new Order();
                arrayAdapter = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, order.getArr());
                orderItemList.setAdapter(arrayAdapter);
                setPrice();
            }
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

    void setPrice() {
        double subTotal = 0.0;
        double taxes = 0.0;
        double total = 0.0;

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
        taxTV.setText("Subtotal: $" + String.format("%.2f", taxes));
        totalTV.setText("Subtotal: $" + String.format("%.2f", total));
    }























//    void remove() {
//        orderItemList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
////                order.print();
//                arrayAdapter.remove(arrayAdapter.getItem(position));
////                    arrayAdapter.remove();
////                order.remove(arrayAdapter.getItem(position));
//                System.out.println("size of order:" + order.getArr().size());
//                System.out.println("size of list:" + orderItems.size());
//
//                arrayAdapter.notifyDataSetChanged();
//
//                return false;
//            }
//        });
//
//    }
/*
    void setPrice() {
        double subTotal = 0.0;
        double taxes = 0.0;
        double total;

        subtotalTV = findViewById(R.id.subtotalOrderTxtView);
        taxTV = findViewById(R.id.taxTxtView);
        totalTV = findViewById(R.id.totalTxtView);
        System.out.println(order.getArr().size());

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
        taxTV.setText("Subtotal: $" + String.format("%.2f", taxes));
        totalTV.setText("Subtotal: $" + String.format("%.2f", total));
    }
*/
}