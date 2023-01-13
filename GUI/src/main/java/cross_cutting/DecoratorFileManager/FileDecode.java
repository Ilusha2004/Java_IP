package cross_cutting.DecoratorFileManager;

import cross_cutting.HelpfulThings.FilePath;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileDecode extends DataDecorator {

    public FileDecode(DecoratorFileInterface dec) {
        super(dec);
    }

    @Override
    public void writeData() throws Exception {
        if (FileEncrypt.getKey() != null) {
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
        cipher_deencrypted.init(Cipher.DECRYPT_MODE, FileEncrypt.getKey());
        byte[] cipher_deencrypted_Text = cipher_deencrypted.doFinal(new FileInputStream(FileSource.getFilePath().getPath()).readAllBytes());

        FileOutputStream fileOutputStream = new FileOutputStream("src/res/archiveAndEncrypt/uncoded_" + FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getFirstExtension());
        FileSource.setPath(new FilePath("src/res/archiveAndEncrypt/uncoded_" + FileSource.getFilePath().getName() + "." + FileSource.getFilePath().getExtension()));
        fileOutputStream.write(cipher_deencrypted_Text);
        fileOutputStream.close();
    }

}
