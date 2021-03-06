package fiit.stuba.sk.chovanak.GUI;
	
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	@Override
    public void start(Stage primaryStage) {
        try {
        
            AnchorPane page = (AnchorPane) FXMLLoader.load(Main.class.getResource("main-view.fxml"));
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("UI - VIEW");
            primaryStage.show();
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
