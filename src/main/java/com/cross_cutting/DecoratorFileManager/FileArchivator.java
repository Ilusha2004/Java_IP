package com.cross_cutting.DecoratorFileManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileArchivator extends DataDecorator {

    public static String archivePath;

    public FileArchivator(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData(String data) {
        super.writeData(data);
    }

    @Override
    public String readData() {
        return super.readData();
    }


    public void ZipArchiving() {

        try(ZipOutputStream zout = new ZipOutputStream(
                new FileOutputStream("src/res/archiveAndEncrypt/" + FileSource.getFilePath().getName() + ".zip"));
            FileInputStream fis = new FileInputStream(FileSource.getFilePath().getPath());) {

            ZipEntry entry1 = new ZipEntry(FileSource.getFilePath().getPath());
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }
        catch(Exception e){
            e.getStackTrace();
        }

    }

    public void RarArchiving() {

        try(ZipOutputStream zout = new ZipOutputStream(
                new FileOutputStream("src/res/archiveAndEncrypt/" + FileSource.getFilePath().getName() + ".rar"));
            FileInputStream fis = new FileInputStream(FileSource.getFilePath().getPath());) {

            ZipEntry entry1 = new ZipEntry(FileSource.getFilePath().getPath());
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }

        catch(Exception e){
            e.getStackTrace();
        }

    }

    public void JarArchiving() {

        try(JarOutputStream jarOutputStream = new JarOutputStream(
                new FileOutputStream("src/res/archiveAndEncrypt/" + FileSource.getFilePath().getName() + ".jar"));
            FileInputStream fis = new FileInputStream(FileSource.getFilePath().getPath());) {
            JarEntry jarEntry = new JarEntry(FileSource.getFilePath().getPath());
            jarOutputStream.putNextEntry(jarEntry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            jarOutputStream.write(buffer);
            jarOutputStream.closeEntry();

        } catch (Exception e) {
            e.getStackTrace();
        }

    }


    public static String getArchivePath() {
        return archivePath;
    }

    public static void setArchivePath(String archivePath) {
        FileArchivator.archivePath = archivePath;
    }

    public static void main(String[] args) {
        FileArchivator archivator = new FileArchivator(new FileSource("src/res/res.json"));
        archivator.ZipArchiving();
        archivator.JarArchiving();
        archivator.RarArchiving();
    }
}
