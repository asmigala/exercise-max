package org.jboss.qe.dvqe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader implements MyFileReaderInterface {
    String path;

    public MyFileReader(String path) {
        this.path = path;
    }

    public int getNumberOfLines() {
        return readLines().size();
    }

    public int getNumberOfNonEmptyLines() {
        int numberOfNonEmptyLines = 0;
        for(String line: readLines())
            if(line.isEmpty() == false)
                numberOfNonEmptyLines++;
        return numberOfNonEmptyLines;
    }

    public List<String> readLines() {
        return readFirstNLines(-1);
    }

    public List<String> readFirstNLines(int numberOfLines) {
        List<String> nLines = new ArrayList<>();
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null && numberOfLines != 0)
            {
                nLines.add(line);
                numberOfLines--;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nLines;
    }
}
