package cc.oobootcamp.principle.srp.printer;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements StringPrinter{

    private String filePath;

    public FilePrinter(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void print(String string) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(string);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
