package org.example;

import explorer.FileEditor;
import explorer.FileExplorer;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileExplorer fileExplorer = new FileExplorer("C:/Users/Daniel/Videos/Captures", Arrays.asList("png", "jpg"));
        //TODO test with wrong path
        new FileEditor().writeStringIntoFile("MonFichier.txt","Coucou bonsoir 2");

        System.out.println("current path: " + fileExplorer.getAppCurrentPath());
        fileExplorer.getFilesInDirectories(fileExplorer.getDirectory());
    }
}