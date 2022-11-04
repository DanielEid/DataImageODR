package org.example;

import com.google.gson.Gson;
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
        StringBuilder fileListString = new StringBuilder();
        for (int i = 0; i < fileList.size() - 1; i++) { //Transform the list into string, many way tested, this is the more light and not add [] (like toString()
            fileListString.append(fileList.get(i) + ",");
        }
        fileListString.append(fileList.get(fileList.size() - 1));

        /*
         * File test editor (Write into file and read into file)
         * 1- Write a file with data (string) and path
         * 2- Read the data in a file from path and get a String
         * 3- Transform the String in a List<String> with split
         * 4- Foreach the List<String> and for each item create a file with the path
         */
        fileEditor.writeStringIntoFile(filePathOfIndexedFilePath, String.valueOf(fileListString)); // 1-Write data to a file given by the path
        String dataReadedFromFile = fileEditor.readDataAsStringFile(filePathOfIndexedFilePath); // 2- Get the data in a file type string
        String[] dataReadedFromFileSplited = dataReadedFromFile.split(","); //3-

        List<File> fileListFromFile = new ArrayList<>(); //4
        for (String item : dataReadedFromFileSplited) {
            fileListFromFile.add(new File(item));
        }

        System.out.println(fileListFromFile);
        //TODO fix exception when path is wrong for write and read
        //TODO see with gson
    }

    public static void main(String[] args) {
        testApp();

        /*
        long startTime = System.currentTimeMillis(); //TIMER STARTTTTTTTTTTTTTTTTTT
        long finishTime = System.currentTimeMillis(); //TIMER ENDDDDDDDDDDDDDDDDDDD
        System.out.println("That took: " + (finishTime - startTime) + " ms"); //TIMER OUTTTTTTTTTTTTTTTTT
        */
    }
}