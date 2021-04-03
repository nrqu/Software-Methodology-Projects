package application;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StoreOrders implements Customizable {
	ArrayList<Order> arr;

	StoreOrders() {
		arr = new ArrayList<Order>();
	}

	@Override
	public boolean add(Object obj) {
		if (obj instanceof Order) {
			Order temp = (Order) obj;
			arr.add(temp);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		if (obj instanceof Order) {
			Order temp = (Order) obj;
			arr.remove(temp);
			return true;
		}
		return false;
	}

	// TODO: DELETE
	public void print() {
		for (var e : arr)
			System.out.println(e);
	}

	public ArrayList<Order> getArr() {
		return arr;
	}

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
