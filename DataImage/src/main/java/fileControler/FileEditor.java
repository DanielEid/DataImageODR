package fileControler;

import java.io.*;

public class FileEditor {

    /**
     * @param filePathAndName: Path and name of of the file that will be created (ex: C:/myfile.txt)
     * @param data: Data  that will be written to the file, type string
     */
    public void writeStringIntoFile(String filePathAndName, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePathAndName));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param filePath:  Path of the file that will be readed
     * @return the data (type string) of file with line returns
     */
    public String readDataAsStringFile(String filePath) {
        try {
            StringBuilder fileData = new StringBuilder();
            String line;

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                fileData.append(line).append("\n");
            }
            return fileData.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
