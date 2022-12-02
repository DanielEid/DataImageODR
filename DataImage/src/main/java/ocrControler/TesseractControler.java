package ocrControler;

import ScannedImagesController.ImageScanned;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TesseractControler {

    private Tesseract tesseract;

    public Tesseract getTesseract() {
        return tesseract;
    }

    public void setTesseract(Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    public TesseractControler(String dataPath) {
        this.tesseract = new Tesseract();

        tesseract.setDatapath(dataPath);
    }

    /**
     * Scan and get the text of the image provided
     *
     * @return the data scanned
     */
    public String getDataScanOneImage(File imagePath) {
        String dataScanned = "";
        try {
            dataScanned = tesseract.doOCR(imagePath);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return dataScanned;
    }

    /**
     * Scan and get the text of the image provided
     *
     * @return the path of the image and the data scanned
     */
    public ImageScanned getDataScanOneImageAsImageScanned(File imagePath) {
        ImageScanned imageScanned = new ImageScanned();
        imageScanned.setImagePath(imagePath.getPath());

        try {
            imageScanned.setDataScanned(tesseract.doOCR(imagePath));
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return imageScanned;
    }

    /**
     * Scan and get the text of the list images provided
     *
     * @return a list of ImageScanned wich contains the path of the images and the data scanned for each image
     */
    public List<ImageScanned> getDataScanImagesList(List<File> imagesPath) {
        ArrayList<ImageScanned> imagesScannedList = new ArrayList<>();

        for (int i = 0; i < imagesPath.size(); i++) {                                                  //not foreach loop, I need index
            imagesScannedList.add(getDataScanOneImageAsImageScanned(imagesPath.get(i)));
            System.out.println(String.format("%d of %d scanned images", i + 1, imagesPath.size()));
        }
        return imagesScannedList;
    }
}
