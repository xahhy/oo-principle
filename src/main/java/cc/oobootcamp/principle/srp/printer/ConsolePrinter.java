package cc.oobootcamp.principle.srp.printer;

public class ConsolePrinter implements StringPrinter {
    @Override
    public void print(String string) {
        System.out.println(string);
    }
}
