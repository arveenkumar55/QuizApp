package controller.view;
import java.io.IOException;

import controller.Userlogin;
import controller.model.Account;
import controller.model.Filehandling;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class AccountController {
	
	private String gender;
	@FXML
	private Label msgLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label addressLabel;
	@FXML
	private Label serviceLabel;
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField addressTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML
	private RadioButton FemaleButton;
	@FXML
	private RadioButton MaleButton;
	@FXML
	private static boolean selected = false;
	@FXML
	private void handleFemaleButton(){
		gender="Female";
		MaleButton.setSelected(false);
		FemaleButton.setSelected(true);
		selected = true;
	}
	
	@FXML
	private void handleMaleButton(){
		gender="Male";
		FemaleButton.setSelected(false);
		MaleButton.setSelected(true);
		selected = true;
	}
	
	
	@FXML
	private void handleSubmitButton(){
		if(isInputValid()){
			
			String userName = nameTextField.getText();
			
			if( parseName(userName) ){
			
				String pwd = passwordTextField.getText();
				String address = addressTextField.getText();
				
				
				Account account=new Account(userName,pwd,address,gender);
				System.out.println(userName+" "+pwd+" "+address+" "+gender);
				
				Filehandling.file_write(account);
				
			//	String ret = pcs.createUserAccount(accountType, userName, address, pwd, service);
				//msgLabel.setText(ret);
				//System.out.println("Account Controller>handleSubmitButton>"+pcs.getAccountType());
				loadMenuFxml();
			}
		}
	}
	
	@FXML
	private void handleBackButton(){
		Userlogin ul = new Userlogin();
		
		Stage s = ul.getStage();
		try {
			ul.start(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadMenuFxml(){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
		AnchorPane menu = null;
		try {
			menu = (AnchorPane) loader.load();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(menu);
		Stage stg = Userlogin.getStage();
		if( stg != null){
			stg.setScene(scene);
			stg.show();
		}
	}
	
	public boolean parseName(String name){
		
		//System.out.println("Name 0 ASCII: "+ascii);
		boolean valid = true;
		for(int i=0; i<name.length()-1; i++){
			int ascii;
			if(name.substring(i, i+1).equals(" ")){
				ascii = 32;
			}else{
				char c = name.charAt(i);
				ascii = (int)c ;
			}
			
			if( ascii == 32 ){
				printError("Space is not allowed in username!");
				valid = false;
				break;
			}
			else if( ascii < 65 || (ascii > 90 && ascii < 97) ){
				//msgLabel.setText();
				printError("No special character is allowed in username!");
				valid = false;
				break;
			}
		}
		
		return valid;
	}
	
	public AccountController(){
		FemaleButton = new RadioButton();
		MaleButton = new RadioButton();
		nameTextField = new TextField();
		passwordTextField = new PasswordField();
		addressTextField = new TextField();
		msgLabel = new Label();
		selected = false;
	}
	private boolean isInputValid(){
		System.out.println("selected : "+selected);
		if( selected == false ){
			
			printError("Kindly choose the acount type first!");
			return false;
		}
		
		String errMessage = "";
		if( nameTextField.getText() == null || nameTextField.getText().length() == 0){
			errMessage += "Kindly choose a user name!";
		}
		else if( addressTextField.getText() == null || addressTextField.getText().length() == 0 ){
			errMessage += "Kindly enter your current address!";
		}
		else if( passwordTextField.getText() == null || passwordTextField.getText().length() == 0 ){
			errMessage += "Kindly choose a password!";
		}
		if( errMessage.length() == 0 ){
			return true;
		}
		else{
			printError(errMessage);
			return false;
		}
	}
	
	
	public void printError(String msg){
		Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(Userlogin.getStage());
        alert.setTitle("New Account");
        alert.setHeaderText("Invalid Information");
        alert.setContentText(msg);
        alert.showAndWait();
	}
	
	
}
