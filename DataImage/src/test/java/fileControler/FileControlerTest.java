package fileControler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileControlerTest {

    @Test
    void writeFileListIntoFileAsString() {
        FileControler.writeFileListIntoFileAsString(new FileExplorer("ImageOCRTest", Arrays.asList("jpg", "png")), new FileEditor(), "ImageOCRTest/imageList");
    }

    @Test
    void getFileListFromFileAsList() {
        File filetest = new File("ImageOCRTest/imageList");
        if (filetest.exists()) {
            FileControler.getFileListFromFileAsList(new FileEditor(), "ImageOCRTest/imageList");
        }
    }
}