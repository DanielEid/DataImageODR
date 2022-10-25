package explorer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileExplorer {

    private String directory;

    public FileExplorer(String directory) {
        this.directory = directory;
    }

    @Override
    public String toString() {
        return "FileExplorer{" +
                "directory='" + directory + '\'' +
                '}';
    }

    //Functions


    public String getAppCurrentPath(){
        return System.getProperty("user.dir");
    }
    public String getFilesInDirectory(){

// Reading only files in the directory
        try {
            List<File> files = Files.list(Paths.get(this.directory))
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .collect(Collectors.toList());

            files.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "d";
    }

}
