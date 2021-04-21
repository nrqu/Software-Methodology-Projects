package com.example.rutgerscafe;


import java.io.Serializable;

/**
 * Class used as the parent class for all the menu items
 *
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 */
public class MenuItem implements Serializable {
    private double subTotal;

    /**
     * Calculates the sub-total price of the coffee depending on the size and add-ons the coffee contains.
     */
    public void itemPrice() {
    }

    /**
     * sets the sub-total of the order item object
     *
     * @param subTotal
     */
    protected void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * returns the sub-total of the order item object
     *
     * @return
     */
    protected double getSubTotal() {

        return this.subTotal;
    }

    /**
     * string representation of the MenuItem object
     */
    @Override
    public String toString() {
        return String.format("%,.2f", subTotal);
    }


}
