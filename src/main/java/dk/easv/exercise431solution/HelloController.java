package dk.easv.exercise431solution;

import be.ValidationObj;
import bll.FileDataLogic;
import bll.ValidationLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.util.List;

public class HelloController {
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAge;

    @FXML
    private Label lblValidationText;

    @FXML
    private ListView lstHistory;

    private ValidationLogic validationLogic = new ValidationLogic();
    private FileDataLogic fileDataLogic = new FileDataLogic();

    @FXML
    protected void initialize()
    {
        refreshView();
    }

    private void refreshView()
    {
        lstHistory.getItems().clear();
        List<ValidationObj> historyList = fileDataLogic.loadData();
        for(int i = 0; i<=historyList.size()-1; i=i+1)
        {
            ValidationObj obj = (ValidationObj) historyList.toArray()[i];
            lstHistory.getItems().add(obj.getName() + ", " + obj.getAge());
        }
    }

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

            ValidationObj obj = new ValidationObj(txtName.getText(), age);
            fileDataLogic.writeToFile(obj);

            refreshView();
        }
    }

    public void onBtnReset(ActionEvent actionEvent)
    {
        txtName.setText("");
        txtAge.setText("");
        lblValidationText.setVisible(false);
    }
}