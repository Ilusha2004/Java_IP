package com.cross_cutting.DecoratorFileManager;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

public class FileEncrypt extends DataDecorator {

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
        try {
            Cipher cipher_encrypted = Cipher.getInstance("AES");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            Key key = keyGenerator.generateKey();
            cipher_encrypted.init(Cipher.ENCRYPT_MODE, key);
            System.out.println(key.getEncoded());
            byte[] cipherText = cipher_encrypted.doFinal(new FileInputStream("src/res/" + FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension()).readAllBytes());
            FileOutputStream fileOutputStream = new FileOutputStream("src/res/archiveAndEncrypt/encrypted_" + FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension());
            setEncryptedPath("src/res/archiveAndEncrypt/encrypted_" + FileSource.getFilePath().getName());
            fileOutputStream.write(cipherText);
            fileOutputStream.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setEncryptedPath(String encryptedPath) {
        FileSource.getFilePath().setEncryptedPath(encryptedPath);
    }

    public static String getEncryptedPath() {
        return FileSource.getFilePath().getEncryptedPath();
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
