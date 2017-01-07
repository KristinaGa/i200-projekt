import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class LoginAken {
    private TextField kasutajanimi;
    private PasswordField password;
    private VBox login;
    private Button loginNupp;
    private Hyperlink registreeri;
    private Stage stage = new Stage();
    private Label teavitus;

//  Constructor, käivitame vajalikud funktsioonid
    LoginAken() {
        teavitus = new Label();
        loginEkraan();
        setupLoginNupp();
        setupRegistreeri();
    }

//  Funktsioonid teadete jaoks
    private void annaViga(String teade){
        teavitus.setText(teade);
        teavitus.setTextFill(Color.RED);
    }

//  Joonistame Login ekraani väljad ja sildid
    private void loginEkraan(){
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

        login.getChildren().addAll(kasutajanimiLabel, kasutajanimi, passwordLabel, password, loginNupp, registreeri, teavitus);

        stage.setScene(loginScene);
        stage.show();
    }

//  Login nupu loogika ja liikumine näitude sisestamise ekraanile
    private void setupLoginNupp() {
        loginNupp.setOnAction(event -> {
            String username = kasutajanimi.getText();
            String parool = password.getText();

        if (!username.isEmpty() && !parool.isEmpty()){ //kontrollime, ega väljad pole tühjad
            try {
                Veenaidud naidud = new Veenaidud();
                Integer kasutaja_id = naidud.login(username, parool);
                naidud.sulgeYhendus();

                if (kasutaja_id != 0) {
                    new SisestaNaidud(kasutaja_id);
                    stage.close();
                } else {
                    annaViga("Vale parool!");
                }
            } catch (Exception e) {
                annaViga("Selliste andmetega kasutajat ei ole");
            }
        } else { //kui kumbki väli oli tühi, siis anna sellest teada
            annaViga("Mõlemad väljad peavad olema täidetud!");
        }
        });
    }

//  Registreeri nupu loogika ja kasutaja registreerimine
    private void setupRegistreeri() {
        registreeri.setOnAction(event -> {
            new KasutajaAndmed(0);
            stage.close();
        });
    }
}
