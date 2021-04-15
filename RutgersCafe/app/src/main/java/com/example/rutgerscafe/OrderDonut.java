package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderDonut extends AppCompatActivity {

    ListView donutListView;
    Spinner qtySpinner;
    TextView donutChoice;
    TextView donutSubtotal;
    double subTotal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_donut);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Donut donut = new Donut();

        donutListView = (ListView) findViewById(R.id.donutListView);
        ArrayList<String> flavorsList;
        flavorsList = (ArrayList<String>) donut.getList();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, flavorsList);
        donutListView.setAdapter(arrayAdapter);

        qtySpinner = (Spinner) findViewById(R.id.spinner);
        Integer[] items = new Integer[]{0, 1, 2, 3, 4, 5};
        ArrayAdapter<Integer> qtyAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, items);
        qtySpinner.setAdapter(qtyAdapter);
        donutSubtotal = (TextView) findViewById(R.id.textView5);


        qtySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int qty = (int) parent.getItemAtPosition(position);
                Donut d = new Donut(qty);
                d.calculateSubTotal();
                subTotal = d.getSubTotal();
                Log.println(Log.INFO, "price", String.valueOf(subTotal));

                donutSubtotal.setText("Subtotal: $" + subTotal);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        donutChoice = (TextView) findViewById(R.id.textView4);

        donutListView.setOnItemClickListener((parent, view, position, id) ->
                donutChoice.setText(donutListView.getItemAtPosition(position).toString()));
    }


}