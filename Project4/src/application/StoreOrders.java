package application;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * Class used to handle the StoreOrders GUI
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class StoreOrders implements Customizable {
	ArrayList<Order> arr;
	/**
	 * Constructor that creates a new ArrayList that represents the Order items.
	 */
	StoreOrders() {
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
	 * @return The array containing all the order objects in the current order
	 */
	public ArrayList<Order> getArr() {
		return arr;
	}
	/**
	 * Exports the array in text format
	 * @param file reference used to write the text
	 * @return String depending if the write was successful 
	 */
	public String exportDataBase(File file) {
		if (arr.size() >= 0) {
			try {
				PrintWriter pw = new PrintWriter(file);
				for (int i = 0; i < arr.size(); ++i) {
					pw.println(arr.get(i));
				}
				pw.close();
				return "Database Exported.";
			} catch (Exception e) {

			}
			return "Database was not exported.";
		}
		return "Store History Empty";
	}

}
