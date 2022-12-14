package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.HelpfulThings.FilePath;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static com.cross_cutting.DecoratorFileManager.FileEncrypt.getKey;

public class FileDecode extends DataDecorator{

    public FileDecode(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData() throws Exception {
        if(getKey() != null) {
            System.out.println("Decoder part");
            Decoding();
        }
        super.writeData();
    }

    @Override
    public String readData() {
        return super.readData();
    }

    public void Decoding() throws Exception {
        Cipher cipher_deencrypted = Cipher.getInstance("AES");
        cipher_deencrypted.init(Cipher.DECRYPT_MODE, getKey());
        byte[] cipher_deencrypted_Text = cipher_deencrypted.doFinal(new FileInputStream(FileSource.getFilePath().getPath()).readAllBytes());
        FileOutputStream fileOutputStream = new FileOutputStream("src/res/archiveAndEncrypt/uncoded_" + FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getFirstExtension());
        FileSource.setname(FileSource.getFilePath().getName());
        FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/uncoded_" + FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension()));
        FileSource.setname(FileSource.getFilePath().getName());
        fileOutputStream.write(cipher_deencrypted_Text);
        fileOutputStream.close();
    }

    public static void main(String[] args) throws Exception {
        FileDecode dec = new FileDecode(new FileSource("src/res/archiveAndEncrypt/encrypted_test.txt"));

        dec.Decoding();

    }
}
