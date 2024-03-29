package application;


import java.util.ArrayList;
import java.util.List;
/**
 * This class is used as an abstract data type that represents a Donut holes that
 * contains different flavors.
 * 
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */

public class DonutHoles extends MenuItem {
	private final static double DONUTHOLESPRICE = 0.33;
	private int donutHolesQty;
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
	 * Getter method for the donut hole base price.
	 * 
	 * @return a double with the donut hole base price.
	 */

	public double getBasePrice() {
		return DONUTHOLESPRICE;
	}

	/**
	 * It calculates the subtotal amount of the donut holes by multiplying the
	 * quantity times the donut holes base price.
	 */

	@Override
	public void calculateSubTotal() {
		super.setSubTotal(DONUTHOLESPRICE * donutHolesQty);
	}

}
