package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
/**
 * Controller used to handle the order GUI
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class OrderDetailController {
	private MainMenuController mainController;//main gui reference

	@FXML
	private ListView<MenuItem> orderSummaryList;//list of orders

	@FXML
	private TextField orderSubTotal;//order subtotal field

	@FXML
	private TextField orderSaleTax;//order sale taxt field

	@FXML
	private TextField orderTotal; // order total field
	@FXML

	Order order;//order reference
	StoreOrders storeOrders;//store reference
    /**
     * Used by the Main controller to get a reference of the data in the main controller in child stages.
     */
	public void setMainController(MainMenuController controller) {
		mainController = controller;
		this.order = controller.getOrderReference();
		this.storeOrders = controller.getStoreOrderReference();
		ArrayList<MenuItem> arr = order.getArr();

		if (!arr.isEmpty()) {
			for (var a : arr) {
				orderSummaryList.getItems().add(a);
			}
			setPrice();
		}

	}
	/**
	 * Event handler that inserts orders into the StoreOrder object
	 * @param event
	 */
	@FXML
	void orderPlaceOrder(ActionEvent event) {
		if (!orderSummaryList.getItems().isEmpty()) {
			storeOrders.add(order);
			orderSummaryList.getItems().clear();
			orderSubTotal.clear();
			orderSaleTax.clear();
			orderTotal.clear();
			mainController.setOrderReference(new Order());
		}
	}
	/**
	 * Removes objects from the order Object
	 * @param event
	 */
	@FXML
	void orderRemoveItem(ActionEvent event) {
		int selectedIndex = orderSummaryList.getSelectionModel().getSelectedIndex();
		if (selectedIndex > -1) {
			order.remove(orderSummaryList.getItems().get(selectedIndex));
			System.out.println(orderSummaryList.getItems().get(selectedIndex));
			orderSummaryList.getItems().remove(selectedIndex);
			setPrice();
		}
	}
	/**
	 * calculates the sub-total,tax and total of the order
	 */
	void setPrice() {
		double subtotal = 0.0;
		double taxes = 0.0;
		double total = 0.0;
		
		orderSubTotal.clear();
		orderSaleTax.clear();
		orderTotal.clear();
		
		if (!order.getArr().isEmpty()) {
			for (var a : order.getArr()) {
				subtotal += a.getSubTotal();
			}
			if (subtotal > 0) {
				taxes = subtotal * 0.06625;
			}
			total = subtotal + taxes;
			order.setTotal(total);

		} else {
			subtotal = 0.0;
			taxes = 0.0;
			total = 0.0;
		}
		orderSubTotal.setText(String.format("%.2f", subtotal));
		orderSaleTax.setText(String.format("%.2f", taxes));
		orderTotal.setText(String.format("%.2f", total));
	}
}
