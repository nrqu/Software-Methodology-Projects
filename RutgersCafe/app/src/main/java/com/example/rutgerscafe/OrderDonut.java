package com.example.rutgerscafe;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * This class is used as the donut GUI for the activity created by the
 * the MainActivity class.
 *
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 */
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
        order = (Order) getIntent().getSerializableExtra("ORDER_REFERENCE");

        setDonutListView();
        setQtySpinner();
        updateSubtotal();
        setDonutChoiceText();
    }

    /**
     * It fetches a list view with an array list of strings from the Donut class.
     */
    public void setDonutListView() {
        Donut donut = new Donut();
        donutListView = findViewById(R.id.donutListView);
        ArrayList<String> flavorsList;
        flavorsList = (ArrayList<String>) donut.getList();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, flavorsList);
        donutListView.setAdapter(arrayAdapter);
    }

    /**
     * It sets a spinner with an integer array.
     */
    public void setQtySpinner() {
        qtySpinner = findViewById(R.id.spinner);
        Integer[] items = new Integer[]{0, 1, 2, 3, 4, 5};
        ArrayAdapter<Integer> qtyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, items);
        qtySpinner.setAdapter(qtyAdapter);
    }

    /**
     * It updates the the subtotal textView according to the quantity selected.
     */
    public void updateSubtotal() {
        donutSubtotal = findViewById(R.id.subtotalView);
        qtySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int qty = (int) parent.getItemAtPosition(position);
                donut = new Donut(donutChoice.getText().toString(), qty);
                donut.itemPrice();
                subTotal = donut.getSubTotal();
                donutSubtotal.setText("Subtotal: $" + String.format("%.2f", subTotal));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    /**
     * It sets a textView with the flavor at index 0 from the donutListView.
     */
    public void setDonutChoiceText() {
        donutChoice = findViewById(R.id.donutChoiceView);
        donutChoice.setText(donutListView.getItemAtPosition(0).toString());
        donutListView.setOnItemClickListener((parent, view, position, id) ->
                donutChoice.setText(donutListView.getItemAtPosition(position).toString()));
    }

    /**
     * It adds a Donut object to an Order object and display a toast message whether the Donut
     * object was added or not.
     */
    public void addToOrder(View v) {
        String msg;

        if (subTotal != 0) {
            msg = donutChoice.getText().toString() + " added to order!.";
            order.add(donut);
            qtySpinner.setSelection(0);

        } else
            msg = "Select a donut quantity!";

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

    }

    /**
     * It transfer the Donut object information to the Order class.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("MyData", order);
        setResult(RESULT_OK, intent);
        finish();
    }
}