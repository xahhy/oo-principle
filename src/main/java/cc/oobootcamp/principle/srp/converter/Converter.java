package cc.oobootcamp.principle.srp.converter;

public interface Converter {
    Boolean match(String dateString);
    String convert(String dateString);
}
