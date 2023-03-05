package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriterToFile {
    public WriterToFile(ArrayList<String> data) {
        String surname = data.get(0);
        String filePath = "src/main/java/org/example/Base/" + surname + ".txt";
        File file = new File(filePath);
        if (!file.exists()){
            try {
                file.createNewFile();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write (String.format("\n%s %s %s %s %s %s", data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5)));
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }
}