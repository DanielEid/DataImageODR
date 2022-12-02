package fileControler;

import ScannedImagesController.ImageScanned;
import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileEditorTest {

    FileEditor fileEditorTest;

    @BeforeEach
    void setUp() {
        fileEditorTest = new FileEditor();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void writeStringIntoFile() {
        fileEditorTest.writeStringIntoFile("ImageOCRTest/imageList", "data");
        assertEquals("data\n", fileEditorTest.readDataAsStringFile("ImageOCRTest/imageList"));
    }

    @Test
    void readDataAsStringFile() {
        fileEditorTest.writeStringIntoFile("ImageOCRTest/imageList", "data");
        assertEquals("data\n", fileEditorTest.readDataAsStringFile("ImageOCRTest/imageList"));
    }

    @Test
    void writeDataAsJson() {
        ImageScanned imageScannedTest = new ImageScanned("testPath", "testData");
        fileEditorTest.writeDataAsJson("ImageOCRTest/imageList", imageScannedTest);
        fileEditorTest.readDataAsStringFile("ImageOCRTest/imageList");
    }
}