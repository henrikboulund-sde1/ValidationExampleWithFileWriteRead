package dk.easv.exercise431solution;

import bll.ValidationLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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


    public void onBtnValidate(ActionEvent actionEvent)
    {
        int age = Integer.parseInt(txtAge.getText());
        boolean validation = validationLogic.validate(age);
        lblValidationText.setVisible(true);

        if(validation)
        {
            lblValidationText.setText(String.format("Hello %s, your age is %s and is valid", txtName.getText(), age));
            lblValidationText.setTextFill(Color.GREEN);
        }
        else
        {
            lblValidationText.setText(String.format("Hello %s, your age is %s and is not valid", txtName.getText(), age));
            lblValidationText.setTextFill(Color.DARKRED);
        }
    }
}