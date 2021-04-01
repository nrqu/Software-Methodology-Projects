package application;

/**
 * This class is used as an abstract data type that represents a cake donut that
 * contains different flavors.
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */

import java.util.ArrayList;
import java.util.List;

public class CakeDonut extends MenuItem {
	protected final static double CAKEDONUTPRICE = 1.59;
	protected int cakeDonutQty;
	private List<String> cakeDonutFlavors;

	/**
	 * Constructor: Creates a CakeDonut object with different types of flavors.
	 */

	CakeDonut() {
		cakeDonutFlavors = new ArrayList<String>();
		cakeDonutFlavors.add("Baked Blueberry");
		cakeDonutFlavors.add("Vainalle-Glazed");
		cakeDonutFlavors.add("Plain");
	}

	/**
	 * Constructor: Creates a CakeDonut object when an integer is passed as an
	 * argument.
	 */

	CakeDonut(int quantity) {
		cakeDonutQty = quantity;
	}

	/**
	 * Getter method that gets cake donut flavors from a List.
	 * 
	 * @return a List of Strings
	 */

	public List<String> getList() {
		return cakeDonutFlavors;
	}

	/**
	 * It calculates the subtotal amount of the cake donut by multiplying the
	 * quantity times the cake donut base price.
	 */

	@Override
	public void calculateSubTotal() {
		super.setSubTotal(CAKEDONUTPRICE * cakeDonutQty);
	}

	@Override
	public String toString() {
		return super.toString();

	}
}
