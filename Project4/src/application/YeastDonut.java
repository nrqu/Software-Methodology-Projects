package application;

public class YeastDonut extends MenuItem {
	protected final static double YEASTPRICE = 1.39;
	protected int yeastDonutQty;
	
	YeastDonut(int quantity)
	{
		yeastDonutQty = quantity;
	}
	
	@Override
	public void calculateSubTotal() {
		super.setSubTotal(YEASTPRICE * yeastDonutQty);
	}
	
	@Override
	public String toString() {
		return super.toString();

	}
}
