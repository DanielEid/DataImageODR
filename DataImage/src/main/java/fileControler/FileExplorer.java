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


    @Override
    public String toString() {
        return "FileExplorer{" + "directory='" + directory + '\'' + '}';
    }

    /*
     * Function of listing
     *from https://howtodoinjava.com/java8/java-8-list-all-files-example/#1-listing-files-only-in-a-given-directory
     */

    public String getAppCurrentPath() {
        return System.getProperty("user.dir");
    }

    /**
     * Print the list of files in this. directory
     * Code inspired by part 1.2 of the website
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


    //Recursive functions

    public void superGet(String sourceDirectory){
        StringBuilder data = new StringBuilder(); //More efficient than String and concatenation
        getFilesInDirectories(sourceDirectory,data);

        System.out.println("coyucou");
        System.out.println(data.toString());
    }

    /**
     * This function print the list of all file in the current directory and sub-directories
     * With the given extention
     * @param currentDirectory : Current directory
     */
    public void getFilesInDirectories(String currentDirectory, StringBuilder data) { //TODO private
        List<File> filesList = new ArrayList<>();
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

            //filesList.forEach(System.out::println);
            data.append(filesList);
            dirList.forEach(index -> getFilesInDirectories(index.toString(),data)); //Call this function (recursive) for each path in this list (directories path)

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //TODO save as file or other
    }

    private boolean fileMatchFileType(Path path) {
        for (String extention : extentionFile) {
            if (path.toString().toLowerCase().endsWith(extention)) {
                return true;
            }
        }
        return false;
    }

}
