package com.cross_cutting.DecoratorFileManager;

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
        switch (getFilePath().getExtension()) {
            case "zip":
                ZipDeArchiving();
                super.writeData();

            case "rar":
                RarDeArchiving();
                super.writeData();

            case "jar":
                JarDeArchiving();
                super.writeData();

            default:
                throw new UnsupportedOperationException("extension are not responded");
        }
    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void ZipDeArchiving() {

        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(getFilePath().getPath()))) {
            ZipEntry entry;

            while((entry = zin.getNextEntry()) != null) {

                FileOutputStream fout = new FileOutputStream("src/res/new" + getFilePath().getName());
                FileSource.setPath(new FilePath("src/res/new" + getFilePath().getName() + ".txt"));
                FileSource.setname("new" + getFilePath().getName());

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

                FileOutputStream fout = new FileOutputStream("src/res/new" + getFilePath().getName());
                FileSource.setPath(new FilePath("src/res/new" + getFilePath().getName() + ".txt"));
                FileSource.setname("new" + getFilePath().getName());

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

                FileOutputStream fout = new FileOutputStream("src/res/new" + getFilePath().getName());
                FileSource.setPath(new FilePath("src/res/new" + getFilePath().getName() + ".txt"));
                FileSource.setname("new" + getFilePath().getName());

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

    public static void main(String[] args) {
        try {
            FileDeArchivator decArc = new FileDeArchivator(new FileSource("src/res/archiveAndEncrypt/res.zip"));
            decArc.ZipDeArchiving();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
