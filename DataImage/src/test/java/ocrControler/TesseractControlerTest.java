package ocrControler;

import ScannedImagesController.ImageScanned;
import fileControler.FileExplorer;
import net.sourceforge.tess4j.Tesseract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TesseractControlerTest {

    private TesseractControler tesseractControlerTest;

    @BeforeEach
    void setUp() {
        tesseractControlerTest = new TesseractControler("C:/Users/Daniel/Videos/Captures/tessdata");
    }

    @Test
    void getTesseract() {
        assertInstanceOf(Tesseract.class, tesseractControlerTest.getTesseract());
    }

    @Test
    void setTesseract() {
        Tesseract tesseract0 = new Tesseract();
        tesseractControlerTest.setTesseract(tesseract0);
        assertSame(tesseract0, tesseractControlerTest.getTesseract());
    }

    @Test
    void getDataScanOneImage() {
        assertEquals("0522I85q\n", tesseractControlerTest.getDataScanOneImage(new File("ImageOCRTest/test.png")));
    }

    @Test
    void getDataScanOneImageAsImageScanned() {
        ImageScanned im = tesseractControlerTest.getDataScanOneImageAsImageScanned(new File("ImageOCRTest/test.png"));
        assertEquals(new File("ImageOCRTest/test.png").getPath(), im.getImagePath());
        assertEquals("0522I85q\n", im.getDataScanned());
    }

    @Test
    void getDataScanImagesList() {
        FileExplorer fileExplorer = new FileExplorer("ImageOCRTest", Arrays.asList("png", "jpg"));
        List<File> imagesList = fileExplorer.getFilesInDirectories(fileExplorer.getDirectory());
        List<ImageScanned> imLists = tesseractControlerTest.getDataScanImagesList(imagesList);

        for (ImageScanned im : imLists) {
            assertTrue(im.getDataScanned().length() > 0);  //here to test if the data is scanned, not for the result
        }
    }
}