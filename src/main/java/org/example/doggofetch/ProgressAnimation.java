package org.example.doggofetch;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ProgressAnimation extends BorderPane {
    public ProgressAnimation(){

        BorderPane progressAnimation = new BorderPane();

        // progress bar animation
        BorderPane loadingBarPane = new BorderPane();
        ProgressBar loadingBar = new ProgressBar(0); //0% progress
        loadingBar.setPrefSize(200, 30);
        loadingBar.setProgress(0.1); // 10% progress
        Double currentProgress = loadingBar.getProgress();

        // progress spinning animation
        ProgressIndicator progressSpin = new ProgressIndicator();
        progressSpin.setPrefSize(130, 130);
        progressSpin.setStyle("progressSpin");

        // set center
        progressAnimation.setCenter(progressSpin);

        // progress value setting
        Double progress = progressSpin.getProgress();
        Text progreeLoadingTxt = new Text("Loading...");
        progressAnimation.setStyle("progressAnimation");
        progressAnimation.setBottom(progreeLoadingTxt);

        // change listener
        progressSpin.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Progress Changed: " + newValue);
            }
        });

        ///  update values of progress spinner
        progressSpin.setProgress(0.75);








    }
}
