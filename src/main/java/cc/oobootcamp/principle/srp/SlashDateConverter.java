package cc.oobootcamp.principle.srp;

public class SlashDateConverter implements Converter {
    @Override
    public Boolean match(String dateString) {
        return dateString.matches("\\d{4}/\\d{2}/\\d{2}");
    }

    @Override
    public String convert(String dateString) {
        return dateString.replaceAll("/", "");
    }
}
