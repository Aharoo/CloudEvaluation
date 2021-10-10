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

    public void cloudWasSavedSuccessfullyMessage(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CloudWasSavedSuccessfullyMessage");
        alert.setHeaderText(null);
        alert.setContentText("New cloud rating was saved successfully!");

        alert.showAndWait();
    }
}
