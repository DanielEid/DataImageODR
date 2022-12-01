package fileControler;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileExplorer {

    /**
     * @param: directory: directory where the function are executed
     * @param: exntentionFile: List of file extensions on which the file search will be performed
     */
    private String directory;
    private final List<String> extentionFile;

    public FileExplorer(String directory, List<String> extentionFile) {
        this.directory = directory;
        this.extentionFile = extentionFile;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public List<String> getExtentionFile() {
        return extentionFile;
    }

    /**
     * Show the path where the app are executed
     *
     * @return the current path of app
     */
    public String getAppCurrentPath() {
        return System.getProperty("user.dir");
    }

    /**
     * @deprecated
     * Print the list of files in this. directory
     * Code inspired by part 1.2 of the website
     * from https://howtodoinjava.com/java8/java-8-list-all-files-example/#1-listing-files-only-in-a-given-directory
     */
    public void getFilesInOneDirectory() {
        List<File> fileList = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files
                .newDirectoryStream(Paths.get(directory))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.toFile());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileList.forEach(System.out::println);
    }


    /**
     * This function return the list of all file in the sourcedirectory and sub-directories
     * With the given extention in
     * @param  sourceDirectory: directory where the scearch is performed
     * @return List<File>: List of all file in fileExplorer.directory and sub-directories
     */
    public List<File> getFilesInDirectories(String sourceDirectory){
        List<File> filesList = new ArrayList<>();
        getRecurviseFilesInDirectories(sourceDirectory,filesList);

        return filesList;
    }

    /**
     * This recursive function save the list of all file in the current directory and sub-directories in a var,
     * transmits from the function that calls this function. So no return needed
     * Files are added to the variable if they match the given path and extension
     * @param  filesList: list where the path's files are saved
     * @param currentDirectory : Current directory
     */
    private void getRecurviseFilesInDirectories(String currentDirectory, List<File> filesList) {
        List<Path> dirList = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files
                .newDirectoryStream(Paths.get(currentDirectory))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    if (fileMatchFileType(path)) {
                        filesList.add(path.toFile());
                    }
                } else if (Files.isDirectory(path)) {
                    dirList.add(path);
                } else
                    throw new IOException("Error the program doesn't detect " + path.toString() + " as a file or a directory");
                //TODO: Must fix the exceptions control it's not a good way
            }
            dirList.forEach(index -> getRecurviseFilesInDirectories(index.toString(),filesList)); //Call this function (recursive) for each path in this list (directories path)

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //TODO save as file or other
    }

    /**
     * Indicates whether the path contains the desired extension
     * @param path: path of the file to be tested
     * @return boolean
     */
    private boolean fileMatchFileType(Path path) {
        for (String extention : extentionFile) {
            if (path.toString().toLowerCase().endsWith(extention)) {
                return true;
            }
        }
        return false;
    }

}