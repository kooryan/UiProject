package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Controller {
    @FXML
    public VBox pane;
    @FXML
    private Button addbutton;

    @FXML
    private TextField field;

    @FXML
    private void addNewTextField(ActionEvent event) {
        field = new TextField();

        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    field.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });


        pane.getChildren().add(field);

    }

    @FXML
    private void addNumbers(ActionEvent e) {

        ArrayList<Integer> numList = new ArrayList<>();


        try {
            ArrayList<Integer> list = new ArrayList<>();

            int result = Integer.parseInt(field.getText());

            list.add(result);




            int sum = 0;
            for (int i : numList) {
                sum += result;
                System.out.println("The sum of numbers is  = " + sum);
            }

        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
    }
}

