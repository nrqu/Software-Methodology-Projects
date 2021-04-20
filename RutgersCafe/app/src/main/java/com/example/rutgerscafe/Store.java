package com.example.rutgerscafe;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class used to handle the StoreOrders GUI
 *
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 */
public class Store implements Customizable, Serializable {
    ArrayList<Order> arr;

    /**
     * Constructor that creates a new ArrayList that represents the Order items.
     */
    Store() {
        arr = new ArrayList<Order>();
    }

    /**
     * adds order items objects in the array
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            Order temp = (Order) obj;
            arr.add(temp);
            return true;
        }
        return false;
    }

    /**
     * removes order item objects from the array
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            Order temp = (Order) obj;
            arr.remove(temp);
            return true;
        }
        return false;
    }

    /**
     * Returns the array with all the items in the current Store order
     *
     * @return The array containing all the order objects in the current order
     */
    public ArrayList<Order> getArr() {
        return arr;
    }

}