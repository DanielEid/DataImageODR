package fileControler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileControler {

    public static void writeFileListIntoFileAsString(FileExplorer fileExplorer, FileEditor fileEditor, String filePathOfIndexedFilePath) {
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

    public static List<File> getFileListFromFileAsList(FileEditor fileEditor, String filePathOfIndexedFilePath) {
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
}
