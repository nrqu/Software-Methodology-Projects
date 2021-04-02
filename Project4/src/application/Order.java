package application;

import java.util.ArrayList;

public class Order implements Customizable {
	ArrayList<MenuItem> arr;
	static int orderId;
	int orderNumber;
	
	Order(){
		arr = new ArrayList<MenuItem>();
		orderNumber = orderId;
		orderId+=1;
	}
	@Override
	public boolean add(Object obj) {
		if(obj instanceof Coffee ) {
			Coffee temp = (Coffee)obj;
			arr.add(temp);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<MenuItem> getArr(){
		return arr;
	}
}
