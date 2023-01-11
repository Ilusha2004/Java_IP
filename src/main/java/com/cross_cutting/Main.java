package com.cross_cutting;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        String str = "src/res/test.txt";

        try(ZipOutputStream zout = new ZipOutputStream(
                new FileOutputStream("src/res/archiveAndEncrypt/" + "test"));
                FileInputStream fis = new FileInputStream("src/res/test.txt");) {

            ZipEntry entry1 = new ZipEntry("src/res/test.txt");
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        try {
            Cipher cipher_encrypted   = Cipher.getInstance("AES");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            Key key                       = keyGenerator.generateKey();

            cipher_encrypted.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher_encrypted.doFinal(new FileInputStream("src/res/" + "test").readAllBytes());
            FileOutputStream fileOutputStream = new FileOutputStream("src/res/archiveAndEncrypt/encrypted_" + "test");

            fileOutputStream.write(cipherText);
            fileOutputStream.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
