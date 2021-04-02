package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class OrderDetailController {
	private MainMenuController mainController;

	@FXML
	private ListView<MenuItem> orderSummaryList;

	@FXML
	private TextField orderSubTotal;

	@FXML
	private TextField orderSaleTax;

	@FXML
	private TextField orderTotal;
	@FXML

	Order order;
	StoreOrders storeOrders;

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

	@FXML
	void orderRemoveItem(ActionEvent event) {
		int selectedIndex = orderSummaryList.getSelectionModel().getSelectedIndex();
		if (selectedIndex > -1) {
			order.remove(orderSummaryList.getItems().get(selectedIndex));
			orderSummaryList.getItems().remove(selectedIndex);
			setPrice();
		}
	}

	void setPrice() {
		double subtotal = 0.0;
		double taxes = 0.0;
		double total = 0.0;

		if (!order.getArr().isEmpty()) {
			for (var a : order.getArr()) {
				subtotal += a.getSubTotal();
			}
			if (subtotal > 0) {
				taxes = subtotal * 0.06625;
			}
			total = subtotal + taxes;
			order.setTotal(total);

//			orderSubTotal.setText(String.format("%.2f", subtotal));
//			orderSaleTax.setText(String.format("%.2f", taxes));
//			orderTotal.setText(String.format("%.2f", total));
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
