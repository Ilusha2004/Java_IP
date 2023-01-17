package com.cross_cutting.DecoratorFileManager;

import com.cross_cutting.EnumTypes.Actions;
import com.cross_cutting.EnumTypes.Extensions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreateActionForFileTest {

    private CreateActionForFile createActionForFile;
    private File file;

    @Test
    void createAction() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ARCHIVE, Extensions.ZIP);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/encrypted_test2.xml");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction2() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ARCHIVE, Extensions.JAR);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/encrypted_test2.xml");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction3() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ARCHIVE, Extensions.RAR);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/encrypted_test2.xml");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction4() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ENCRYPT, Extensions.ZIP);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/encrypted_test2.xml");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction5() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ENCRYPT, Extensions.JAR);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/encrypted_test2.xml");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction6() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ENCRYPT, Extensions.RAR);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/encrypted_test2.xml");
        Assertions.assertEquals(file1.exists(), true);
    }


    @Test
    void createAction7() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ARCHIVE_AND_ENCRYPT, Extensions.ZIP);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/archived_encrypted_test2.zip");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction8() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ARCHIVE_AND_ENCRYPT, Extensions.JAR);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/archived_encrypted_test2.jar");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction9() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ARCHIVE_AND_ENCRYPT, Extensions.RAR);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/archived_encrypted_test2.rar");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction10() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ENCRYPT_AND_ARCHIVE, Extensions.ZIP);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/encrypted_archived_test2.zip");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction11() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ENCRYPT_AND_ARCHIVE, Extensions.JAR);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/encrypted_archived_test2.jar");
        Assertions.assertEquals(file1.exists(), true);
    }

    @Test
    void createAction12() throws Exception {
        file = new File("src/res/test2.xml");
        createActionForFile = new CreateActionForFile(file.getPath(), Actions.ENCRYPT_AND_ARCHIVE, Extensions.RAR);
        createActionForFile.CreateAction();
        createActionForFile.start();
        File file1 = new File("src/res/archiveAndEncrypt/archived_encrypted_test2.rar");
        Assertions.assertEquals(file1.exists(), true);
    }

}