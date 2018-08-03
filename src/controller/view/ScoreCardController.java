package controller.view;
import java.io.IOException;
import java.util.Random;

import controller.Userlogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ScoreCardController {
	

    @FXML
    private Label Score;
    
    @FXML
    private Label  Score1;
    
    static String score;


    public static void SetScore(String marks)
    {
    	score=marks;
    }
    @FXML
  	public void initialize()
  	{
    	Random rand=new Random();
    	int value=rand.nextInt(5)+1;
        Score1.setText(value+"/5");
  	   Score.setText(score+"/5");
  	}
    @FXML
    void handleLogout(ActionEvent event) {
    	Userlogin ul = new Userlogin();
		
		Stage s = ul.getStage();
		try {
			ul.start(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void handleQuiz(ActionEvent event) {
    	
    	if(questioncontroller.getQuizCounter()==4)
    		loadThankUPage();
    	else
    		
    	   loadFXML();

    }

    @FXML
    void handleRanking(ActionEvent event) {

    }
    
    private void loadThankUPage() {
		// TODO Auto-generated method stub
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ThankU.fxml"));
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
    
    private void loadFXML() {
		// TODO Auto-generated method stub
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Question.fxml"));
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


}
