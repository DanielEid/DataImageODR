package org.example;

import fileControler.FileEditor;
import fileControler.FileExplorer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filesToBeIndexedPath="C:/Users/Daniel/Videos/Captures";
        String filePathOfIndexedFilePath="C:/Users/Daniel/Videos/Captures/filesPathIndexed.txt";
        FileEditor fileEditor = new FileEditor();

        FileExplorer fileExplorer = new FileExplorer(filesToBeIndexedPath, Arrays.asList("png", "jpg"));
        //TODO test with wrong path

        //Test File search
        //System.out.println("current path: " + fileExplorer.getAppCurrentPath());
       // fileExplorer.getFilesInDirectories(fileExplorer.getDirectory());
        fileExplorer.superGet(fileExplorer.getDirectory());

        //Test file scearch
        // fileEditor.writeStringIntoFile(filePathOfIndexedFilePath,"Coucou bonsoir 2");
        //System.out.println(fileEditor.readDataAsStringFile(filePathOfIndexedFilePath));
        //TODO fix exception when path is wrong
    }
}