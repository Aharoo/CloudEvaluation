package com.aharoo.controllers;

import com.aharoo.models.Rating;
import com.aharoo.services.ChangeSceneService;
import com.aharoo.services.ChartService;
import com.aharoo.services.RatingService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CloudRatingController {

    private ObservableList<Rating> cloudRatings = FXCollections.observableArrayList();
    private RatingService ratingService = new RatingService();
    private ChangeSceneService sceneService = new ChangeSceneService();
    private ChartService chartService = new ChartService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Rating> tableView;

    @FXML
    private TableColumn<Rating, String> cloudName;

    @FXML
    private TableColumn<Rating, Double> rating;

    @FXML
    private TableColumn<Rating, Double> mainRating;

    @FXML
    private TableColumn<Rating, Double> sideRating;

    @FXML
    private Button mainPage;

    @FXML
    private Button deleteCloud;

    @FXML
    private Button addNewCloud;

    @FXML
    private BarChart<String, Number> ratingChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    void initialize() {
        cloudRatings.addAll(ratingService.getAllCloudRatings());


        cloudName.setCellValueFactory(new PropertyValueFactory<Rating,String>("name"));
        rating.setCellValueFactory(new PropertyValueFactory<Rating,Double>("rating"));
        mainRating.setCellValueFactory(new PropertyValueFactory<Rating,Double>("mainRating"));
        sideRating.setCellValueFactory(new PropertyValueFactory<Rating,Double>("sideRating"));

        tableView.setItems(cloudRatings);

        chartService.getCharts(cloudRatings,ratingChart);

        mainPage.setOnAction(event -> {
            String path = "/com/aharoo/views/mainView.fxml";
            String title = "Private clouds evaluation";
            sceneService.changeScene(mainPage,path,title);
        });

        addNewCloud.setOnAction(event -> {
            String path = "/com/aharoo/views/dataEntry.fxml";
            String title = "Private clouds evaluation";
            sceneService.changeScene(addNewCloud,path,title);
        });

        deleteCloud.setOnAction(event -> {
            Rating selectedItem = tableView.getSelectionModel().getSelectedItem();
            ratingService.deleteCloudRating(selectedItem);
            tableView.getItems().remove(selectedItem);
        });

    }

}
