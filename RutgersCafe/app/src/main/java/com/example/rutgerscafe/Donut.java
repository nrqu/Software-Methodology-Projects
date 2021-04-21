package com.example.rutgerscafe;


import java.util.ArrayList;
import java.util.List;
/**
 * This class is used as an abstract data type that represents a Donut that
 * contains a donut type, a donut flavor and a quantity.
 *
 *
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Donut extends MenuItem {
    private final static double DONUTPRICE = 1.39;
    private int donutQuantity;
    private String donutType;
    private List<String> donutFlavors;


    /**
     * Constructor: It sets the donut flavor and quantity
     */
    Donut(String flavor, int quantity) {
        donutType = flavor;
        donutQuantity = quantity;
    }

    /**
     * Constructor: Creates a Donut object
     */
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

    /**
     * It returns a string list
     *
     * @return a string list of donut flavors.
     */
    public List<String> getList() {
        return donutFlavors;
    }

    /**
     * Creates a string with the donut type, donut flavot, and quantity information.
     *
     * @return a String representation with donut information.
     */
    @Override
    public String toString() {
        return donutType + "~" + "(" + donutQuantity + ")";
    }

    /**
     * It calculates the subtotal amount of a donut by multiplying the quantity
     * times the donut base price.
     */
    @Override
    public void itemPrice() {
        super.setSubTotal(DONUTPRICE * donutQuantity);
    }
}
