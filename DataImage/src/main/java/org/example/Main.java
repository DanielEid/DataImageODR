package org.example;

import fileControler.FileEditor;
import fileControler.FileExplorer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static void testApp() {
        String filesToBeIndexedPath = "C:/Users/Daniel/Videos/Captures";
        String filePathOfIndexedFilePath = "C:/Users/Daniel/Videos/Captures/filesPathIndexed.txt";
        FileEditor fileEditor = new FileEditor();
        FileExplorer fileExplorer = new FileExplorer(filesToBeIndexedPath, Arrays.asList("png", "jpg"));
        //TODO test with wrong path
        //TODO make tests for whole project

        /*
         * File research test
         * This part create a list of file searched
         * And transform it into a String
         */
        //System.out.println("current path: " + fileExplorer.getAppCurrentPath()); //Print current path
        List<File> fileList = fileExplorer.getFilesInDirectories(fileExplorer.getDirectory()); //Save the path of wanted files
        String fileListString = fileList.toString(); //Transform it into string to save in file

        /*
         * File test editor (Write into file and read into file)
         * 1- Write a file with data (string) and path
         * 2- Read the data in a file from path and get a String
         * 3- Transform the String in a List<String> with split
         * 4- Foreach the List<String> and for each item create a file with the path
         */
        fileEditor.writeStringIntoFile(filePathOfIndexedFilePath, fileListString); //Write data to a file given by the path
        String dataReadedFromFile = fileEditor.readDataAsStringFile(filePathOfIndexedFilePath); // Get the data in a file type string
        String[] myList = dataReadedFromFile.split(",");

        List<File> fileListFromFile = new ArrayList<>();
        for (String item : myList) {
            fileListFromFile.add(new File(item));
        }
        System.out.println(fileListFromFile);


        //TODO fix exception when path is wrong
    }

    public static void main(String[] args) {
        testApp();

    }
}