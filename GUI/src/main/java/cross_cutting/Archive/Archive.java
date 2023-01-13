package cross_cutting.Archive;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {

    private String path;
    private String name;
    private String extension;

    public Archive(String path) {
        String[] arr = path.replace(".", " ").split(" ");
        this.name = arr[0];
        this.extension = arr[1];
        this.path = path;
    }

    public void ZipArchivation() {

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("src/res/archiveAndEncrypt" + name + ".zip"));
              FileInputStream fis = new FileInputStream("src/res/" + path);) {

            ZipEntry entry1 = new ZipEntry(path);
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

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("src/res/archiveAndEncrypt" + name + ".rar"));
              FileInputStream fis = new FileInputStream("src/res/" + path);) {

            ZipEntry entry1 = new ZipEntry(path);
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

        try (JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream("src/res/archiveAndEncrypt/" + name + ".jar"));
                         FileInputStream fis = new FileInputStream("src/res/" + path);) {

            JarEntry jarEntry = new JarEntry(path);
            jarOutputStream.putNextEntry(jarEntry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            jarOutputStream.write(buffer);
            jarOutputStream.closeEntry();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        Archive archive = new Archive("src/res/orderout.txt");
        archive.ZipArchivation();
    }

}