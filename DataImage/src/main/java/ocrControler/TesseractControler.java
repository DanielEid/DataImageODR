package ocrControler;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
     * @return the path of the image and the data scanned
     */
    public ArrayList<String> getDataScanOneImageAndImageName(File imagePath) {
        ArrayList<String> imageScanResult = new ArrayList<>();

        imageScanResult.add(imagePath.getPath());
        try {
            imageScanResult.add(tesseract.doOCR(imagePath));
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return imageScanResult;
    }

    /**
     * Scan and get the text of the list images provided
     * @return a hashmap wich contains the path of the images and the data scanned for each image
     */
    public HashMap<String, String> getDataScanImagesList(List<File> imagesPath) {
        HashMap<String, String> imagesScanResult = new HashMap<>();

        for (int i = 0; /*i<imagesPath.size()*/ i < 2; i++) {                                                  //not foreach loop, I need index
            imagesScanResult.put(imagesPath.get(i).getPath(), getDataScanOneImage(imagesPath.get(i)));
            System.out.println(String.format("%d of %d scanned images", i + 1, imagesPath.size()));
        }
        return imagesScanResult;
    }
}
