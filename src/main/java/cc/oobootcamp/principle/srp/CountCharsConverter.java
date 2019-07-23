package cc.oobootcamp.principle.srp;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountCharsConverter implements Converter {
    @Override
    public Boolean match(String dateString) {
        return true;
    }

    @Override
    public String convert(String dateString) {
        return countChars(dateString).toString();
    }


    private static Map<String, Long> countChars(String dateString) {
        return Arrays.stream(dateString.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
