package hust.soict.dsai.javafx;

import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
public class PainterController {
	
	    @FXML
	    private Pane drawingAreaPane;
	    @FXML
	    private RadioButton rbtnPen;

	    @FXML
	    private RadioButton rbtnEraser;
	    @FXML
	    void drawingAreaMouseDragged(MouseEvent event) {
	    	Circle newCircle;
	    	if(rbtnPen.isSelected())	    		
	    	     newCircle= new Circle(event.getX(),event.getY(),4,Color.BLACK);
	    	else newCircle= new Circle(event.getX(),event.getY(),4,Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
	    }

	    @FXML
	    void clearButtonPressed(ActionEvent event) {
	    	drawingAreaPane.getChildren().clear();
	    }

}

