package cross_cutting.DecoratorFileManager;


import cross_cutting.EnumTypes.Actions;
import cross_cutting.EnumTypes.Extensions;
import cross_cutting.HelpfulThings.FilePath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.cert.Extension;

public class CreateActionForFile {
    private final String path;
    private final Extensions inExtension;
    private final Extensions outExtension;
    private final Actions actions;
    private final Extensions archiveExtension;
    private DataDecorator dec;
    private File tempFile;

    public CreateActionForFile(String path, Extensions inExtension, Extensions outExtension, Actions actions, Extensions archiveExtension) {
        this.path = path;
        this.inExtension = inExtension;
        this.outExtension = outExtension;
        this.actions = actions;
        this.archiveExtension = archiveExtension;
    }

    public String getPath() {
        return path;
    }

    public Extensions getInExtension() {
        return inExtension;
    }

    public Extensions getOutExtension() {
        return outExtension;
    }

    public void CreateAction() throws IOException {

        tempFile = new File(path);

        if (actions.equals(Actions.ARCHIVE)) {
            dec = new FileArchivator(new FileSource(path, inExtension, outExtension, actions, archiveExtension));
        }
        else if (actions.equals(Actions.ENCRYPT)) {
            dec = new FileEncrypt(new FileSource(path, inExtension, outExtension, actions, archiveExtension));
        }
        else if (actions.equals(Actions.ARCHIVE_AND_ENCRYPT)) {
            dec = new FileArchivator(new FileEncrypt(new FileSource(path, inExtension, outExtension, actions, archiveExtension)));
        }
        else if (actions.equals(Actions.ENCRYPT_AND_ARCHIVE)) {
            dec = new FileEncrypt(new FileArchivator(new FileSource(path, inExtension, outExtension, actions, archiveExtension)));
        }

    }

    public void start() throws Exception {
        dec.readData();
        dec.writeData();
        tempFile.createNewFile();
    }

}
