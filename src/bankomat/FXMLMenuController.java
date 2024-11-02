package bankomat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class FXMLMenuController implements Initializable {

    @FXML
    private Pane pane2;
    @FXML
    private ImageView imgBack2;
    @FXML
    private Button btnPregled;
    @FXML
    private Button btnPodigni;
    @FXML
    private Button btnTrans;
    @FXML
    private Button btnUplati;
    @FXML
    private Button btnNapusti;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void podigni(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPodigni.fxml"));
        Scene scene = btnPodigni.getScene();
        root.translateYProperty().set(scene.getHeight());

        pane2.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            pane2.getChildren().remove(pane2);
        });
        timeline.play();
    }

  
    @FXML
    private void uplati(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUplati.fxml"));
        Scene scene = btnUplati.getScene();
        root.translateYProperty().set(scene.getHeight());

        pane2.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            pane2.getChildren().remove(pane2);
        });
        timeline.play();
    }

    @FXML
    private void napusti(ActionEvent event) {
        System.exit(0);
    }
    
}
