import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Kristina on 02/01/17.
 */
public class KasutajaAndmed {
    TextField nimi;
    TextField kasutajanimi;
    TextField parool;
    TextArea aadress;
    TextArea sonum;
    Button tagasi;
    Button salvesta;
    TilePane kasutajaAndmed;
    Stage stage = new Stage();

    KasutajaAndmed() {
        kasutajaAndmeteEkraan();
        setupTagasi();
    }

    private void kasutajaAndmeteEkraan() {
//        Teeme vboxi asemel tilepane ja seame sellele 2 tulpa, et label ja väli oleks samal real
        kasutajaAndmed = new TilePane();
        kasutajaAndmed.setVgap(2);
        kasutajaAndmed.setPrefColumns(2);
        kasutajaAndmed.setMaxHeight(600);

        Scene kasutajaScene = new Scene(kasutajaAndmed);
        stage.setScene(kasutajaScene);

        stage.setTitle("Muuda andmeid");

        Label nimiLabel = new Label("Täisnimi");
        nimi = new TextField();
//        nimi.maxWidth(100);

        Label kasutajanimiLabel = new Label("Kasutajanimi (e-mail)");
        kasutajanimi = new TextField();
//        kasutajanimi.maxWidth(100);

        Label paroolLabel = new Label("Parool");
        parool = new TextField();


        Label aadressLabel = new Label("Aadress");
        aadress = new TextArea();
        aadress.setMaxHeight(100);

        Label sonumLabel = new Label("Sõnum");
        sonum = new TextArea();
        sonum.setMaxHeight(100);

        tagasi = new Button("Tagasi");
        salvesta = new Button("Salvesta");

        kasutajaAndmed.getChildren().addAll(nimiLabel, nimi, kasutajanimiLabel, kasutajanimi, paroolLabel, parool, aadressLabel, aadress, sonumLabel, sonum, tagasi, salvesta);
        stage.show();
    }

//    Tagasi nupu loogika
    private void setupTagasi(){
        tagasi.setOnAction(event -> {
            new SisestaNaidud();
            stage.close();
        });
    }

//    siia peab tegema ka salvestamise nupu loogika
/*    private void setupSalvesta(){
        salvesta.setOnAction(event -> {

        });
    }*/
}
