package application;

import java.util.ArrayList;


/**
 * This class is used as an object that represents a coffee in a store order
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
class Coffee extends MenuItem implements Customizable {
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
		double coffeePrice;

		if(coffeeSize == 0) {
			coffeePrice = COFFEEBASEPRICE;
		}else if(coffeeSize == 1) {
			coffeePrice = COFFEETALLPRICE;
		}else if(coffeeSize == 2) {
			coffeePrice = COFFEEGRANDEPRICE;
		}else{
			coffeePrice = COFFEEVENTIPRICE;
		}
		super.setSubTotal(coffeePrice + addonTotal);
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
		coffeeSize = val;
		calculateSubTotal();
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
		
		if(n.isBlank())
			n = "none";
		

		return "Coffee Size: " + size +" Addons: "+ n;

	}

}
