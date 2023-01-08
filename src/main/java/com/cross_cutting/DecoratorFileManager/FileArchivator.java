package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.HelpfulThings.FilePath;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static com.cross_cutting.DecoratorFileManager.FileSource.getFilePath;

public class FileArchivator extends DataDecorator {

    public static String archivePath;

    public FileArchivator(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData() throws Exception {
        ZipArchiving();
        FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/" + getFilePath().getName() + ".zip"));
        System.out.println("Archive part");
        super.writeData();
    }

    @Override
    public String readData() {
        return super.readData();
    }


    public void ZipArchiving() {

        try(ZipOutputStream zout = new ZipOutputStream(
                new FileOutputStream("src/res/archiveAndEncrypt/" + getFilePath().getName() + ".zip"));
            FileInputStream fis = new FileInputStream(getFilePath().getPath());) {
            FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/" + getFilePath().getName() + ".zip"));
            ZipEntry entry1 = new ZipEntry(getFilePath().getPath());
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
                new FileOutputStream("src/res/archiveAndEncrypt/" + getFilePath().getName() + ".rar"));
            FileInputStream fis = new FileInputStream(getFilePath().getPath());) {
            FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/" + getFilePath().getName() + ".rar"));
            ZipEntry entry1 = new ZipEntry(getFilePath().getPath());
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
                new FileOutputStream("src/res/archiveAndEncrypt/" + getFilePath().getName() + ".jar"));
            FileInputStream fis = new FileInputStream(getFilePath().getPath());) {
            FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/" + getFilePath().getName() + ".jar"));
            JarEntry jarEntry = new JarEntry(getFilePath().getPath());
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

}
