package cc.oobootcamp.principle.srp;

import cc.oobootcamp.principle.srp.printer.FilePrinter;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringHandlerTest {

    private static String tmpFilePath = "/tmp/data.txt";

    @AfterClass
    public static void afterAll() throws IOException {
        Files.delete(Paths.get(tmpFilePath));
    }

    @Test
    public void shouldReturnSourceTargetWhenStringHandlerToPrintStringGivenFormatDateString(){
        String inputDate = "2019-01-19";
        StringHandler stringHandler = new StringHandler(inputDate);
        stringHandler.convert();

        String result = stringHandler.toPrintString();
        assertEquals("Source = 2019-01-19; Target = 20190119", result);
    }

    @Test
    public void shouldReturn20190119WhenStringHandlerGivenDateFormat() {
        StringHandler stringHandler = new StringHandler("2019-01-19");
        String result = stringHandler.convert();
        stringHandler.print();
        assertEquals("20190119", result);
    }

    @Test
    public void shouldReturnCharacterCountFormatWhenConvertGivenNonDateFormat() {
        StringHandler stringHandler = new StringHandler("abcd");
        String result = stringHandler.convert();
        assertEquals("{a=1, b=1, c=1, d=1}", result);
    }

    @Test
    public void shouldReturnCharacterCountFormatWhenConvertGivenNonDateFormatContainDate() {
        StringHandler stringHandler = new StringHandler("abcd 2019-01-19");
        String result = stringHandler.convert();
        assertEquals("{0=2,  =1, 1=3, a=1, 2=1, b=1, c=1, d=1, 9=2, -=2}", result);
    }

    @Test
    public void shouldReturn20190119WhenConvertStringGivenNewDateFormat() {
        StringHandler stringHandler = new StringHandler("2019/01/19");
        String result = stringHandler.convert();
        stringHandler.print();
        assertEquals("20190119", result);
    }

    @Test
    public void shouldPrintToFileWhenPrintGivenDateFormat() throws IOException {
        FilePrinter filePrinter = new FilePrinter(tmpFilePath);
        StringHandler stringHandler = new StringHandler("2019-01-19", filePrinter);
        stringHandler.convert();
        stringHandler.print();

        String contentFromFile = new String(Files.readAllBytes(Paths.get(tmpFilePath)));
        assertEquals("20190119", contentFromFile);
    }

    @Test
    public void shouldPrintToFileWhenPrintGivenNewDateFormat() throws IOException {
        FilePrinter filePrinter = new FilePrinter(tmpFilePath);
        StringHandler stringHandler = new StringHandler("2019/01/19", filePrinter);
        stringHandler.convert();
        stringHandler.print();

        String contentFromFile = new String(Files.readAllBytes(Paths.get(tmpFilePath)));
        assertEquals("20190119", contentFromFile);
    }

    @Test
    public void shouldPrintToFileWhenPrintGivenNotDateFormatString() throws IOException {
        FilePrinter filePrinter = new FilePrinter(tmpFilePath);
        StringHandler stringHandler = new StringHandler("abcd", filePrinter);
        stringHandler.convert();
        stringHandler.print();

        String contentFromFile = new String(Files.readAllBytes(Paths.get(tmpFilePath)));
        assertEquals("{a=1, b=1, c=1, d=1}", contentFromFile);
    }

}
