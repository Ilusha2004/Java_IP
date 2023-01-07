package com.cross_cutting.DecoratorFileManager;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import static com.cross_cutting.DecoratorFileManager.FileSource.*;

public class FileEncrypt extends DataDecorator {

    private static Key key;

    public FileEncrypt(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData(String data) throws Exception {
        super.writeData(data);
    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void Encrypt() throws Exception {

        try {
            Cipher cipher_encrypted = Cipher.getInstance("AES");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            key = keyGenerator.generateKey();
            System.out.println(key);
            cipher_encrypted.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher_encrypted.doFinal(new FileInputStream("src/res/" + getFilePath().getName() + "." + getFilePath().getExtension()).readAllBytes());
            FileOutputStream fileOutputStream = new FileOutputStream("src/res/archiveAndEncrypt/encrypted_" + getFilePath().getName() + "." + getFilePath().getExtension());
            setEncryptedPath("src/res/archiveAndEncrypt/encrypted_" + getFilePath().getName());
            fileOutputStream.write(cipherText);
            fileOutputStream.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setEncryptedPath(String encryptedPath) {
        getFilePath().setEncryptedPath(encryptedPath);
    }

    public static String getEncryptedPath() {
        return getFilePath().getEncryptedPath();
    }

    public static Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public static void main(String[] args) throws Exception {
        try {
            FileEncrypt fen = new FileEncrypt(new FileSource("src/res/test.txt"));
            fen.Encrypt();
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
