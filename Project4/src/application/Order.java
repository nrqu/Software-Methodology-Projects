package application;

import java.util.ArrayList;

public class Order implements Customizable {
	ArrayList<MenuItem> arr;
	int orderId;
	
	Order(){
		arr = new ArrayList<MenuItem>();
	}
	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
