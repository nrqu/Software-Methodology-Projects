package application;

// superclass of all menu items, such as donuts and coffee.
public class MenuItem {
	private double subTotal;
	
	
	public void calculateSubTotal() {
		
	}
	
	protected void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	protected double getSubTotal() {
		
		return this.subTotal;
	}
	
	

	@Override
	public String toString() {
		return String.format("%,.2f", subTotal);
	}
	
}
