package cross_cutting.DecoratorFileManager;


import cross_cutting.EnumTypes.Actions;
import cross_cutting.EnumTypes.Extensions;

public class CreateActionForFile {
    private final String path;
    private final Extensions inExtension;
    private final Extensions outExtension;
    private final Actions actions;
    private DataDecorator dec;

    public CreateActionForFile(String path, Extensions inExtension, Extensions outExtension, Actions actions) {
        this.path = path;
        this.inExtension = inExtension;
        this.outExtension = outExtension;
        this.actions = actions;
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

    public DataDecorator CreateAction() {

        if (actions.equals(Actions.ARCHIVE)) {
            dec = new FileArchivator(new FileSource(path, inExtension, outExtension, actions));
        } else if (actions.equals(Actions.ENCRYPT)) {
            dec = new FileEncrypt(new FileSource(path, inExtension, outExtension, actions));
        } else if (actions.equals(Actions.ARCHIVE_AND_ENCRYPT)) {
            dec = new FileArchivator(new FileEncrypt(new FileSource(path, inExtension, outExtension, actions)));
        } else if (actions.equals(Actions.ENCRYPT_AND_ARCHIVE)) {
            dec = new FileEncrypt(new FileArchivator(new FileSource(path, inExtension, outExtension, actions)));
        }

        return dec;
    }

    public void start() throws Exception {
        dec.readData();
        dec.writeData();
    }
}
