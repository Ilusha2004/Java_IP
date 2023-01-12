package com.graphfx.gui;

import java.util.Arrays;
import java.util.List;

public class Scenes {
    private List<String> allPath = Arrays.asList("MainTitle.fxml", "SceneTwo.fxml", "SceneThree.fxml", "SceneOptions.fxml");
    private int counter = 0;

    public void Increase() {
        System.out.println(allPath.size());
        if(counter >= 0 && counter < allPath.size() - 1){
            counter++;
        }
    }

    public void Decrease() {
        if(counter > 0 && counter < allPath.size()) {
            counter-=1;
        }
    }

    public List<String> getAllPath() {
        return allPath;
    }

    public int getCounter() {
        return counter;
    }
}
