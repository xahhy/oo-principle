package cc.oobootcamp.principle.srp;

public class Client {
    public static void main(String[] args) {
        StringHandler stringHandler = new StringHandler("2019-01-19");
        stringHandler.convert();
        stringHandler.print();

        StringHandler stringHandler1 = new StringHandler("abcd");
        stringHandler1.convert();
        stringHandler1.print();
    }
}
