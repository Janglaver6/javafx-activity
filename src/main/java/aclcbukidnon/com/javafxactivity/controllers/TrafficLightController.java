package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.Timer;



public class TrafficLightController {

    private enum TrafficLightColor {
        STOP,
        HOLD,
        GO,
    }


    private TrafficLightColor currentColor = TrafficLightColor.STOP;

    private Timeline timeline;


    @FXML
    public void initialize(){
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
    }


    ///  What happens if the time is up
    public void onTimerChange() {

    }

}
