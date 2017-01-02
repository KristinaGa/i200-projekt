import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Kristina on 02/01/17.
 */
public class LoginAken {
    TextField kasutajanimi;
    PasswordField password;
    VBox login;
    Button loginNupp;
    Hyperlink registreeri;
    Stage stage = new Stage();

//    Constructor, käivitame vajalikud funktsioonid
    LoginAken() {
        loginEkraan();
        setupLoginNupp();
        setupRegistreeri();
    }

    private void loginEkraan(){
//        joonistame Login ekraani väljad ja sildid
        stage.setTitle("Veenäitude esitamine");

        login = new VBox();
        login.setAlignment(Pos.CENTER);
        Scene loginScene = new Scene(login, 300, 500);

        Label kasutajanimiLabel = new Label("Kasutajanimi (e-mail)");
        kasutajanimi = new TextField();
        kasutajanimi.setMaxWidth(200);

        Label passwordLabel = new Label("Parool");
        password = new PasswordField();
        password.setMaxWidth(200);

        loginNupp = new Button("Logi sisse");
        registreeri = new Hyperlink("Registreeri");

        login.getChildren().addAll(kasutajanimiLabel, kasutajanimi, passwordLabel, password, loginNupp, registreeri);

        stage.setScene(loginScene);
        stage.show();
    }

    private void setupLoginNupp() {
//        login nupu loogika ja liikumine näitude sisestamise ekraanile
        loginNupp.setOnAction(event -> {
            new SisestaNaidud();
            stage.close();
        });
    }

    private void setupRegistreeri() {
//        registreeri nupu loogika ja kasutaja registreerimine..
        registreeri.setOnAction(event -> {
            new SisestaNaidud();
            stage.close();
        });
    }
}
