package application;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
			Group root = new Group();
			Scene scene = new Scene(root, 300, 250, Color.WHITE);
			Rectangle r1 = new Rectangle(50, 20, 50,100);
			r1.setFill(Color.BLUE);
			Line l1 = new Line(20, 120, 50, 30);
			l1.setStroke(Color.GREEN);
			Circle c1 = new Circle(90, 50, 20);
			c1.setFill(Color.RED);


			primaryStage.setTitle("Ma première fenêtre");
			primaryStage.setScene(scene);
			primaryStage.show();
			root.getChildren().addAll(r1,l1,c1);

			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
