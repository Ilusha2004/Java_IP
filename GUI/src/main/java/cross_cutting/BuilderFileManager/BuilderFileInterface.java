package cross_cutting.BuilderFileManager;


import cross_cutting.EnumTypes.Extensions;

public interface BuilderFileInterface {
    public void setType(Extensions extensions);

    public void setCompressed(String path, String outPath);

    public void setEncoded(String path, String outPath);


}
