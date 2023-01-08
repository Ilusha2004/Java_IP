package com.grapfx.guisup;

import java.util.Arrays;
import java.util.List;

public class Scenes {
    private List<String> allPath = Arrays.asList("MainTitle.fxml", "SceneTwo.fxml");
    private Integer counter = 0;

    public void Increase() {
        if(counter >= 0 && counter < allPath.size() - 1){
            counter++;
        }
    }

    public void Decrease() {
        if(counter > 0 && counter < allPath.size()) {
            counter--;
        }
    }

    public List<String> getAllPath() {
        return allPath;
    }

    public Integer getCounter() {
        return counter;
    }
}
