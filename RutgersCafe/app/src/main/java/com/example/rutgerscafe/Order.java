package com.example.rutgerscafe;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Customizable, Serializable {
    ArrayList<MenuItem> arr;
    static int orderId=1;//increases by one every time an object is created
    int orderNumber;//unique order number of each for each order created
    double total;//total of the whole order
    /**
     * Constructor that creates a new ArrayList that represents the menu items and a unique id for the order
     */
    Order(){
        arr = new ArrayList<MenuItem>();
        orderNumber = orderId;
        orderId+=1;
    }
    /**
     * adds menu items objects in the array
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Coffee ) {
            Coffee temp = (Coffee)obj;
            arr.add(temp);
            return true;
        } else if (obj instanceof Donut) {
            Donut tmp = (Donut) obj;
            arr.add(tmp);
            return true;
        }
        return false;
    }
    /**
     * removes menu item objects from the array
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Coffee) {
            arr.remove((Coffee)obj);
            return true;
        } else if (obj instanceof Donut) {
            System.out.println("remove: " + obj);
            arr.remove((Donut)obj);
            return true;
        }
        return false;
    }
    /**
     * Returns the array with all the items in the current order
     * @return The array containing all the menu item objects in the current order
     */
    public ArrayList<MenuItem> getArr(){
        return arr;
    }
    /**
     * String representation of the order object.
     */
    @Override
    public String toString() {
        String temp = "Order Number: " + orderNumber + " Order Total: " + String.format("%.2f", total) + "\n\t";

        for(int i = 0; i < arr.size(); i++) {
            temp += arr.get(i) + "\n\t";
        }

        return temp;
    }
    /**
     * sets the total of the order
     * @param  total being set.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    public void print(){
        System.out.println("Current items in Order: ");
        for(MenuItem m: arr)
            System.out.println(m);
    }
}
