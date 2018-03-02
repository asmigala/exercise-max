package org.jboss.qe.dvqe;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;

public class MyFileReaderUsingUtilsTest {
    MyFileReaderUsingUtils myFileReaderUsingUtils;

    @BeforeMethod
    public void setUp() {
        myFileReaderUsingUtils = new MyFileReaderUsingUtils("src/test/resources/testText.txt");
    }

    @Test
    public void testGetNumberOfLines() {
        Assert.assertEquals(myFileReaderUsingUtils.getNumberOfLines(), 7);
    }

    @Test
    public void testGetNumberOfNonEmptyLines() {
        Assert.assertEquals(myFileReaderUsingUtils.getNumberOfNonEmptyLines(), 4);
    }

    @Test
    public void testReadLines() {
        String[] lines = {"first", "second", "", "fourth", "", "", "seventh"};
        Assert.assertEquals(myFileReaderUsingUtils.readLines(), Arrays.asList(lines));
    }

    @Test
    public void testReadFirstNLines() {
        String[] lines = {"first", "second", ""};
        Assert.assertEquals(myFileReaderUsingUtils.readFirstNLines(3), Arrays.asList(lines));
    }

}