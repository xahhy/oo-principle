package cc.oobootcamp.principle.srp;

public interface Converter {
    Boolean match(String dateString);
    String convert(String dateString);
}
