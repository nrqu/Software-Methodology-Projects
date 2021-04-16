package com.example.rutgerscafe;


import java.util.ArrayList;
import java.util.List;

public class Donut extends MenuItem {
    private final static double DONUTPRICE = 1.39;
    private int donutQuantity;
    private List<String> donutFlavors;


    /**
     * Constructor: Creates a Donut object.
     */

    Donut(int quantity) {
        donutQuantity = quantity;
    }

    Donut() {
        donutFlavors = new ArrayList<>();
        donutFlavors.add("Plain");
        donutFlavors.add("Chocolate Frosted");
        donutFlavors.add("Cinammon");
        donutFlavors.add("Powdered");
        donutFlavors.add("Meyer Lemon");
        donutFlavors.add("Black and White");
        donutFlavors.add("Chocolate-Glazed");
        donutFlavors.add("Nutella Oreo");
        donutFlavors.add("Seasonal Donut Flavor");
    }

    public List<String> getList() { return donutFlavors; }
    /**
     * Creates a string with the donut type, donut flavot, and quantity information.
     *
     * @return a String representation with donut information.
     */

//    @Override
//    public String toString() {
//        return donutType + "~" + donutFlavour + "~" + "(" + donutQuantity + ")";
//    }

    /**
     * It calculates the subtotal amount of a donut by multiplying the quantity
     * times the donut base price.
     */

    @Override
    public void calculateSubTotal() {
        super.setSubTotal(DONUTPRICE * donutQuantity);
    }

//    /**
//     * getter method that returns the donut type information of the object.
//     *
//     * @return a String type of the donut type information.
//     */
//
//    public String getDonutType() {
//        return this.donutType;
//    }
}
