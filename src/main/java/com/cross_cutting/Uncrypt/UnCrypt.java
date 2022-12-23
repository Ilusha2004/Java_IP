package com.laba_6b.uncrypt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class UnCrypt {

    private String path;
    private String encryptedPath;
    Key key;

    public UnCrypt(String path) {
        this.path = path;
    }

    public void Encrypt() throws Exception {
        Cipher cipher_encrypted = Cipher.getInstance("AES");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        key = keyGenerator.generateKey();
        cipher_encrypted.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher_encrypted.doFinal(new FileInputStream("resourses/" + path).readAllBytes());
        FileOutputStream fileOutputStream = new FileOutputStream("resourses/archiveAndEncr/encrypted_" + path);
        setEncryptedPath("resourses/archiveAndEncr/encrypted_" + path);
        fileOutputStream.write(cipherText);
        fileOutputStream.close();
    }

    public void Uncode() throws Exception {
        Cipher cipher_deencrypted = Cipher.getInstance("AES");
        cipher_deencrypted.init(Cipher.DECRYPT_MODE, key);
        byte[] cipher_deencrypted_Text = cipher_deencrypted.doFinal(new FileInputStream(getEncryptedPath()).readAllBytes());
        FileOutputStream fileOutputStream = new FileOutputStream("resourses/archiveAndEncr/uncoded_" + path);
        fileOutputStream.write(cipher_deencrypted_Text);
        fileOutputStream.close();
    }

    public void setEncryptedPath(String encryptedPath) {
        this.encryptedPath = encryptedPath;
    }

    public String getEncryptedPath() {
        return encryptedPath;
    }
}
