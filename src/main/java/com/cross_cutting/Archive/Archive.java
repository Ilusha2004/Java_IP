package com.laba_6b.archive;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {

    private String path;
    private String name;

    public Archive(String path) {
        String[] arr = path.replace(".", " ").split(" ");
        this.name = arr[0];
        this.path = path;
    }

    public void ZipArchivation() {
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("resourses/archiveAndEncr/" + name + ".zip"));
            FileInputStream fis = new FileInputStream("resourses/" + path);) {
                
            ZipEntry entry1 = new ZipEntry("text.txt");
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
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("resourses/archiveAndEncr/" + name + ".rar"));
            FileInputStream fis = new FileInputStream("resourses/" + path);) {
                
            ZipEntry entry1 = new ZipEntry("text.txt");
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
        try(JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream("resourses/archiveAndEncr/" + name + ".jar"));
            FileInputStream fis = new FileInputStream("resourses/" + path);) {
                JarEntry jarEntry = new JarEntry(path);
                jarOutputStream.putNextEntry(jarEntry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                jarOutputStream.write(buffer);
                jarOutputStream.closeEntry();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
}