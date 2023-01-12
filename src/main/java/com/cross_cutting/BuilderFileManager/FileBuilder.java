package com.cross_cutting.BuilderFileManager;

import com.cross_cutting.EnumTypes.Extensions;

public class  FileBuilder implements BuilderFileInterface {

    private Extensions extensions;

    @Override
    public void setType(Extensions extensions) {
        this.extensions = extensions;
    }

    @Override
    public void setCompressed(String path, String outPath) {

    }

    @Override
    public void setEncoded(String path, String outPath) {

    }
}
