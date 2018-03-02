package org.jboss.qe.dvqe;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;

public class MyFileReaderTest {
    MyFileReader myFileReader;

    @BeforeMethod
    public void setUp() {
        myFileReader = new MyFileReader("src/test/resources/testText.txt");
    }

    @Test
    public void testGetNumberOfLines() {
        Assert.assertEquals(myFileReader.getNumberOfLines(), 7);
    }

    @Test
    public void testGetNumberOfNonEmptyLines() {
        Assert.assertEquals(myFileReader.getNumberOfNonEmptyLines(), 4);
    }

    @Test
    public void testReadLines() {
        String[] lines = {"first", "second", "", "fourth", "", "", "seventh"};
        Assert.assertEquals(myFileReader.readLines(), Arrays.asList(lines));
    }

    @Test
    public void testReadFirstNLines() {
        String[] lines = {"first", "second", ""};
        Assert.assertEquals(myFileReader.readFirstNLines(3), Arrays.asList(lines));
    }
}