package org.example;

import ScannedImagesController.ImageScanned;
import fileControler.FileControler;
import fileControler.FileEditor;
import fileControler.FileExplorer;
import ocrControler.TesseractControler;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
         * Declaration needed
         */
        String filesToBeIndexedPath = "C:/Users/Daniel/Videos/Captures";
        String filePathOfIndexedFilePath = "C:/Users/Daniel/Videos/Captures/filesPathIndexed.txt";
        FileEditor fileEditor = new FileEditor();
        FileExplorer fileExplorer = new FileExplorer(filesToBeIndexedPath, Arrays.asList("png", "jpg"));

        /*
         * Get the file list of images that will be scanned
         */
        List<File> imagesPath = FileControler.getFileListFromFileAsList(new FileEditor(), filePathOfIndexedFilePath);
        /*
         * Creation of the tesseractController
         */
        TesseractControler tesseractControler = new TesseractControler("C:/Users/Daniel/Videos/Captures/tessdata");
        /*
         * Scan the list of images provided in a List
         */
        List<ImageScanned> imagesScanned = tesseractControler.getDataScanImagesList(imagesPath);
        /*
         * Save the imagesScanned in a file in json
         */
        fileEditor.writeDataAsJson("C:/Users/Daniel/Videos/Captures/ImagesScanned.json", imagesScanned);
    }
}