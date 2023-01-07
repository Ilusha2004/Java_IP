package com.cross_cutting.DecoratorFileManager;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static com.cross_cutting.DecoratorFileManager.FileEncrypt.getKey;

public class FileDecode extends DataDecorator{

    public FileDecode(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData(String data) throws Exception {
        if(getKey() == null) {
            Uncode();
        }

        super.writeData(data);
    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void Uncode() throws Exception {
        Cipher cipher_deencrypted = Cipher.getInstance("AES");
        cipher_deencrypted.init(Cipher.DECRYPT_MODE, getKey());
        byte[] cipher_deencrypted_Text = cipher_deencrypted.doFinal(new FileInputStream(FileSource.getFilePath().getPath()).readAllBytes());
        FileOutputStream fileOutputStream = new FileOutputStream("src/res/archiveAndEncrypt/uncoded_" + FileSource.getFilePath().getName());
        fileOutputStream.write(cipher_deencrypted_Text);
        fileOutputStream.close();
    }

    public static void main(String[] args) throws Exception {
        FileDecode dec = new FileDecode(new FileSource("src/res/archiveAndEncrypt/encrypted_test.txt"));

        dec.Uncode();

    }
}
