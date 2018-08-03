package controller.view;
import java.io.IOException;

import controller.Userlogin;
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
import javafx.stage.Stage;

public class Logincontroller {
	

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField pwdField;

    @FXML
    private Label msglabel;

    @FXML
    void handleCreateAccount(ActionEvent event) {
    	
    	FXMLLoader loader = new FXMLLoader(Logincontroller.class.getResource("account.fxml"));
		AnchorPane login = null;
		try {
			login = (AnchorPane) loader.load();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(login);
		Stage stg = Userlogin.getStage();
		if( stg != null){
			stg.setScene(scene);
			stg.show();
		}

    }

    @FXML
    void handleSignIn(ActionEvent event) {
    	if(isInputValid()){
			//validate user name and password...
			String userName = userNameField.getText();
			String pwd = pwdField.getText();
			
			
			String ret = Filehandling.file_read(userName, pwd);
			System.out.println("ret valu: "+ret);
			msglabel.setText(ret);
			if( ret.equals("Successfully Login")){
				loadMenuFxml();
			
				}
			
		}

    }
    
    private void loadMenuFxml() {
		// TODO Auto-generated method stub
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

	private boolean isInputValid(){
		String errMessage = "";
		if( userNameField.getText() == null || userNameField.getText().length() == 0){
			errMessage += "Invalid user name entered!";
		}
		else if( pwdField.getText() == null || pwdField.getText().length() == 0 ){
			errMessage += "Invalid password entered!";
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
        alert.setTitle("Log In");
        alert.setHeaderText("Invalid Information");
        alert.setContentText(msg);
        alert.showAndWait();
	}


}
