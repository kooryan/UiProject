package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Controller {

    @FXML
    public VBox pane;
    @FXML
    public VBox pane1;
    @FXML
    public Label updateLabel;
    public TextField field;


    public void addNewTextField(ActionEvent event) {
        field = new TextField();

        field.setMinWidth(50);
        field.setPrefWidth(50);
        field.setMaxWidth(100);

        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    field.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        pane1.getChildren().add(field);

    }

    public void addNumbers(ActionEvent e) {

        try {
            ArrayList<Integer> list = new ArrayList<>();
            //Loop to group all the textfields made by RichikSC
            for (Node n : pane1.getChildren()) {
                int result = Integer.parseInt( ((TextField) n).getText());

                list.add(result);
            }
            int sum = 0;
            for (int i : list) {
                sum += i;
            }
            System.out.println("The sum of numbers = " + sum);

        } catch (NumberFormatException exception) {
            System.out.println("Your textfield(s) don't have a number!");
        }
    }
}

