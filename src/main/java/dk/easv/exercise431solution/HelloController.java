package dk.easv.exercise431solution;

import bll.ValidationLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAge;

    @FXML
    private Label lblValidationText;

    private ValidationLogic validationLogic = new ValidationLogic();


    private void showMessageBox(Alert.AlertType alertType, String title, String headerText, String messageText)
    {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(messageText);
        alert.showAndWait();
    }

    public void onBtnValidate(ActionEvent actionEvent)
    {
        if(txtName.getText().isEmpty())
        {
            showMessageBox(Alert.AlertType.ERROR, "Missing information", "Name is not provided", "Your name is not entered. Please do it before validation can be done.");
        }
        else if(txtAge.getText().isEmpty())
        {
            showMessageBox(Alert.AlertType.ERROR, "Missing information", "Age is not provided", "Your age is not entered. Please do it before validation can be done.");
        }
        else if(!validationLogic.isNumeric(txtAge.getText()))
        {
            showMessageBox(Alert.AlertType.ERROR, "Input validation failed", "Age is not a number", "You have entered an age that is not a number");
        }
        else
        {
            int age = Integer.parseInt(txtAge.getText());
            boolean validation = validationLogic.validate(age);
            lblValidationText.setVisible(true);

            if (validation) {
                lblValidationText.setText(String.format("Hello %s, your age is %s and is valid", txtName.getText(), age));
                lblValidationText.setTextFill(Color.GREEN);
            } else {
                lblValidationText.setText(String.format("Hello %s, your age is %s and is not valid", txtName.getText(), age));
                lblValidationText.setTextFill(Color.DARKRED);
            }
        }
    }

    public void onBtnReset(ActionEvent actionEvent)
    {
        txtName.setText("");
        txtAge.setText("");
        lblValidationText.setVisible(false);
    }
}