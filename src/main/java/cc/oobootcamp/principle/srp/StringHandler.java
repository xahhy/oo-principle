package cc.oobootcamp.principle.srp;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StringHandler {

    private static final Logger LOGGER = Logger.getLogger(StringHandler.class.getName());

    private String source;

    private String target;

    private static final List<Converter> CONVERTER_LIST = Arrays.asList(
            new DashDateConverter(),
            new SlashDateConverter());

    public StringHandler(String source) {
        this.source = source;
    }

    public String convert() {
        for (Converter converter : CONVERTER_LIST) {
            if (converter.match(source)) {
                target = converter.convert(source);
                return target;
            }
        }
        target = countChars().toString();
        return target;
    }

    private Map<String, Long> countChars() {
        return Arrays.stream(source.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    public void print() {
        LOGGER.info(toPrintString());
    }

    public String toPrintString() {
        return "Source = " + source + "; Target = " + target;
    }
}
