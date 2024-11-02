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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class FXMLUplatiController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private ImageView imgBack;
    @FXML
    private Text txtStanje;
    @FXML
    private Text txtDzep;
    @FXML
    private Label lblBanka;
    @FXML
    private Label lblDzep;
    @FXML
    private Button btnNazad1;
    @FXML
    private Button btnEuro;
    @FXML
    private Button btnDollar;
    @FXML
    private Text txtStanje1;
    @FXML
    private TextField txfUplata;
    @FXML
    private Button btnUplata;

    int trenutnoStanje, trenutnoDzep, isplata, razlika, trRazlika, trZbir;
    
    boolean euro=false,dollar=false;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trenutnoStanje=300;
        trenutnoDzep=50;
    }    

    @FXML
    private void nazad(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
        Scene scene = btnNazad1.getScene();
        root.translateYProperty().set(scene.getHeight());

        pane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            pane.getChildren().remove(pane);
        });
        timeline.play();
    }

    @FXML
    private void staviEuro(ActionEvent event) {
       euro=true;
       dollar=false;
       lblBanka.setText("€"+trenutnoStanje);
       lblDzep.setText("€"+trenutnoDzep);
       btnDollar.setDisable(true);
    }

    @FXML
    private void staviDollar(ActionEvent event) {
       euro=false;
       dollar=true;
       lblBanka.setText("$"+trenutnoStanje);
       lblDzep.setText("$"+trenutnoDzep);
       btnEuro.setDisable(true);
    }

    @FXML
    private void uplatiNovac(ActionEvent event) {
         isplata = Integer.parseInt(txfUplata.getText());
         razlika=trenutnoStanje+isplata;
         //trRazlika=trenutnoStanje-razlika;
         trZbir=trenutnoDzep-isplata;
         
         trenutnoStanje=razlika;
         trenutnoDzep=trZbir;
         
         if(trenutnoDzep==0 || trenutnoDzep<0){
             btnUplata.setDisable(true);
             
             isplata = Integer.parseInt(txfUplata.getText());
             razlika=trenutnoStanje+isplata;
             //trRazlika=trenutnoStanje-razlika;
             trZbir=trenutnoDzep-isplata;
         
             trenutnoStanje=350;
             trenutnoDzep=0;
             
             Alert a3=new Alert(Alert.AlertType.WARNING);
             a3.setTitle("Upozorenje!");
             a3.setHeaderText("Upozorenje!");
             a3.setContentText("Nemate vise sredstava u dzepu!");
             a3.showAndWait();
             
             
             if(euro==true){
             lblDzep.setText("€" + trenutnoDzep);
             lblBanka.setText("€" + trenutnoStanje );
             
             }
             else if(dollar==true){
             lblDzep.setText("$" + trenutnoDzep);
             lblBanka.setText("$" + trenutnoStanje );
             }
                          
         }
         else{
             if(euro==true){
             lblDzep.setText("€" + trZbir);
             lblBanka.setText("€" + razlika );
             
             }
             else if(dollar==true){
             lblDzep.setText("$" + trZbir);
             lblBanka.setText("$" + razlika );
             }
         
             else{
             Alert a1=new Alert(Alert.AlertType.ERROR);
             a1.setTitle("Greska!");
             a1.setHeaderText("Greska!");
             a1.setContentText("Niste izabrali valutu! Izaberite valutu.");
             a1.showAndWait();
         }
         }
    }
    
}
