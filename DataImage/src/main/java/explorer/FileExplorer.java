package explorer;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileExplorer {

    private String directory;

    public FileExplorer(String directory) {
        this.directory = directory;
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

    /**
     * This function print the list of
     * @param currentDirectory : Current directory
     * @// TODO: 25/10/2022
     */
    public void getFilesInDirectories(String currentDirectory) {
        List<File> fileList = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files
                .newDirectoryStream(Paths.get(currentDirectory))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.toFile());
                }
                else if (Files.isDirectory(path)) {
                    getFilesInDirectories(path.toString());
                }
                else throw new IOException("Error the program doesn't detect "+ path.toString() + " as a file or a directory");
                //TODO: Must fix the exceptions control it's not a good way
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileList.forEach(System.out::println);
        //TODO save as file or other
    }

}
