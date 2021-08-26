package com.aharoo.controllers;

import com.aharoo.services.ChangeSceneService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ExplanationOfMetricsController {

    private ChangeSceneService changeSceneService = new ChangeSceneService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button mainPage;

    @FXML
    void initialize() {
       mainPage.setOnAction(event -> {
           String path = "/com/aharoo/views/mainView.fxml";
           String title = "Private clouds evaluation";
           changeSceneService.changeScene(mainPage,path,title);
       });

    }
}
