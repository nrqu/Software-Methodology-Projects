package application;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

public class OrderCoffeeController extends MainMenuController{
    @FXML
    private ComboBox<String> coffeSizes;

    @FXML
    private CheckBox creamAddon;

    @FXML
    private CheckBox syrupAddon;

    @FXML
    private TextArea subTotalPrice;

    @FXML
    private CheckBox milkAddon;

    @FXML
    private CheckBox caramelAddon;

    @FXML
    private Button addCoffee;
    
    
}
