package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.widget.AdapterView;
import android.view.View;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderCoffee extends AppCompatActivity {

    String[] coffeeSizesList = {"Choose Size","Short", "Tall", "Grande","Venti"};
    Spinner sizeSpinner;
    CheckBox addonCream;
    CheckBox addonWhippedCream;
    CheckBox addonCaramel;
    CheckBox addonMilk;
    CheckBox addonSyrup;
    TextView subtotal;
    Coffee coffee;
    Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_coffee);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setCoffeeSizeSpinner();
        setCheckBoxOwners();
        coffee = new Coffee();
        order = (Order)getIntent().getSerializableExtra("ORDER_REFERENCE");


        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateSubtotal();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void setCoffeeSizeSpinner() {
        sizeSpinner = findViewById(R.id.coffeeSizes);
        ArrayAdapter<String> qtyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, coffeeSizesList);
        sizeSpinner.setAdapter(qtyAdapter);


        subtotal = (TextView) findViewById(R.id.coffeeSubtotal);
    }

    private void setCheckBoxOwners(){
        addonCream = (CheckBox) findViewById(R.id.addonCream);
        addonWhippedCream = (CheckBox) findViewById(R.id.addonWhippedCream);
        addonCaramel = (CheckBox) findViewById(R.id.addonCaramel);
        addonSyrup = (CheckBox) findViewById(R.id.addonMilk);
        addonMilk = (CheckBox) findViewById(R.id.addonSyrup);


    }
    private void updateSubtotal() {

        if(sizeSpinner.getSelectedItemPosition() > -1) {
            coffee.setCoffeeSize(sizeSpinner.getSelectedItemPosition());
            if(addonCream.isChecked())
                coffee.add("Whipped Cream");
            else
                coffee.remove("Whipped Cream");

            if(addonSyrup.isChecked())
                coffee.add("Syrup");
            else
                coffee.remove("Syrup");

            if(addonMilk.isChecked())
                coffee.add("Milk");
            else
                coffee.remove("Milk");

            if(addonCaramel.isChecked())
                coffee.add("Caramel");
            else
                coffee.remove("Caramel");
            if(addonWhippedCream.isChecked())
                coffee.add("Cream");
            else
                coffee.remove("Cream");

            coffee.calculateSubTotal();

            if(coffee.getSubTotal() > 0.0)
                subtotal.setText("Subtotal: $" + String.format("%.2f",coffee.getSubTotal())+"\n");
            else
                subtotal.setText("Subtotal: $0.00");
        }
    }
    public void onClickAddons(View view){
        updateSubtotal();
    }
    public void placeOrder(View view){
        if(sizeSpinner.getSelectedItemPosition() > 0) {
            if (order.add(coffee)) {
                Toast toast = Toast.makeText(getApplicationContext(), "Coffee added to Order!", Toast.LENGTH_SHORT);
                toast.show();
                addonWhippedCream.setChecked(false);
                addonCaramel.setChecked(false);
                addonMilk.setChecked(false);
                addonSyrup.setChecked(false);
                addonCream.setChecked(false);
                sizeSpinner.setSelection(0);
                coffee = new Coffee();
            }

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),"Please select a coffee size!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("MyData", order);
        setResult(RESULT_OK, intent);
        finish();
    }
}