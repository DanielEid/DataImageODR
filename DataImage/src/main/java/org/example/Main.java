package org.example;

import fileControler.FileEditor;
import fileControler.FileExplorer;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * File research test
     * This part create a list of file searched and transform it into a String
     */
    private static void writeFileListIntoFileAsString(FileExplorer fileExplorer, FileEditor fileEditor, String filePathOfIndexedFilePath) {
        List<File> fileList = fileExplorer.getFilesInDirectories(fileExplorer.getDirectory()); //Save the path of wanted files
        StringBuilder fileListString = new StringBuilder();
        for (int i = 0; i < fileList.size() - 1; i++) { //Transform the list into string, many way tested, this is the more light and not add [] (like toString()
            fileListString.append(fileList.get(i)).append(",");
        }
        fileListString.append(fileList.get(fileList.size() - 1));

        /*
         * File test editor (Write into file and read into file)
         * 1- Write a file with data (string) and path
         */
        fileEditor.writeStringIntoFile(filePathOfIndexedFilePath, String.valueOf(fileListString)); // 1-Write data to a file given by the path
        //TODO remove string transformation step

    }

    private static List<File> getFileListFromFileAsList(FileEditor fileEditor, String filePathOfIndexedFilePath) {
        /*
         * File test editor (Write into file and read into file)
         * 2- Read the data in a file from path and get a String
         * 3- Transform the String in a List<String> with split
         * 4- Foreach the List<String> and for each item create a file with the path
         */
        String dataReadFromFile = fileEditor.readDataAsStringFile(filePathOfIndexedFilePath); // 2- Get the data in a file type string
        String[] dataReadFromFileSplit = dataReadFromFile.split(","); //3-

        List<File> fileListFromFile = new ArrayList<>(); //4
        for (String item : dataReadFromFileSplit) {
            fileListFromFile.add(new File(item));
        }

        return fileListFromFile;
    }

    private static void testApp() {
        String filesToBeIndexedPath = "C:/Users/Daniel/Videos/Captures";
        String filePathOfIndexedFilePath = "C:/Users/Daniel/Videos/Captures/filesPathIndexed.txt";
        FileEditor fileEditor = new FileEditor();
        FileExplorer fileExplorer = new FileExplorer(filesToBeIndexedPath, Arrays.asList("png", "jpg"));
        //TODO test with wrong path
        //TODO make tests for whole project

        //System.out.println("current path: " + fileExplorer.getAppCurrentPath()); //Print current path

        // writeFileListIntoFileAsString(fileExplorer, fileEditor, filePathOfIndexedFilePath);
        //getFileListFromFileAsList(fileEditor, filePathOfIndexedFilePath);

        //TODO fix exception when path is wrong for write and read
        //TODO see with gson
    }

    public static void main(String[] args) {
        //testApp();

        /*
        long startTime = System.currentTimeMillis(); //TIMER START
        long finishTime = System.currentTimeMillis(); //TIMER END
        System.out.println("That took: " + (finishTime - startTime) + " ms"); //TIMER OUT
        */

        String filePathOfIndexedFilePath = "C:/Users/Daniel/Videos/Captures/filesPathIndexed.txt";
        List<File> imagesPath = getFileListFromFileAsList(new FileEditor(), filePathOfIndexedFilePath);

        ArrayList<String> imagesScanResult = new ArrayList<>();

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:/Users/Daniel/Videos/Captures/tessdata");


        try {
            for (int i=0; i<imagesPath.size(); i++) { //not foreach loop, I need index
                imagesScanResult.add(tesseract.doOCR(imagesPath.get(i)));
                System.out.println(String.format("%d of %d scanned images",i,imagesPath.size()));
            }
        }
        catch (TesseractException e){
            e.printStackTrace();
        }
        System.out.println(imagesScanResult);

    }
}