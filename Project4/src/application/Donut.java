package application;

/**
 * This class is used as an abstract data type that represents a Donut that
 * contains a donut type, a donut flavor and a quantity.
 * 
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */

public class Donut extends MenuItem {
	private String donutType;
	private String donutFlavour;
	private int donutQuantity;
	private double donutBasePrice;

	/**
	 * Constructor: Creates a Donut object.
	 */

	Donut(String type, String flavour, int quantity, double basePrice) {
		donutType = type;
		donutFlavour = flavour;
		donutQuantity = quantity;
		donutBasePrice = basePrice;
	}

	/**
	 * Creates a string with the donut type, donut flavot, and quantity information.
	 * 
	 * @return a String representation with donut information.
	 */

	@Override
	public String toString() {
		return donutType + "~" + donutFlavour + "~" + "(" + donutQuantity + ")";
	}

	/**
	 * It calculates the subtotal amount of a donut by multiplying the quantity
	 * times the donut base price.
	 */

	@Override
	public void calculateSubTotal() {
		super.setSubTotal(donutBasePrice * donutQuantity);
	}

	/**
	 * getter method that returns the donut type information of the object.
	 * 
	 * @return a String type of the donut type information.
	 */

	public String getDonutType() {
		return this.donutType;
	}

}
