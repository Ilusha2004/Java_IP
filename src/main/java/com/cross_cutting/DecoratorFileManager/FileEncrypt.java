package com.cross_cutting.DecoratorFileManager;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

public class FileEncrypt extends DataDecorator {

    private static Key key;
    private static String encryptedPath;

    public FileEncrypt(DecoratorFileInterface dec) {
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

    public void Encrypt() throws Exception {
        Cipher cipher_encrypted = Cipher.getInstance("AES");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        key = keyGenerator.generateKey();
        cipher_encrypted.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher_encrypted.doFinal(new FileInputStream(FileSource.getPath()).readAllBytes());
        FileOutputStream fileOutputStream = new FileOutputStream(FileSource.getPath());
        setEncryptedPath("resourses/archiveAndEncr/encrypted_" + FileSource.getPath());
        fileOutputStream.write(cipherText);
        fileOutputStream.close();
    }

    public void setEncryptedPath(String encryptedPath) {
        this.encryptedPath = encryptedPath;
    }

    public static String getEncryptedPath() {
        return encryptedPath;
    }

    public static Key getKey() {
        return key;
    }

    public static void setKey(Key key) {
        FileEncrypt.key = key;
    }

}
