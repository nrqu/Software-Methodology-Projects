package application;

import java.util.ArrayList;

public class StoreOrders implements Customizable{
	ArrayList<Order> arr;
	StoreOrders(){
		arr = new ArrayList<Order>();
	}
	@Override
	public boolean add(Object obj) {
		if(obj instanceof Order) {
			Order temp = (Order)obj;
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
	//TODO: DELETE
	public void print() {
		for(var e : arr)
			System.out.println(e);
	}
	public ArrayList<Order> getArr(){
		return arr;
	}

}
