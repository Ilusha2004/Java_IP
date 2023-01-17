package com.cross_cutting.DecoratorFileManager;


import com.cross_cutting.EnumTypes.Actions;
import com.cross_cutting.EnumTypes.Extensions;

import java.io.File;
import java.io.IOException;

public class CreateActionForFile {
    private final String path;
    private final Actions actions;
    private final Extensions archiveExtension;
    private DataDecorator dec;
    private File tempFile;

    public CreateActionForFile(String path, Actions actions, Extensions archiveExtension) {
        this.path = path;
        this.actions = actions;
        this.archiveExtension = archiveExtension;
    }

    public void CreateAction() throws IOException {

        tempFile = new File(path);

        if (actions.equals(Actions.ARCHIVE)) {
            dec = new FileArchivator(
                  new FileSource(path, archiveExtension));
        }
        else if (actions.equals(Actions.ENCRYPT)) {
            dec = new FileEncrypt(
                  new FileSource(path, archiveExtension));
        }
        else if (actions.equals(Actions.ARCHIVE_AND_ENCRYPT)) {
            dec = new FileArchivator(
                  new FileEncrypt(
                  new FileSource(path, archiveExtension)));
        }
        else if (actions.equals(Actions.ENCRYPT_AND_ARCHIVE)) {
            dec = new FileEncrypt(
                  new FileArchivator(
                  new FileSource(path, archiveExtension)));
        }

    }

    public void start() throws Exception {
        dec.readData();
        dec.writeData();
        tempFile.createNewFile();
    }

}
