package controller.view;

import controller.Userlogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ThankUController {
	  @FXML
	    void handleLogout(ActionEvent event) 
	  {
		  Userlogin ul = new Userlogin();
			
			Stage s = ul.getStage();
			try {
				ul.start(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
	  }


}
