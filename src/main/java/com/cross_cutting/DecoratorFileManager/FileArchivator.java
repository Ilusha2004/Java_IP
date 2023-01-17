package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.EnumTypes.Extensions;
import com.cross_cutting.HelpfulThings.FilePath;

import java.io.File;
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
    public void writeData() throws Exception {

        System.out.println(FileSource.getFilePath().getPath());
        File file = new File(FileSource.getFilePath().getPath());

        System.out.println(FileSource.getFirstPath().getPath());
        System.out.println(FileSource.getFilePath().getPath());

//        if(file.getPath() != FileSource.getFirstPath().getPath()) {
//            file.delete();
//        }

        if (FileSource.getArchiveExtensions().equals(Extensions.ZIP)) {
            ZipArchiving();
        } else if (FileSource.getArchiveExtensions().equals(Extensions.JAR)) {
            JarArchiving();
        } else if (FileSource.getArchiveExtensions().equals(Extensions.RAR)) {
            RarArchiving();
        }


        super.writeData();
    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void ZipArchiving() {

        try (ZipOutputStream zout = new ZipOutputStream(
                                    new FileOutputStream("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".zip"));
             FileInputStream fis  = new FileInputStream(FileSource.getFilePath().getPath());) {

            ZipEntry entry1 = new ZipEntry(FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension());

            FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".zip"));

            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void RarArchiving() {
        try (ZipOutputStream zout = new ZipOutputStream(
                                    new FileOutputStream("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".rar"));
             FileInputStream fis  = new FileInputStream(FileSource.getFilePath().getPath());) {

            ZipEntry entry1 = new ZipEntry(FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension());

            FileSource.setPath(new FilePath(FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension()));

            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void JarArchiving() {

        try (JarOutputStream jarOutputStream = new JarOutputStream(
                                               new FileOutputStream("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".jar"));
                         FileInputStream fis = new FileInputStream(FileSource.getFilePath().getPath());) {

            JarEntry jarEntry = new JarEntry(FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension());

            FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/archived_" + FileSource.getFilePath().getName() + ".jar"));

            jarOutputStream.putNextEntry(jarEntry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            jarOutputStream.write(buffer);
            jarOutputStream.closeEntry();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static String getArchivePath() {
        return archivePath;
    }

    public static void setArchivePath(String archivePath) {
        FileArchivator.archivePath = archivePath;
    }

}
