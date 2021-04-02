package application;

import java.util.ArrayList;

public class Order implements Customizable {
	ArrayList<MenuItem> arr;
	static int orderId=1;
	int orderNumber;
	double total;
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
		if(obj instanceof Coffee) {
			arr.remove((Coffee)obj);
			return true;
		}
		return false;
	}
	public ArrayList<MenuItem> getArr(){
		return arr;
	}
	//TODO: DELETE
	public void print() {
		for (var a : arr)
			System.out.println(a);
	}
	@Override
	public String toString() {
		String temp = "Order Number: "+ orderNumber + " Order Total: "+String.format("%.2f",total)+ "\n\t";

		for(var a: arr) {
			temp += a + "\n\t";
		}
		
		return temp;	
	}
   public void setTotal(double total) {
	   this.total = total;
   }
}
