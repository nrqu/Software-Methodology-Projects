package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {
    Order order;
    ListView orderItemList;
    TextView subtotalTV;
    TextView taxTV;
    TextView totalTV;
    Button remove;
    ArrayList<MenuItem> orderItems;
    ArrayAdapter arrayAdapter;
     static int flag = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);


        order = (Order)getIntent().getSerializableExtra("ORDER_REFERENCE2");
        orderItemList = (ListView) findViewById(R.id.orderItemList);
        orderItems = order.getArr();

        arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, orderItems);
        orderItemList.setAdapter(arrayAdapter);

        setPrice();
        if(flag == 0) {
            order.remove(orderItems.get(0));
            flag = 1;
        }
//        order.remove(orderItems.);
        System.out.println("size of order:" + order.getArr().size());
        System.out.println("size of list:" + orderItems.size());
//        remove();



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

    public void removeItem(View view) {
        order.print();

    }
}