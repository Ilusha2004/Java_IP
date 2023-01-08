package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.HelpfulThings.FilePath;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import static com.cross_cutting.DecoratorFileManager.FileSource.getFilePath;

public class FileEncrypt extends DataDecorator {

    private static Key key;

    public FileEncrypt(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData() throws Exception {
        Encrypt();
        System.out.println("Encrypt part");
        super.writeData();
    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void Encrypt() throws Exception {

        try {
            Cipher cipher_encrypted   = Cipher.getInstance("AES");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            key                       = keyGenerator.generateKey();

            cipher_encrypted.init(Cipher.ENCRYPT_MODE, key);
            FileSource.setextension(FileSource.getFilePath().getExtension());
            byte[] cipherText = cipher_encrypted.doFinal(new FileInputStream("src/res/" + getFilePath().getName() + "." + getFilePath().getFirstExtension()).readAllBytes());
            FileOutputStream fileOutputStream = new FileOutputStream("src/res/archiveAndEncrypt/encrypted_" + getFilePath().getName() + "." + getFilePath().getExtension());
            FileSource.setname(FileSource.getFilePath().getName());
            FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/encrypted_" + getFilePath().getName() + "." + getFilePath().getExtension()));
            fileOutputStream.write(cipherText);
            fileOutputStream.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
