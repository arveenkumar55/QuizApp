package controller.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class RakingController {

    @FXML
    private Label label1;

    @FXML
    private Label label2;
    
    static public String player1;
    static public String player2;
    
    public static void  SetScore(String a, String b)
    {
    	player1=a;
    	player2=b;
    }
    @FXML
  	public void initialize()
  	{
    	if(menuController.flag==true)
    	{
    		if(Integer.parseInt(player1)>=Integer.parseInt(player2))
      		{
      			label1.setText("PLayer1");
      			label2.setText("PLayer2");
      		}
      		else
      		{
      			label1.setText("PLayer2");
      			label2.setText("PLayer1");

      		}
    	}
    	else
    	{
  		if(Integer.parseInt(player1)>=Integer.parseInt(player2))
  		{
  			label1.setText("PLayer");
  			label2.setText("Computer");
  		}
  		else
  		{
  			label1.setText("Computer");
  			label2.setText("PLayer");

  		}
    	}
  	}
    
    @FXML
    
    void BACKButton(ActionEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();

    }


}

