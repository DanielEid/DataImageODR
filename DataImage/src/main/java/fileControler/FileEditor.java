package fileControler;

import java.io.*;

public class FileEditor {

    public void writeStringIntoFile(String filePathAndName, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePathAndName));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readDataAsStringFile(String filePath) {
        try {
            String fileData = "";
            String line;

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                fileData += line + "\n";
            }
            return fileData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
