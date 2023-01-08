package com.cross_cutting.Archive;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeArchive {

    private String path;
    private String name;
    private String extension;

    public DeArchive(String path) {
        String[] arr = path.replace(".", " ").split(" ");
        this.name = arr[0];
        this.extension = arr[1];
        this.path = path;
    }

    public void ZipArchivation() {

        try(ZipInputStream zout = new ZipInputStream(new FileInputStream(this.name + ".zip"));
            FileOutputStream fout = new FileOutputStream("src/res/" + path);) {

            for (int c = zout.read(); c != -1; c = zout.read()) {
                fout.write(c);
            }
            fout.flush();
            zout.closeEntry();
            fout.close();

        }
        catch(Exception e){
            e.getStackTrace();
        }

    }

    public void ZipDeArchiving() {

        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(this.name + ".zip"))) {

            ZipEntry entry;
            String Name;
            long size;

            while((entry = zin.getNextEntry()) != null) {

                Name = entry.getName(); // получим название файла
                size=entry.getSize();  // получим его размер в байтах
                System.out.printf("File name: %s \t File size: %d \n", Name, size);

                // распаковка
                FileOutputStream fout = new FileOutputStream("src/res/" + Name);

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

        try(JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(this.name + ".jar"));
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

    public static void main(String[] args) {

        DeArchive archive = new DeArchive("src/res/archiveAndEncr/jsout.zip");
        System.out.println(archive.name + "\n" + archive.path + "\n" + archive.extension);

        archive.ZipDeArchiving();


    }

}
