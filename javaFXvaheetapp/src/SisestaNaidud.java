import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class SisestaNaidud {
    private Stage stage = new Stage();
    private VBox veenaidud;
    private TextField soenait;
    private TextField kulmnait;
    private Button saadaNait;
    private Button logOut;
    private Hyperlink minuAndmed;
    private Integer kasutaja_id;
    private HashMap<String, String> andmed;
    private Label teavitus;
    private Veenaidud naidud;

    SisestaNaidud(Integer user_id) {
        naidud = new Veenaidud();
        kasutaja_id = user_id;
        teavitus = new Label();
        naitudeAken();
        naitudeSaatmine();
        setupMinuAndmed();
        setupLogout();
    }

    private void naitudeAken() {
        stage.setTitle("Veenäitude esitamine");

        andmed = naidud.saaEelmisedNaidud(kasutaja_id);

        veenaidud = new VBox();
        veenaidud.setAlignment(Pos.CENTER);
        Scene veenait = new Scene(veenaidud, 300, 500);

        minuAndmed = new Hyperlink("Minu andmed");

        Label soevesi = new Label("Sooja vee näit");
        soenait = new TextField();
        soenait.setPromptText(andmed.get("eelmineSoe"));
        soenait.setMaxWidth(100);

        Label kulmvesi = new Label("Külma vee näit");
        kulmnait = new TextField();
        kulmnait.setPromptText(andmed.get("eelmineKylm"));
        kulmnait.setMaxWidth(100);

        saadaNait = new Button("Saada näidud");
        logOut = new Button("Logi välja");

        veenaidud.getChildren().addAll(minuAndmed, soevesi, soenait, kulmvesi, kulmnait, saadaNait, logOut, teavitus);

        stage.setScene(veenait);
        stage.show();
    }

//  Näitude saatmine ja kontroll, kas sisestati korrektsed andmed
    private void naitudeSaatmine() {
        saadaNait.setOnAction(event -> {

            String soe = soenait.getText();
            String kylm = kulmnait.getText();

            String kuupaev;
            Date date = new Date();
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat("dd.MM.yy");
            kuupaev = formatter.format(date);

            if (!soe.isEmpty() && !kylm.isEmpty()) {
                try {
                    //  Kontrollime, kas sisestatud näidud olid numbrid - kui mitte, siis saame errori
                    Integer soeNumber = Integer.parseInt(soe);
                    Integer kylmNumber = Integer.parseInt(kylm);
                    try {
                        //  Tegelik salvestamine
                        naidud.salvestaNaidud(kasutaja_id, kuupaev, soe, kylm);
                        teavitus.setText("Näidud edukalt saadetud");
                        teavitus.setTextFill(Color.BURLYWOOD);
                    } catch (Exception e) {
                        teavitus.setText("Näitude saatmine ebaõnnestus");
                        teavitus.setTextFill(Color.RED);
                    }
                } catch (Exception e) {
                    teavitus.setText("Lubatud on ainult numbrid");
                    teavitus.setTextFill(Color.RED);
                }
            } else {
                teavitus.setText("Mõlemad väljad peavad olema täidetud");
                teavitus.setTextFill(Color.RED);
            }
        });
    }

    private void setupMinuAndmed() {
        minuAndmed.setOnAction(event -> {
            new KasutajaAndmed(kasutaja_id);
            stage.close();
        });
    }

    private void setupLogout() {
        logOut.setOnAction(event -> {
            new LoginAken();
            stage.close();
        });
    }
}
