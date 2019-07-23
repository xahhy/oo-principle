package cc.oobootcamp.principle.srp;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringHandlerTest {

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
    public void shouldReturn20190119WhenStringHandlerGivenNewDateFormat() {
        StringHandler stringHandler = new StringHandler("2019/01/19");
        String result = stringHandler.convert();
        stringHandler.print();
        assertEquals("20190119", result);
    }

}
