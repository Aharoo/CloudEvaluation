package com.aharoo.controllers;

import com.aharoo.errors.ErrorsHandler;
import com.aharoo.models.Rating;
import com.aharoo.services.ChangeSceneService;
import com.aharoo.services.RatingService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DataEntryController {

    private ChangeSceneService sceneService = new ChangeSceneService();
    private ErrorsHandler errorsHandler = new ErrorsHandler();
    private RatingService ratingService = new RatingService();

    @FXML
    private Button mainPage;

    @FXML
    private Button enter;

    @FXML
    private TextField uploadSpeed;

    @FXML
    private TextField downloadSpeed;

    @FXML
    private TextField presenceOfEncryption;

    @FXML
    private TextField transmissionProtection;

    @FXML
    private TextField installationPlatform;

    @FXML
    private TextField grantingAccessForUsers;

    @FXML
    private TextField userInterface;

    @FXML
    private TextField proposalForDataProtection;

    @FXML
    private TextField historyOfChange;

    @FXML
    private TextField maximumFileSize;

    @FXML
    private TextField synchronizeChangesWithPC;

    @FXML
    private TextField viewFiles;

    @FXML
    private TextField appForSmartphone;

    @FXML
    private TextField freeSoftware;

    @FXML
    private TextField abilityToWorkWithoutInternet;

    @FXML
    private TextField abilityToChangeDirectories;

    @FXML
    private TextField cloudName;

    @FXML
    void initialize() {
        mainPage.setOnAction(event -> {
            String path = "/com/aharoo/views/mainView.fxml";
            String title = "Private clouds evaluation";
            sceneService.changeScene(mainPage,path,title);
        });
        enter.setOnAction(enter -> {
            if(cloudName.getText().trim().equals("")) {
                errorsHandler.emptyOrIncorrectFieldsErrorMessage();
                throw new IllegalStateException("Empty cloud name field");
            }
            Rating cloudRating = new Rating();
            try {

                double mainRating = 2 * (Integer.parseInt(uploadSpeed.getText()) * 1 + Integer.parseInt(downloadSpeed.getText()) * 1 +
                        Integer.parseInt(presenceOfEncryption.getText()) * 1.1 + Integer.parseInt(transmissionProtection.getText()) * 1.5 +
                        Integer.parseInt(proposalForDataProtection.getText()) * 1 + Integer.parseInt(historyOfChange.getText()) * 0.4 +
                        Integer.parseInt(maximumFileSize.getText()) * 0.5 + Integer.parseInt(appForSmartphone.getText()) * 0.2) / 100;

                double sideRating = 1.5 * (Integer.parseInt(installationPlatform.getText()) * 0.7 + Integer.parseInt(grantingAccessForUsers.getText()) * 0.9
                        + Integer.parseInt(userInterface.getText()) * 0.9 + Integer.parseInt(synchronizeChangesWithPC.getText()) * 0.5 +
                        Integer.parseInt(viewFiles.getText()) * 0.6 + Integer.parseInt(freeSoftware.getText()) * 0.3
                        + Integer.parseInt(abilityToWorkWithoutInternet.getText()) * 0.3 + Integer.parseInt(abilityToChangeDirectories.getText()) * 0.3) / 100;

                double rating = mainRating + sideRating;

                cloudRating.setName(cloudName.getText().trim());
                cloudRating.setRating(rating);
                cloudRating.setMainRating(mainRating);
                cloudRating.setSideRating(sideRating);

            } catch (NumberFormatException e){
                errorsHandler.emptyOrIncorrectFieldsErrorMessage();
            }
            ratingService.saveCloudRating(cloudRating);
            clearAllTextFields();
            System.out.println("Cloud rating generated successfully");
        });

    }

    public void clearAllTextFields(){
        uploadSpeed.clear();
        downloadSpeed.clear();
        presenceOfEncryption.clear();
        transmissionProtection.clear();
        proposalForDataProtection.clear();
        historyOfChange.clear();
        maximumFileSize.clear();
        appForSmartphone.clear();
        installationPlatform.clear();
        grantingAccessForUsers.clear();
        userInterface.clear();
        synchronizeChangesWithPC.clear();
        viewFiles.clear();
        freeSoftware.clear();
        abilityToWorkWithoutInternet.clear();
        abilityToChangeDirectories.clear();
        cloudName.clear();
    }

}
