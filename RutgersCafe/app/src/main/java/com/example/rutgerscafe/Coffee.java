package com.example.rutgerscafe;

import java.util.ArrayList;

public class Coffee extends MenuItem  implements Customizable{
    final static double COFFEEBASEPRICE = 1.99;
    final static double COFFEETALLPRICE = 2.49;
    final static double COFFEEGRANDEPRICE = 2.99;
    final static double COFFEEVENTIPRICE = 3.49;
    final static double ADDONPRICE = 0.20;

    int coffeeSize;//0=short,1=tall,2=grande,3=venti
    ArrayList<String> addons;
    double addonTotal;
    /**
     * Contructor of the coffee class that creates a new ArrayList of string that represent the names of the addons in the coffee
     */
    Coffee(){
        addons = new ArrayList<String>();
    }
    /**
     * Calculates the sub-total price of the coffee depending on the size and add-ons the coffee contains.
     */
    @Override
    public void calculateSubTotal() {
        double coffeePrice = 0.0;
        if(coffeeSize == 0)
            coffeePrice =0.0;
        else if(coffeeSize == 1) {
            coffeePrice = COFFEEBASEPRICE;
        }else if(coffeeSize == 2) {
            coffeePrice = COFFEETALLPRICE;
        }else if(coffeeSize == 3) {
            coffeePrice = COFFEEGRANDEPRICE;
        }else if(coffeeSize == 4){
            coffeePrice = COFFEEVENTIPRICE;
        }
        if(coffeeSize >0)
            super.setSubTotal(coffeePrice + addonTotal);
        else
            super.setSubTotal(0.0);
    }
    /**
     * Used to add add-ons the the coffee when ever the Listener in the controller is triggered.
     */
    @Override
    public boolean add(Object obj) {
        String addon = (String)obj;
        if(!addons.contains(addon)) {
            addons.add(addon);
            addonTotal+=ADDONPRICE;
            return true;
        }

        return false;
    }
    /**
     * Used to remove add-ons the the coffee when ever the Listener in the controller is triggered.
     */
    @Override
    public boolean remove(Object obj) {
        String addon = (String)obj;
        if(addons.contains(addon)) {
            addons.remove(addon);
            addonTotal -= ADDONPRICE;
            return true;
        }
        return false;
    }
    /**
     * Sets the coffee size when ever the size if chosen from the coffee controller
     * @param size of the coffee
     */
    public void setCoffeeSize(int val) {
        if(val > -1) {
            coffeeSize = val;
            calculateSubTotal();
        }
    }
    /**
     * Returns a string representation of the coffee object
     */
    @Override
    public String toString() {
        String size;
        String n = addons.toString();

        if(coffeeSize == 0) {
            size = "Short";
        }else if(coffeeSize == 1) {
            size = "Tall";
        }else if(coffeeSize == 2) {
            size = "Grande";
        }else{
            size = "Venti";
        }

        n = n.replace("[", "").replace("]", "");

        if(n.isEmpty())
            n = "none";


        return "Coffee Size: " + size +" Addons: "+ n;

    }
}
