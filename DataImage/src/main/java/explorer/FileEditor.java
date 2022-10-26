package explorer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileEditor {

    public void writeStringIntoFile(String fileName, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
