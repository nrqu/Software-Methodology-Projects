package application;

/**
 * This class is used as an abstract data type that represents a Donut holes that
 * contains different flavors.
 * 
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */

import java.util.ArrayList;
import java.util.List;

public class DonutHoles extends MenuItem {
	protected final double DONUTHOLESPRICE = 0.33;
	protected int donutHolesQty;
	private List<String> donutHolesFlavors;

	/**
	 * Constructor: Creates a DonutHoles object with different types of flavors.
	 */

	DonutHoles() {
		donutHolesFlavors = new ArrayList<String>();
		donutHolesFlavors.add("Chocolate Frosted");
		donutHolesFlavors.add("Cinammon");
		donutHolesFlavors.add("Powdered");
		donutHolesFlavors.add("Plain");
	}

	/**
	 * Constructor: Creates a DonutHoles object when an integer is passed as an
	 * argument.
	 */

	DonutHoles(int quantity) {
		donutHolesQty = quantity;
	}

	/**
	 * Getter method that gets donut holes flavors from a List.
	 * 
	 * @return a List of Strings
	 */

	public List<String> getList() {
		return donutHolesFlavors;
	}

	/**
	 * It calculates the subtotal amount of the donut holes by multiplying the
	 * quantity times the donut holes base price.
	 */

	@Override
	public void calculateSubTotal() {
		super.setSubTotal(DONUTHOLESPRICE * donutHolesQty);
	}
	
	public double getBasePrice() {
		return this.DONUTHOLESPRICE;
	}

	@Override
	public String toString() {
		return super.toString();

	}

}
