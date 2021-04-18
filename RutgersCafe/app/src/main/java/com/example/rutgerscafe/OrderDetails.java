package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class OrderDetails extends AppCompatActivity {
    Order order;
    ListView orderItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        order = (Order)getIntent().getSerializableExtra("ORDER_REFERENCE2");
        orderItemList = (ListView) findViewById(R.id.orderItemList);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, order.getArr());
        orderItemList.setAdapter(arrayAdapter);
    }

}