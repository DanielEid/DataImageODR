package ScannedImagesController;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ImageScannedTest {

    private ImageScanned imageScannedTest;

    @BeforeEach
    void setUp() {
        imageScannedTest = new ImageScanned("PathOfTheFileTest/test", "Data scanned test");
    }

    @Test
    void ImageScanned() {
        ImageScanned imageScannedTestConstructor;
        imageScannedTestConstructor = new ImageScanned();

        assertNotNull(imageScannedTestConstructor);
        assertNull(imageScannedTestConstructor.getImagePath());
        assertNull(imageScannedTestConstructor.getDataScanned());
    }

    @Test
    void ImageScanned2() {
        ImageScanned imageScannedTestConstructor;
        imageScannedTestConstructor = new ImageScanned(new File("PathOfTheFileTest/test"),"Data scanned test");

        assertNotNull(imageScannedTestConstructor);
        assertEquals(new File("PathOfTheFileTest/test").getPath(), imageScannedTestConstructor.getImagePath());
        assertEquals("Data scanned test", imageScannedTestConstructor.getDataScanned());
    }

    @Test
    void ImageScanned3() {
        ImageScanned imageScannedTestConstructor;
        imageScannedTestConstructor = new ImageScanned("PathOfTheFileTest/test","Data scanned test");

        assertNotNull(imageScannedTestConstructor);
        assertEquals("PathOfTheFileTest/test", imageScannedTestConstructor.getImagePath());
        assertEquals("Data scanned test", imageScannedTestConstructor.getDataScanned());
    }

    @Test
    void getImagePath() {
        assertEquals("PathOfTheFileTest/test", imageScannedTest.getImagePath());
    }

    @Test
    void setImagePath() {
        imageScannedTest.setImagePath("Here");
        assertEquals("Here", imageScannedTest.getImagePath());
    }

    @Test
    void setImagePathAsFile() {
        imageScannedTest.setImagePath(new File("thepathname/test"));
        assertEquals(new File("thepathname/test").getPath(),imageScannedTest.getImagePath());
    }

    @Test
    void getDataScanned() {
        assertEquals("Data scanned test", imageScannedTest.getDataScanned());
    }

    @Test
    void setDataScanned() {
        imageScannedTest.setDataScanned("the new data");
        assertEquals("the new data", imageScannedTest.getDataScanned());
    }

    @Test
    void testToString() {
        assertEquals("ImageScanned{imagePath=PathOfTheFileTest/test, dataScanned='Data scanned test'}",imageScannedTest.toString());
    }
}

