package org.jboss.qe.dvqe;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReaderUsingUtils implements MyFileReaderInterface {
    String path;

    public MyFileReaderUsingUtils(String path) {
        this.path = path;
    }

    @Override
    public int getNumberOfLines() {
        return readLines().size();
    }

    @Override
    public int getNumberOfNonEmptyLines() {
        int numberOfNonEmptyLines = 0;
        for(String line: readLines())
            if(line.isEmpty() == false)
                numberOfNonEmptyLines++;
        return numberOfNonEmptyLines;
    }

    @Override
    public List<String> readLines() {
        File file = new File(path);
        List<String> lines = null;
        try {
            lines = FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public List<String> readFirstNLines(int numberOfLines) {
        List<String> lines = readLines();
        List<String> firstNLines = new ArrayList<>();
        if(numberOfLines > lines.size())
            System.out.println("NumberOfLines exceeds number of lines in given file.");
        else
            for(int i = 0; i < numberOfLines; i++) {
                firstNLines.add(lines.get(i));
            }
        return firstNLines;
    }
}
