package org.example;

import com.google.gson.Gson;
import fileControler.FileControler;
import fileControler.FileEditor;
import fileControler.FileExplorer;
import ocrControler.TesseractControler;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        long startTime = System.currentTimeMillis(); //TIMER START
        long finishTime = System.currentTimeMillis(); //TIMER END
        System.out.println("That took: " + (finishTime - startTime) + " ms"); //TIMER OUT
        */

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
         * List that contains the scan result for each image
         */
        HashMap<String, String> imagesScanResult = new HashMap<>();
        /*
         * Creation of the tesseractController
         */
        TesseractControler tesseractControler = new TesseractControler("C:/Users/Daniel/Videos/Captures/tessdata");
        /*
         * Scan the list of images provided
         */
        //System.out.println(tesseractControler.getDataScanImagesList(imagesPath));

        Gson gson = new Gson();
        imagesScanResult.put("Mypath/to/thefile.txt","This is my data as text scanned");
        String json = gson.toJson(imagesScanResult);
        System.out.println(json);

    }
}