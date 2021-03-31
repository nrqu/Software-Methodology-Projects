package application;

import java.util.ArrayList;

class Coffee extends MenuItem implements Customizable {
	final static double COFFEEBASEPRICE = 1.99;
	int coffeeSize;//0=short,1=tall,2=grande,3=venti
	ArrayList<String> addons;
	double addonTotal;
	
	Coffee(){
		addons = new ArrayList<String>();	
	}
	@Override
	public void calculatePrice() {
		double coffeePrice;

		if(coffeeSize == 0) {
			coffeePrice = COFFEEBASEPRICE;
		}else if(coffeeSize == 1) {
			coffeePrice = COFFEEBASEPRICE + 0.50f;
		}else if(coffeeSize == 2) {
			coffeePrice = COFFEEBASEPRICE + 1.f;
		}else{
			coffeePrice = COFFEEBASEPRICE + 1.5f;
		}
		super.setSubTotal(coffeePrice);
	}
	@Override
	public boolean add(Object obj) {
		String addon = (String)obj;
		if(!addons.contains(addon)) {
			addons.add(addon);
			addonTotal+=.20;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		String addon = (String)obj;
		if(addons.contains(addon)) {
			addons.remove(addon);
			addonTotal -= .20;
			return true;
		}
		return false;
	}
	
	public double getPrice() {
		return super.getSubTotal() + addonTotal;
	}

	public void setCoffeeSize(int val) {
		coffeeSize = val;
		calculatePrice();
	}
	@Override
	public String toString() {
		String size;
		String addon;
		if(coffeeSize == 0) {
			size = "Short";
		}else if(coffeeSize == 1) {
			size = "Tall";
		}else if(coffeeSize == 2) {
			size = "Grande";
		}else{
			size = "Venti";
		}
		String n = addons.toString();
		
		n = n.replace("[", "").replace("]", "").replace(" ", "");

		return "Coffee Size: " + size +" Addons: "+ n;

	}

}
