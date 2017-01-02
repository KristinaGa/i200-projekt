import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Kristina on 02/01/17.
 */
public class SisestaNaidud {
/*    siin määrame ära need elemendid, mida kõikides funktsioonides on võimalik kasutada --> kui teeks ainult ühe funktsiooni sees
    siis teised ei näeks neid ja ei saaks väärtusi kasutada */
    Stage stage = new Stage();
    VBox veenaidud;
    TextField soenait;
    TextField kulmnait;
    TextArea elukoht;
    Button saadaNait;
    Hyperlink minuAndmed;



    SisestaNaidud() {
        naitudeAken();
        naitudeSaatmine();
        andmeteMuutmine();
    }

    private void naitudeAken() {
        stage.setTitle("Veenäitude esitamine");

        veenaidud = new VBox();
        veenaidud.setAlignment(Pos.CENTER);
        Scene veenait = new Scene(veenaidud, 350, 500);

        minuAndmed = new Hyperlink("Minu andmed");

        Label soevesi = new Label("Sooja vee näit");
        soenait = new TextField();
        soenait.setMaxWidth(50);
        Label kulmvesi = new Label("Külma vee näit");
        kulmnait = new TextField();
        kulmnait.setMaxWidth(50);
        Label aadress = new Label("Sisesta oma aadress");
        elukoht = new TextArea();
        elukoht.setMaxWidth(250);
        elukoht.setMinHeight(150);
        saadaNait = new Button("Saada näidud");

        veenaidud.getChildren().addAll(minuAndmed, soenait, kulmvesi, kulmnait, aadress, elukoht, saadaNait);

        stage.setScene(veenait);
        stage.show();
    }

    private void naitudeSaatmine() {
        saadaNait.setOnAction(event -> {

            //teeme uue Veenaitude klassi instantsi ja määrame muutujate väärtused
            Veenaidud naidud = new Veenaidud();

            naidud.soe = soenait.getText();
            naidud.kylm = kulmnait.getText();
            naidud.elukoht = elukoht.getText();


            String teade = String.format("Tere! Aadressi %s sooja vee näit on %s ja külma vee näit on %s.", naidud.elukoht, naidud.soe, naidud.kylm);
            System.out.println(teade);
            Label preview = new Label(teade);
            preview.setTextFill(Color.BURLYWOOD);
            veenaidud.getChildren().add(preview);
        });
    }

    private void andmeteMuutmine() {
        minuAndmed.setOnAction(event -> {
            new KasutajaAndmed();
            stage.close();
        });
    }
}
