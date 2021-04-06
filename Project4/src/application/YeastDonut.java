package application;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used as an abstract data type that represents a yeast donut
 * that contains different flavors.
 * 
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class YeastDonut extends MenuItem {
	private final static double YEASTPRICE = 1.39;
	private int yeastDonutQty;
	private List<String> yeastFlavors;

	/**
	 * Constructor: Creates a YeastDonut object with different types of flavors.
	 */

	YeastDonut() {
		yeastFlavors = new ArrayList<String>();
		yeastFlavors.add("Meyer Lemon");
		yeastFlavors.add("Black and White");
		yeastFlavors.add("Chocolate-Glazed");
		yeastFlavors.add("Plain");
	}

	/**
	 * Constructor: Creates a YeastDonut object when an integer is passed as an
	 * argument.
	 */

	YeastDonut(int quantity) {
		this.yeastDonutQty = quantity;
	}

	/**
	 * Getter method that gets yeast flavors from a List.
	 * 
	 * @return a List of Strings
	 */

	public List<String> getList() {
		return yeastFlavors;
	}

	/**
	 * Getter method for the yeast donut base price.
	 * 
	 * @return a double with the yeast base price.
	 */

	public double getBasePrice() {
		return YEASTPRICE;
	}

	/**
	 * It calculates the subtotal amount of the yeast donut by multiplying the
	 * quantity times the yeast price.
	 */

	@Override
	public void calculateSubTotal() {
		super.setSubTotal(YEASTPRICE * yeastDonutQty);
	}

}
