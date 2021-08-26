package com.aharoo.errors;

import javafx.scene.control.Alert;

public class ErrorsHandler {
    public void emptyOrIncorrectFieldsErrorMessage(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("EmptyOrIncorrectFieldsError");
        alert.setHeaderText(null);
        alert.setContentText("Some of the fields are empty or incorrect,please check your inputs!");

        alert.showAndWait();
    }
}
