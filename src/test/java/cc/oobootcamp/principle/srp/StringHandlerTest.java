package cc.oobootcamp.principle.srp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHandlerTest {

    @Test
    void shouldReturn20190119WhenStringHandlerGivenDateFormat() {
        StringHandler stringHandler = new StringHandler("2019-01-19");
        String result = stringHandler.convert();
        stringHandler.print();
        assertEquals("20190119", result);
    }

    @Test
    void shouldReturnCharacterCountFormatWhenStringHandlerGivenNonDateFormat() {
        StringHandler stringHandler = new StringHandler("abcd");
        String result = stringHandler.convert();
        assertEquals("{a=1, b=1, c=1, d=1}", result);
    }

    @Test
    void shouldReturn20190119WhenStringHandlerGivenNewDateFormat() {
        StringHandler stringHandler = new StringHandler("2019/01/19");
        String result = stringHandler.convert();
        stringHandler.print();
        assertEquals("20190119", result);
    }

}
