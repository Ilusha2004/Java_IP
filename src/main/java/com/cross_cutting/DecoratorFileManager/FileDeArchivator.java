package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.EnumTypes.Extensions;
import com.cross_cutting.HelpfulThings.FilePath;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.cross_cutting.DecoratorFileManager.FileSource.*;

public class FileDeArchivator extends DataDecorator{

    public FileDeArchivator(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData() throws Exception {

        if(getInExtension().equals(Extensions.ZIP)) {
            ZipDeArchiving();
        }
        else if(getInExtension().equals(Extensions.JAR)) {
            JarDeArchiving();
        }
        else if(getInExtension().equals(Extensions.RAR)) {
            RarDeArchiving();
        }

        System.out.println("DeArchive part");

        super.writeData();

    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void ZipDeArchiving() {

        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(getFilePath().getPath()))) {
            ZipEntry entry;

            while((entry = zin.getNextEntry()) != null) {

                FileOutputStream fout = new FileOutputStream("src/res/archiveAndEncrypt/new_" + getFilePath().getName() + "." + FileSource.getFilePath().getFirstExtension());
                FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/new_" + getFilePath().getName() + "." + FileSource.getFilePath().getFirstExtension()));
                FileSource.setname("new_" + getFilePath().getName());

                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                fout.flush();
                zin.closeEntry();
                fout.close();
            }

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public void RarDeArchiving() {

        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(getFilePath().getPath()))) {
            ZipEntry entry;

            while((entry = zin.getNextEntry()) != null) {

                FileOutputStream fout = new FileOutputStream("src/res/archiveAndEncrypt/new_" + getFilePath().getName() + "." + FileSource.getFilePath().getFirstExtension());
                FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/new_" + getFilePath().getName() + "." + FileSource.getFilePath().getFirstExtension()));
                FileSource.setname("new_" + getFilePath().getName());

                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                fout.flush();
                zin.closeEntry();
                fout.close();
            }

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public void JarDeArchiving() {

        try(JarInputStream zin = new JarInputStream(new FileInputStream(getFilePath().getPath()))) {
            JarEntry entry;

            while((entry = (JarEntry) zin.getNextEntry()) != null) {

                FileOutputStream fout = new FileOutputStream("src/res/archiveAndEncrypt/new_" + getFilePath().getName() + "." + FileSource.getFilePath().getFirstExtension());
                FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/new_" + getFilePath().getName() + "." + FileSource.getFilePath().getFirstExtension()));
                FileSource.setname("new_" + getFilePath().getName());

                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                fout.flush();
                zin.closeEntry();
                fout.close();
            }

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}
