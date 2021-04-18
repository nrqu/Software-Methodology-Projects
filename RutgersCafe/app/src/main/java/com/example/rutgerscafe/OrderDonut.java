package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderDonut extends AppCompatActivity {

    ListView donutListView;
    Spinner qtySpinner;
    TextView donutChoice;
    TextView donutSubtotal;
    double subTotal = 0.0;
    Donut donut;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_donut);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        order = (Order)getIntent().getSerializableExtra("ORDER_REFERENCE");

        setDonutListView();
        setQtySpinner();
        updateSubtotal();
        setDonutChoiceText();
    }

    public void setDonutListView() {
        Donut donut = new Donut();
        donutListView = findViewById(R.id.donutListView);
        ArrayList<String> flavorsList;
        flavorsList = (ArrayList<String>) donut.getList();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, flavorsList);
        donutListView.setAdapter(arrayAdapter);
    }

    public void setQtySpinner() {
        qtySpinner = findViewById(R.id.spinner);
        Integer[] items = new Integer[]{0, 1, 2, 3, 4, 5};
        ArrayAdapter<Integer> qtyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        qtySpinner.setAdapter(qtyAdapter);
    }

    public void updateSubtotal() {
        donutSubtotal = findViewById(R.id.subtotalView);
        qtySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int qty = (int) parent.getItemAtPosition(position);
                donut = new Donut(donutChoice.getText().toString(), qty);
                donut.calculateSubTotal();
                subTotal = donut.getSubTotal();
                donutSubtotal.setText("Subtotal: $" +  String.format("%.2f", subTotal));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void setDonutChoiceText () {
        donutChoice = findViewById(R.id.donutChoiceView);
        donutChoice.setText(donutListView.getItemAtPosition(0).toString());
        donutListView.setOnItemClickListener((parent, view, position, id) ->
                donutChoice.setText(donutListView.getItemAtPosition(position).toString()));
    }

    /*
    * function definition
    * */
    public void addToOrder(View v) {
        Context context = getApplicationContext();
        String msg;

        int duration = Toast.LENGTH_SHORT;

        if(subTotal != 0) {
            msg = donutChoice.getText().toString() + " added to order!.";

            order.add(donut);

            qtySpinner.setSelection(0);

        }
        else
            msg = "Select a donut quantity!";

        Toast toast = Toast.makeText(context,msg, duration);
        toast.show();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("MyData", order);
        setResult(RESULT_OK, intent);
        finish();
    }


}