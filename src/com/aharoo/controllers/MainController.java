package com.aharoo.controllers;

import com.aharoo.services.ChangeSceneService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    private ChangeSceneService sceneService = new ChangeSceneService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button explanationOfMetrics;

    @FXML
    private Button dataEntry;

    @FXML
    private Button cloudRating;

    @FXML
    private Button exit;


    @FXML
    void initialize() {

        explanationOfMetrics.setOnAction(event -> {
            String path = "/com/aharoo/views/explanationOfMetrics.fxml";
            String title = "Private clouds evaluation";
            sceneService.changeScene(explanationOfMetrics,path,title);
        });

        dataEntry.setOnAction(event -> {
            String path = "/com/aharoo/views/dataEntry.fxml";
            String title = "Private clouds evaluation";
            sceneService.changeScene(dataEntry,path,title);
        });

        cloudRating.setOnAction(event -> {
            String path = "/com/aharoo/views/cloudRating.fxml";
            String title = "Private clouds evaluation";
            sceneService.changeScene(cloudRating,path,title);
        });

        exit.setOnAction(event -> {
            Platform.exit();
        });
    }
}
