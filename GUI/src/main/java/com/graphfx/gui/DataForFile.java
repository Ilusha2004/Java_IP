package com.graphfx.gui;

import cross_cutting.EnumTypes.Actions;
import cross_cutting.EnumTypes.Extensions;

public class DataForFile {

    private String path;
    private Extensions inExtensions;
    private Extensions outExtension;
    private Actions actions;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Extensions getInExtensions() {
        return inExtensions;
    }

    public void setInExtensions(Extensions inExtensions) {
        this.inExtensions = inExtensions;
    }

    public Extensions getOutExtension() {
        return outExtension;
    }

    public void setOutExtension(Extensions outExtension) {
        this.outExtension = outExtension;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }
}
