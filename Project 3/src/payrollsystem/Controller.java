package payrollsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
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
/**
 * This class is used as controller for the stage created by the the Main class
 * 
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Controller {
	Company company = new Company();// Creates a new company instance to store employees
	Fulltime fulltime; // instance used to store full time employees
	Parttime parttime;// instance used to store part time employees
	Management management;// instance used to store management employees
	/**
	 * DatePicker to select the date the employee was hired
	 */
	@FXML
	private DatePicker date;
	/**
	 * Text field to for the user to input the employee information
	 */
	@FXML
	private TextField name, AnnualSalary, HoursWorked, Rate;
	/**
	 * ToggleGroup for roles and employee types
	 */
	@FXML
	private ToggleGroup dept, empType, role;

	
	/**
	 *  RadioButto objects for dept ToggleGroup
	 */
	@FXML
	private RadioButton IT, ECE, CS;

	
	/**
	 *  RadioButto objects for empType ToggleGroup
	 */
	@FXML
	private RadioButton FT, PT, Management;

	
	/**
	 *  RadioButto objects for FTtype ToggleGroup
	 */
	@FXML
	private RadioButton manager, headDpt, director;
	/**
	 * Button that represent add,remove,setHours and clear input box
	 */
	@FXML
	private Button addButton, removeButton, setHoursButton, clearButton;
	/**
	 * MenuItem that represent import file,print all employee,print by department,print by date hired and calculate payment
	 */
	@FXML
	private MenuItem importFile, exportFile, printAll, printDept, printHired, calculatePayment;
	/**
	 * TextArea that represents the text area where all the messages are printed
	 */
	@FXML
	private TextArea messageArea;
	
	/**
	 * Disables future dates from the date picker
	 */
	@FXML
	void disableFutureDates(MouseEvent event) {
		date.setDayCellFactory(param -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				setDisable((empty || date.compareTo(LocalDate.now()) > 0) || (empty || date.compareTo(LocalDate.parse("1900-01-01")) < 0));
			}
		});

		date.setEditable(false);
	}

	/**
	 * add new employees to data base
	 */
	@FXML
	void add(ActionEvent event) {
		try {
			String tmpDate = date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			RadioButton tmpDept = (RadioButton) dept.getSelectedToggle();
			String department = tmpDept.getText();

			if (PT.isSelected()) {
				if(checkNegativeValue(Float.parseFloat(Rate.getText())) != true)
				{
					Rate.clear();
					return;
				}
				
				parttime = new Parttime(new Profile(name.getText(), department, tmpDate),
						Float.parseFloat(Rate.getText()));

				if (company.add(parttime))
					messageArea.appendText("Employee added.\n");
				else
					messageArea.appendText("Employee is already in the list.\n");
			}

			else if (FT.isSelected()) {
				if(checkNegativeValue(Float.parseFloat(AnnualSalary.getText())) != true)
				{
					AnnualSalary.clear();
					return;
				}
				
				fulltime = new Fulltime(new Profile(name.getText(), department, tmpDate),
						Float.parseFloat(AnnualSalary.getText()));

				if (company.add(fulltime))
					messageArea.appendText("Employee added.\n");
				else
					messageArea.appendText("Employee is already in the list.\n");
			}

			else if (Management.isSelected()) {

				int intRole = 0;

				if (manager.isSelected())
					intRole = 1;
				else if (headDpt.isSelected())
					intRole = 2;
				else if (director.isSelected())
					intRole = 3;
				
				if(checkNegativeValue(Integer.parseInt(AnnualSalary.getText())) != true) {
					AnnualSalary.clear();
					return;
				}

				management = new Management(new Profile(name.getText(), department, tmpDate),
						Integer.parseInt(AnnualSalary.getText()), intRole);

				if (company.add(management))
					messageArea.appendText("Employee added.\n");
				else
					messageArea.appendText("Employee is already in the list.\n");
			}
		} catch (Exception e) {
			messageArea.appendText("Invalid input!\n");
		}
	}
	/**
	 * Removes and employee from the database if the employee exist
	 */
	@FXML
	void remove(ActionEvent event) {
		try {
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
		} catch (Exception e) {
			messageArea.appendText("Invalid input!\n");
		}
	}
	/**
	 * Prints the current employees in the database
	 */
	@FXML
	void printAll(ActionEvent event) {
		if (company.getNumEmployee() > 0) {
			messageArea.appendText("--Printing earning statements for all employees--\n");
			for (int i = 0; i < company.getNumEmployee(); ++i) {
				messageArea.appendText(company.print(i) + "\n");
			}
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
	}
	/**
	 * Prints employees in descending order by their department
	 */
	@FXML
	void printDept(ActionEvent event) {
		if (company.getNumEmployee() > 0) {
			messageArea.appendText("--Print earning statements for all employees by department--\n");
			company.printByDepartment();
			for (int i = 0; i < company.getNumEmployee(); ++i) {
				messageArea.appendText(company.print(i) + "\n");
			}
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
	}
	/**
	 * Prints the array by the hire date of the employees
	 */
	@FXML
	void printHired(ActionEvent event) {
		if (company.getNumEmployee() > 0) {
			messageArea.appendText("--Print earning statements for all employees by date hired--\n");
			company.printByDate();
			for (int i = 0; i < company.getNumEmployee(); ++i) {
				messageArea.appendText(company.print(i) + "\n");
			}
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
	}
	/**
	 * Setter method to set the hours of a part time employee if the employee exist in the data base
	 */
	@FXML
	void setHours(ActionEvent event) {
		try {
			if (checkHoursWorked(Integer.parseInt(HoursWorked.getText())) != true) {
				HoursWorked.clear();
			} else {
				String tmpDate = date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
				RadioButton tmpDept = (RadioButton) dept.getSelectedToggle();
				String department = tmpDept.getText();
				parttime = new Parttime(new Profile(name.getText(), department, tmpDate),
						Integer.parseInt(HoursWorked.getText()));
				if (company.setHours(parttime))
					messageArea.appendText("Working hours set\n");
				else
					messageArea.appendText("Employee does not exist.\n");
			}
		} catch (NumberFormatException e) {
			if (company.getNumEmployee() == 0) {
				messageArea.appendText("Employee database empty.\n");
			}
		}
	}
	/**
	 * Used to calculate the Payment of the full time employee
	 */
	@FXML
	void calculatePayment(ActionEvent event) {
		if (company.getNumEmployee() > 0) {
			company.processPayments();
			messageArea.appendText("Calculation of employee payments is done.\n");
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
	}
	/**
	 * Clear the text from the TextField in the gui
	 */
	@FXML
	void clearTextFields(MouseEvent event) {
		name.clear();
		AnnualSalary.clear();
		HoursWorked.clear();
		Rate.clear();
		date.setValue(null);

	}
	/**
	 * imports an employee from a file and it insert it into the data base
	 */
	@FXML
	void importFile(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Source File for the Import");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("Text Files", "*.*"));
		Stage stage = new Stage();
		File sourceFile = chooser.showOpenDialog(stage); // get the reference of the source file
		try {

			Scanner scan = new Scanner(sourceFile);
			while (scan.hasNextLine()) {
				handleCommand(scan.nextLine());
				;
			}
			scan.close();

		} catch (FileNotFoundException e) {
			messageArea.appendText(e.toString());
		}
	}
	/**
	 * Exports a file into a text file
	 */
	@FXML
	void exportFile(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Target File for the Export");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Stage stage = new Stage();
		File targetFile = chooser.showSaveDialog(stage); // get the reference of the target file

		messageArea.appendText(company.exportDataBase(targetFile));

	}
	/**
	 * handles commands read from the import feature from the gui
	 */
	void handleCommand(String command) {
		String[] tokens = command.split(",");
		switch (tokens[0]) {
		case "P":
			if (checkDepartment(tokens[2]) != true || checkNegativeValue(Float.parseFloat(tokens[4])) != true
					|| checkDate(tokens[3]) != true)
				break;

			parttime = new Parttime(new Profile(tokens[1], tokens[2], tokens[3]), Float.parseFloat(tokens[4]));

			if (company.add(parttime))
				messageArea.appendText("Employee added.\n");
			else
				messageArea.appendText("Employee is already in the list.\n");

			break;
		case "F":
			if (checkDepartment(tokens[2]) != true || checkNegativeValue(Float.parseFloat(tokens[4])) != true
					|| checkDate(tokens[3]) != true)
				break;

			fulltime = new Fulltime(new Profile(tokens[1], tokens[2], tokens[3]), Float.parseFloat(tokens[4]));
			if (company.add(fulltime))
				messageArea.appendText("Employee added.\n");
			else
				messageArea.appendText("Employee is already in the list.\n");

			break;

		case "M":
			if (checkDepartment(tokens[2]) != true || checkDate(tokens[3]) != true
					|| checkNegativeValue(Integer.parseInt(tokens[4])) != true
					|| checkRole(Integer.parseInt(tokens[5])) != true)
				break;

			management = new Management(new Profile(tokens[1], tokens[2], tokens[3]), Integer.parseInt(tokens[4]),
					Integer.parseInt(tokens[5]));

			if (company.add(management))
				messageArea.appendText("Employee added.\n");
			else
				messageArea.appendText("Employee is already in the list.\n");
			break;
		default:
			messageArea.appendText("Invalid Command!\n");

		}

	}
	/**
	 * Disables options from the gui depending on what type of employee is selected
	 */
	@FXML
	void enableEmpTypeOptions(ActionEvent event) {
		if (FT.isSelected()) {
			HoursWorked.setDisable(true);
			Rate.setDisable(true);
			setHoursButton.setDisable(true);
			AnnualSalary.setDisable(false);
			manager.setDisable(true);
			headDpt.setDisable(true);
			director.setDisable(true);

		}

		if (PT.isSelected()) {
			AnnualSalary.setDisable(true);
			HoursWorked.setDisable(false);
			Rate.setDisable(false);
			setHoursButton.setDisable(false);
			manager.setDisable(true);
			headDpt.setDisable(true);
			director.setDisable(true);
		}

		if (Management.isSelected()) {
			manager.setDisable(false);
			headDpt.setDisable(false);
			director.setDisable(false);
			AnnualSalary.setDisable(false);
			setHoursButton.setDisable(true);
			Rate.setDisable(true);
			HoursWorked.setDisable(true);

		}
	}
    /**
     * The CheckHoursWorked method receives an integer value and checks if it is
     * less than zero or greater than 100.
     *
     * @param hoursWorked The number of hours worked.
     * @return true if the hours worked is in valid range . Otherwise, it returns
     *         false and prints an error message.
     */
	private boolean checkHoursWorked(int hoursWorked) {
		if (hoursWorked > 100) {
			messageArea.appendText("Invalid hours: over 100.\n");
			return false;
		} else if (hoursWorked < 0) {
			messageArea.appendText("Working hours cannot be negative.\n");
			return false;
		}
		return true;
	}

	/**
	 * The checkNegativeValue method receives a float value and checks if it is less
	 * than zero.
	 *
	 * @param value The value to be compared.
	 * @return true if the value is greater than zero. Otherwise, it returns false
	 *         and prints an error message.
	 */
	private boolean checkNegativeValue(float value) {
		if (value < 0) {
			messageArea.appendText("Pay rate cannot be negative.\n");
			return false;
		}
		return true;
	}

	/**
	 * The checkRole method receives an integer value and checks if it is a valid
	 * role.
	 *
	 * @param role The role of a full time employee.
	 * @return true if the value is in valid range. Otherwise, it returns false and
	 *         prints and error message.
	 */
	private boolean checkRole(int role) {
		if (role <= 0 || role > 3) {
			messageArea.appendText("Invalid management code.\n");
			return false;
		}
		return true;
	}

	/**
	 * The checkDate method receives a String object containing a date number.
	 *
	 * @param date The string date to be compared.
	 * @return true if the string contains a valid date. Otherwise, it returns false
	 *         and prints an error message.
	 */
	private boolean checkDate(String date) {
		Date dateObj = new Date(date);

		if (!(dateObj.isValid())) {
			messageArea.appendText(date + " is not a valid date.\n");
			return false;
		}
		return true;
	}

	/**
	 * The checkDeparment method receives a String object and checks whether or not
	 * it matches one of the valid department codes ("CS", "IT", "ECE).
	 *
	 * @param departmentCode String object holding a department code.
	 * @return true if the String passed matches to one of the department codes.
	 *         Otherwise, it returns false and prints an error message to the
	 *         console.
	 */
	private boolean checkDepartment(String departmentCode) {

		if (departmentCode.compareTo("CS") != 0 && departmentCode.compareTo("IT") != 0
				&& departmentCode.compareTo("ECE") != 0) {
			messageArea.appendText(departmentCode + " is not a valid department code.\n");
			return false;
		}

		return true;
	}
}