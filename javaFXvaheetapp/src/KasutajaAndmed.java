import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.HashMap;

public class KasutajaAndmed {
    private TextField nimi;
    private TextField kasutajanimi;
    private TextField parool;
    private TextField aadress;
    private TextField saajaemail;
    private Button tagasi;
    private Button salvesta;
    private VBox kasutajaAndmed;
    private Label teavitus;
    private Stage stage = new Stage();
    private Integer kasutaja_id;
    private HashMap<String, String> andmed;
    private Veenaidud naidud;

//  Constructor, käivitame vajalikud funktsioonid
    KasutajaAndmed(Integer user_id) {
        naidud = new Veenaidud();
        kasutaja_id = user_id;
        teavitus = new Label();
        kasutajaAndmeteEkraan();
        setupTagasi();
        setupSalvesta();
    }

//  Joonistame Andmete ekraani väljad ja sildid
    private void kasutajaAndmeteEkraan() {
        kasutajaAndmed = new VBox();
        kasutajaAndmed.setAlignment(Pos.CENTER);
        Scene kasutajaScene = new Scene(kasutajaAndmed, 300, 500);
        stage.setScene(kasutajaScene);

        stage.setTitle("Kasutaja andmed");

        andmed = naidud.saaKasutajaAndmed(kasutaja_id);

        Label nimiLabel = new Label("Täisnimi");
        nimi = new TextField(andmed.get("name"));
        nimi.setMaxWidth(200);

        Label kasutajanimiLabel = new Label("Kasutajanimi (e-mail)");
        kasutajanimi = new TextField(andmed.get("username"));
        kasutajanimi.setMaxWidth(200);

        Label paroolLabel = new Label("Parool");
        parool = new TextField(andmed.get("password"));
        parool.setMaxWidth(200);

        Label saajameilLabel = new Label("Saaja e-mail");
        saajaemail = new TextField(andmed.get("saajaemail"));
        saajaemail.setMaxWidth(200);

        Label aadressLabel = new Label("Aadress");
        aadress = new TextField(andmed.get("address"));
        aadress.setMaxWidth(200);

        tagasi = new Button("Tagasi");
        salvesta = new Button("Salvesta");

        kasutajaAndmed.getChildren().addAll(nimiLabel, nimi, kasutajanimiLabel, kasutajanimi, paroolLabel, parool,
                saajameilLabel, saajaemail,aadressLabel, aadress, tagasi, salvesta, teavitus);
        stage.show();
    }

//  Tagasi nupu loogika
    private void setupTagasi(){
        tagasi.setOnAction(event -> {
            if (kasutaja_id != 0) { //kui on olemasolev kasutaja, lähme tagasi näitude ekraanile
                new SisestaNaidud(kasutaja_id);
                stage.close();
            } else { //muul juhul lähme tagasi login ekraanile
                new LoginAken();
                stage.close();
            }
        });
    }

//  Salvestamise nupu loogika
    private void setupSalvesta(){
        salvesta.setOnAction(event -> {

            //  Saame uuesti sisestatud andmed, juhuks kui midagi on muutunud
            andmed.put("user_id", String.valueOf(kasutaja_id));
            andmed.put("username", kasutajanimi.getText());
            andmed.put("password", parool.getText());
            andmed.put("name", nimi.getText());
            andmed.put("address", aadress.getText());
            andmed.put("saajaemail", saajaemail.getText());

            try {
                naidud.salvestaKasutajaAndmed(andmed);
                teavitus.setText("Andmed edukalt salvestatud");
                teavitus.setTextFill(Color.BURLYWOOD);

            } catch (Exception e) {
                teavitus.setText("Andmete salvestamine ebaõnnestus");
                teavitus.setTextFill(Color.RED);
            }
        });
    }
}
