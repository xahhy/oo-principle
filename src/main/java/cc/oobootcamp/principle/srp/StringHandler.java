package cc.oobootcamp.principle.srp;

import cc.oobootcamp.principle.srp.converter.Converter;
import cc.oobootcamp.principle.srp.converter.CountCharsConverter;
import cc.oobootcamp.principle.srp.converter.DashDateConverter;
import cc.oobootcamp.principle.srp.converter.SlashDateConverter;
import cc.oobootcamp.principle.srp.printer.ConsolePrinter;
import cc.oobootcamp.principle.srp.printer.StringPrinter;

import java.util.Arrays;
import java.util.List;

public class StringHandler {

    private String source;

    private String target;

    private static final List<Converter> CONVERTER_LIST = Arrays.asList(
            new DashDateConverter(),
            new SlashDateConverter());

    private static final Converter DEFAULT_CONVERTER = new CountCharsConverter();

    private StringPrinter stringPrinter;

    public StringHandler(String source) {
        this.source = source;
        this.stringPrinter = new ConsolePrinter();
    }

    public StringHandler(String source, StringPrinter stringPrinter){
        this.source = source;
        this.stringPrinter = stringPrinter;
    }

    public String convert() {
        for (Converter converter : CONVERTER_LIST) {
            if (converter.match(source)) {
                target = converter.convert(source);
                return target;
            }
        }
        target = DEFAULT_CONVERTER.convert(source);
        return target;
    }


    public void print() {
        stringPrinter.print(target);
    }

    public String toPrintString() {
        return "Source = " + source + "; Target = " + target;
    }
}
