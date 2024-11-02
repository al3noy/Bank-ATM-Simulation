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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView imgOtisak;
    @FXML
    private Pane pane;
    @FXML
    private ImageView imgBack;
    @FXML
    private Text txtOtisak;
    @FXML
    private TextField txfNickname;
    
    private Stage stage;
    private Parent root;
    private Scene scene;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void otisak(MouseEvent event) throws IOException {
        
        if("".equals(txfNickname.getText())){
             Alert a2=new Alert(Alert.AlertType.ERROR);
             a2.setTitle("Greska!");
             a2.setHeaderText("Greska!");
             a2.setContentText("Niste uneli vase korisnicko ime! Unesite.");
             a2.showAndWait();
        }
        else{
            
        String username= txfNickname.getText();
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLPreMenu.fxml"));
        root=loader.load();
        
        FXMLPreMenuController dvacontroller=loader.getController();
        dvacontroller.setNick(username);
        
//        root=FXMLLoader.load(getClass().getResource("FXMLDva.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
                                                                                        
    }

    
}
