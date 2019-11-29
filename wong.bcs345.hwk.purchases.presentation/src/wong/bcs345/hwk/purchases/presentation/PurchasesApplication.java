package wong.bcs345.hwk.purchases.presentation;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The PurchasesApplication class creates a window instance from the FXML file and shows the scene 
 * <p>
 * Inherits from the Application class
 * </p>
 * 
 * @author Natalie Wong
 * @version HW#6
 *
 */
public class PurchasesApplication extends Application {

	@Override
	   public void start(Stage primaryStage) {
		  primaryStage.setTitle("Purchases");
	      Parent root = null;
	      Scene scene = null;
	      try {
	         FXMLLoader loader= new FXMLLoader(getClass().getResource("main.fxml"));
	         root = loader.load();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      // Put the root containing the FXML into the scene
	      scene = new Scene(root, 300, 275);
	      primaryStage.setScene(scene);
	      primaryStage.show();
	   }

}
