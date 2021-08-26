package com.aharoo.services;

import com.aharoo.models.Rating;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class ChartService {
    public void getCharts(ObservableList<Rating> cloudRatings, BarChart<String, Number> ratingChart){

        XYChart.Series rating = new XYChart.Series<>();
        rating.setName("Rating");


        XYChart.Series mainRating = new XYChart.Series<>();
        mainRating.setName("Main rating");

        XYChart.Series sideRating = new XYChart.Series<>();
        sideRating.setName("Side rating");

        for (int i = 0; i < cloudRatings.size(); i++){
            rating.getData().add(new XYChart.Data<String,Number>(cloudRatings.get(i).getName(),cloudRatings.get(i).getRating()));
            mainRating.getData().add(new XYChart.Data<String,Number>(cloudRatings.get(i).getName(),cloudRatings.get(i).getMainRating()));
            sideRating.getData().add(new XYChart.Data<String,Number>(cloudRatings.get(i).getName(),cloudRatings.get(i).getSideRating()));
        }

        ratingChart.getData().addAll(rating,mainRating,sideRating);
    }
}
