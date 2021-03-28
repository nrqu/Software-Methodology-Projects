package application;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class OrderCoffeeController extends MainMenuController{
    @FXML
    private ComboBox<?> coffeSizes;

    @FXML
    private CheckBox creamAddon;

    @FXML
    private CheckBox syrupAddon;

    @FXML
    private CheckBox milkAddon;

    @FXML
    private CheckBox caramelAddon;
}
