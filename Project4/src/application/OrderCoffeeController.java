package application;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;

public class OrderCoffeeController extends MainMenuController{
    @FXML
    private ComboBox<?> coffeSizes;

    @FXML
    private CheckBox creamAddon;

    @FXML
    private CheckBox syrupAddon;

    @FXML
    private ListView<?> subTotalPrice;

    @FXML
    private CheckBox milkAddon;

    @FXML
    private CheckBox caramelAddon;

    @FXML
    private Button addCoffee;
}
