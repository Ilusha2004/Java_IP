package com.grapfx.guisup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Test {

    private String str;

    @FXML
    private Circle circle;
    private double x = 317;
    private double y = 238;

    public void up(ActionEvent e){
        System.out.println("pressed up");
        circle.setCenterY(x +=  1);
    }

    public void down(ActionEvent e){
        System.out.println("pressed up");
        circle.setCenterY(x -= 1);
    }


    private void Absorb() {

    }

}
