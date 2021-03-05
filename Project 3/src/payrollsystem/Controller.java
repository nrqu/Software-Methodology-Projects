package payrollsystem;

import java.io.File;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {
	Company company = new Company();//Creates a new company instance to store employees
	Fulltime fulltime; // instance used to store full time employees
	Parttime parttime;// instance used to store part time employees
	Management management;// instance used to store management employees

	@FXML
	private DatePicker date;
	
	@FXML
	private TextField name, AnnualSalary, HoursWorked, Rate;

	@FXML
	private ToggleGroup dept, empType, role;

	@FXML
	// RadioButto objects for dept ToggleGroup
	private RadioButton IT, ECE, CS;

	@FXML
	//RadioButto objects for empType ToggleGroup
	private RadioButton FT, PT, Management;

	@FXML
	//RadioButto objects for FTtype ToggleGroup
	private RadioButton manager, headDpt, director;

	@FXML
	private Button addButton, removeButton, setHoursButton, clearButton;

	@FXML
	private MenuItem importFile, exportFile, printAll, printDept, printHired, calculatePayment;

	@FXML
	private TextArea messageArea;


    @FXML
    void add(ActionEvent event) {
    	String tmpDate = date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    	RadioButton tmpDept = (RadioButton) dept.getSelectedToggle();
    	String department = tmpDept.getText();
    
    	if(PT.isSelected()) {
    		parttime = new Parttime(new Profile(name.getText(), department, tmpDate), Float.parseFloat(Rate.getText()));
    		
    		if (company.add(parttime))
				messageArea.appendText("Employee added.\n");
			else
				messageArea.appendText("Employee is already in the list.\n");
    		
    		// JUST FOR DEBUG
        	messageArea.appendText(parttime.toString() + "\n");
    	}
    	
    	if(FT.isSelected()) {
    		fulltime = new Fulltime(new Profile(name.getText(), department, tmpDate), Float.parseFloat(AnnualSalary.getText()));
    		
    		if(company.add(fulltime))
    			messageArea.appendText("Employee added.\n");
			else
				messageArea.appendText("Employee is already in the list.\n");
    	
    		// JUST FOR DEBUG
        	messageArea.appendText(fulltime.toString() + "\n");
    	}
    	
    	if(Management.isSelected()) {
    		
    		RadioButton tmpRole = (RadioButton) role.getSelectedToggle();
    		String strRole = tmpRole.getText();
    		int intRole = 0;

    		if(strRole.compareTo("manager") == 0)
    			intRole = 1;
    		else if(strRole.compareTo("headDpt") == 0)
    			intRole = 2;
    		else if(strRole.compareTo("director") == 0)
    			intRole = 3;
    		
    		
    		management = new Management(new Profile(name.getText(), department, tmpDate),
					Integer.parseInt(AnnualSalary.getText()), intRole);
    		
    		if(company.add(management))
    			messageArea.appendText("Employee added.\n");
			else
				messageArea.appendText("Employee is already in the list.\n");
    		
    		// JUST FOR DEBUG
        	messageArea.appendText(management.toString() + "\n");
    	}
    	
    }
    
    @FXML
	void remove(ActionEvent event) {
    	String tmpDate = date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    	RadioButton tmpDept = (RadioButton) dept.getSelectedToggle();
    	String department = tmpDept.getText();
    	
		if (company.getNumEmployee() > 0) {
			if (company.remove(new Employee(new Profile(name.getText(), department, tmpDate)))) {
				messageArea.appendText("Employee removed.\n");
			} else {
				messageArea.appendText("Employee does not exist.\n");
			}
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
	}
   
    @FXML
    void printAll(ActionEvent event) {
    	if (company.getNumEmployee() > 0) {
			messageArea.appendText("--Printing earning statements for all employees--\n");
			messageArea.appendText(company.print());
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
    }
    
    @FXML
    void clearTextFields(MouseEvent event) {
    	name.clear();
    	AnnualSalary.clear(); 
    	HoursWorked.clear(); 
    	Rate.clear();
    	date.setValue(null);
    	
    }
    
    @FXML
    void enableEmpTypeOptions(ActionEvent event) {
    	if(FT.isSelected()) {
    		HoursWorked.setDisable(true);
    		Rate.setDisable(true);
    		setHoursButton.setDisable(true);
    		AnnualSalary.setDisable(false);

    	} 

    	if(PT.isSelected()) {
    		AnnualSalary.setDisable(true);
    		HoursWorked.setDisable(false);
    		Rate.setDisable(false);
    		setHoursButton.setDisable(false);
    	}
    	
    	if(Management.isSelected()) {
    		manager.setDisable(false);
    		headDpt.setDisable(false);
    		director.setDisable(false);
    		AnnualSalary.setDisable(false);
    		setHoursButton.setDisable(true);
    		Rate.setDisable(true);
    		HoursWorked.setDisable(true);

    	}
    }
}