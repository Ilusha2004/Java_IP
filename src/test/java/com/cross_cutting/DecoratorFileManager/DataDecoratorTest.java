package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.EnumTypes.Extensions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataDecoratorTest {

    private DataDecorator dec;

    private File file;

    @Test
    public void decTest() throws Exception {
        file = new File("src/res/test2.xml");
        dec = new FileArchivator(new FileSource(file.getPath(), Extensions.JAR));
        dec.writeData();
        File file1 = new File("src/res/archiveAndEncrypt/archived_test2.jar");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    public void decTest2() throws Exception {
        file = new File("src/res/test2.xml");
        dec = new FileArchivator(
                new FileArchivator(
                        new FileSource(file.getPath(), Extensions.ZIP)));
        dec.writeData();
        File file1 = new File("src/res/archiveAndEncrypt/archived_archived_test2.zip");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    public void decTest3() throws Exception {
        file = new File("src/res/test2.xml");
        dec = new FileArchivator(
                new FileArchivator(
                        new FileArchivator(
                                new FileArchivator(
                                        new FileArchivator(
                                                new FileArchivator(
                                                        new FileArchivator(
                                                                new FileArchivator(
                                                                        new FileArchivator(
                                                                                new FileArchivator(
                                                                                        new FileSource(file.getPath(), Extensions.ZIP)))))))))));
        dec.writeData();
        File file1 = new File("src/res/archiveAndEncrypt/archived_archived_archived_archived_archived_archived_archived_archived_archived_archived_test2.zip");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    public void decTest4() throws Exception {
        file = new File("src/res/test2.xml");
        dec = new FileArchivator(
                new FileDeArchivator(
                        new FileSource(file.getPath(), Extensions.ZIP)));
        dec.writeData();
        File file1 = new File("src/res/archiveAndEncrypt/new_test2.xml");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    public void decTest5() throws Exception {
        file = new File("src/res/test2.xml");
        dec = new FileDeArchivator(
                new FileArchivator(
                        new FileSource(file.getPath(), Extensions.ZIP)));
        dec.writeData();
        File file1 = new File("src/res/archiveAndEncrypt/archived_test2.zip");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    public void decTest6() throws Exception {
        file = new File("src/res/test2.xml");
        dec = new FileEncrypt(
                new FileDecode(
                        new FileSource(file.getPath(), Extensions.ZIP)));
        dec.writeData();
        File file1 = new File("src/res/archiveAndEncrypt/uncoded_encrypted_test2.xml");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    public void decTest7() throws Exception {
        file = new File("src/res/test2.xml");
        dec = new FileArchivator(
              new FileArchivator(
              new FileArchivator(
              new FileArchivator(
              new FileArchivator(
              new FileArchivator(
              new FileArchivator(
              new FileArchivator(
              new FileArchivator(
              new FileArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(
              new FileDeArchivator(new FileSource(file.getPath(), Extensions.ZIP))))))))))))))))))))))))))))));
        dec.writeData();
        File file1 = new File("src/res/archiveAndEncrypt/new_test2.xml");
        Assertions.assertEquals(file1.exists(), true);
    }




}