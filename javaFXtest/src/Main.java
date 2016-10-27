import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by Kristina on 27.10.16.
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        /*Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();

        Circle ring = new Circle(100);
        ring.setCenterX(-50);
        ring.setCenterY(200);
        pane.getChildren().add(ring);


        //teen eventhandler'i - kui klikin ringil, siis juhtub midagi
        ring.setOnMouseClicked(event -> {
            System.out.println("KLIKK");
            ring.setCenterX(30);
        });*/


        //Näide - sisselogimine
        VBox vbox = new VBox();
        Scene login = new Scene(vbox, 200, 150);
        primaryStage.setScene(login);
        primaryStage.show();

        Label pealkiri = new Label("Mis on parool?");
        TextField paroolField = new TextField();
        Button submitButton = new Button("Login");

        vbox.getChildren().addAll(pealkiri, paroolField, submitButton);

        Circle ring = new Circle(50);
        Pane pane = new Pane();
        pane.getChildren().add(ring);
        Scene seeStseen = new Scene(pane, 600, 500);

        submitButton.setOnAction(event -> {
            System.out.println("KLIKK");
            String parool = paroolField.getText();
            if (parool.equals("minuPassword")){
                System.out.println("õige");
                primaryStage.setScene(seeStseen);
            } else {
                System.out.println("vale parool");
            }

        });

    }
}
