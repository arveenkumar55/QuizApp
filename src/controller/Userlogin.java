package controller;


import controller.view.Logincontroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Userlogin extends Application {

	private static Stage stage;
	@Override
	public void start(Stage primaryStage)throws Exception {
		
	this.stage = primaryStage;
    	
    	//pcs = new PanelControlSystem();

    	
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/login.fxml"));
		AnchorPane user = (AnchorPane) loader.load();
		stage.getIcons().add(new Image("file:resources/images/icon.jpg"));
	    Scene scene = new Scene(user);
		stage.setScene(scene);
		stage.show();
    }
    
    public static Stage getStage(){
    	return stage;
    }
    

	public static void main(String[] args) {
		launch(args);
	}
}
