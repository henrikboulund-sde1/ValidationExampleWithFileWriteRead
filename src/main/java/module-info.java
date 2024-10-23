module dk.easv.exercise431solution {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.exercise431solution to javafx.fxml;
    exports dk.easv.exercise431solution;
}