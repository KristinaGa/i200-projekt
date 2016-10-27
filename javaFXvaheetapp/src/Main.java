import com.sun.prism.shader.Texture_LinearGradient_PAD_AlphaTest_Loader;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Kristina on 27.10.16.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Veenäitude esitamine");

        VBox veenaidud = new VBox();
        veenaidud.setAlignment(Pos.CENTER);
        Scene veenait = new Scene(veenaidud, 350, 500);
        primaryStage.setScene(veenait);
        primaryStage.show();

        Label soevesi = new Label("Sooja vee näit");
        TextField soenait = new TextField();
        soenait.setMaxWidth(50);
        Label kulmvesi = new Label("Külma vee näit");
        TextField kulmnait = new TextField();
        kulmnait.setMaxWidth(50);
        Label aadress = new Label("Sisesta oma aadress");
        TextArea elukoht = new TextArea();
        elukoht.setMaxWidth(250);
        elukoht.setMinHeight(150);
        Button saadaNait = new Button("Saada näidud");

        veenaidud.getChildren().addAll(soevesi, soenait, kulmvesi, kulmnait, aadress, elukoht, saadaNait);

        saadaNait.setOnAction(event -> {
            String muutuja1 = elukoht.getText();
            String muutuja2 = soenait.getText();
            String muutuja3 = kulmnait.getText();
            String teade = String.format("Tere! Aadressi %s sooja vee näit on %s ja külma vee näit on %s.", muutuja1, muutuja2, muutuja3);
            System.out.println(teade);
            Label preview = new Label(teade);
            preview.setTextFill(Color.BURLYWOOD);
            veenaidud.getChildren().add(preview);
        });

    }
}
