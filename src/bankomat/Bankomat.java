package bankomat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Bankomat extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Image ikonica=new Image("/bankomat/logo.png"); 
        stage.setScene(scene);
        stage.setTitle("Fury Bank ATM App");
        stage.getIcons().add(ikonica);
        stage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
