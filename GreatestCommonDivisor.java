import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GreatestCommonDivisor extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

         GridPane root = new GridPane();
                  root.setHgap(10);
                  root.setVgap(10);

        TextField textField1 = new TextField();
        Label firstLabel = new Label("a = ");
        TextField textField2 = new TextField();
        Label secondLabel = new Label("b = ");
        Button enter = new Button("Euclid");
        Label out = new Label("_");

        root.add(firstLabel, 0, 1);
        root.add(textField1, 1, 1);
        root.add(secondLabel, 0, 2);
        root.add(textField2, 1 , 2);
        root.add(enter, 0, 3);       
        root.add(out, 1, 3);       

        //Creating the mouse event handler 
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
            
           public void handle(MouseEvent e) { 

                  System.out.println("Clicked");

                  Integer a = Integer.valueOf(textField1.getText());

                  Integer b = Integer.valueOf(textField2.getText());

                  Integer result = gcd(a,b);
 
                  out.setText("GCD (" + a + ","+ b +" ) = " + result.toString());

                  System.out.println(result);   
           } 
        };  

        enter.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Greatest Common Divisor");
        primaryStage.show();
    }

    //iterative implementation
    public static int gcd(int x, int y) {

              while( y != 0 ) {

                   int holder = y;
 
                       y = x % y;  

                       x = holder;
              }

              return x;
    }


    public static void main(String[] args) {

        launch(args);
    }
}

