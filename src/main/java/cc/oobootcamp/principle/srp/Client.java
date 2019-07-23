package cc.oobootcamp.principle.srp;

import cc.oobootcamp.principle.srp.printer.FilePrinter;

public class Client {
    public static void main(String[] args) {
        StringHandler stringHandler = new StringHandler("2019-01-19");
        stringHandler.convert();
        stringHandler.print();

        StringHandler stringHandler1 = new StringHandler("abcd");
        stringHandler1.convert();
        stringHandler1.print();

        FilePrinter filePrinter = new FilePrinter("/tmp/data.txt");
        StringHandler stringHandler2 = new StringHandler("2019-01-19", filePrinter);
        stringHandler2.convert();
        stringHandler2.print();

        StringHandler stringHandler3 = new StringHandler("abcd", filePrinter);
        stringHandler3.convert();
        stringHandler3.print();
    }
}
