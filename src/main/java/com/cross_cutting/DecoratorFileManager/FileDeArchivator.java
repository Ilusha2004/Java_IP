package com.cross_cutting.DecoratorFileManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileDeArchivator extends DataDecorator{

    public FileDeArchivator(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData(String data) throws Exception {
        switch (FileSource.getFilePath().getExtension()) {
            case "zip":
                ZipArchiving();
                super.writeData(data);

            case "rar":
                RarArchiving();
                super.writeData(data);

            case "jar":
                JarArchiving();
                super.writeData(data);

            default:
                throw new UnsupportedOperationException("extension are not responded");
        }
    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void ZipArchiving() {

        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(FileSource.getFilePath().getPath()))) {
            ZipEntry entry;

            while((entry = zin.getNextEntry()) != null) {

                FileOutputStream fout = new FileOutputStream("src/res/new" + FileSource.getFilePath().getName());

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

    public void RarArchiving() {

        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(FileSource.getFilePath().getPath()))) {
            ZipEntry entry;

            while((entry = zin.getNextEntry()) != null) {

                FileOutputStream fout = new FileOutputStream("src/res/new" + FileSource.getFilePath().getName());

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

    public void JarArchiving() {

        try(JarInputStream zin = new JarInputStream(new FileInputStream(FileSource.getFilePath().getPath()))) {
            JarEntry entry;

            while((entry = (JarEntry) zin.getNextEntry()) != null) {

                FileOutputStream fout = new FileOutputStream("src/res/new" + FileSource.getFilePath().getName());

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
            decArc.ZipArchiving();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
