package controller.view;

import java.io.IOException;

import controller.Userlogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class menuController {
	

    @FXML
    void handleComputorButton(ActionEvent event) {
    	
    	FXMLLoader loader = new FXMLLoader(Logincontroller.class.getResource("question.fxml"));
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
    void handlePersonButton(ActionEvent event) {

    }

}
