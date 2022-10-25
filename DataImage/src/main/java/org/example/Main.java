package org.example;

import explorer.FileExplorer;

public class Main {
    public static void main(String[] args) {
        FileExplorer fileExplorer = new FileExplorer("C:/Users/Daniel/Videos/Captures");
        //TODO test with wrong path

        System.out.println("current path: " + fileExplorer.getAppCurrentPath());
        //fileExplorer.getFilesInOneDirectory();
        fileExplorer.getFilesInDirectories(fileExplorer.getDirectory());
    }
}