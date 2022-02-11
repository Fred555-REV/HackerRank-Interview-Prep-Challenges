package test;

public class Main {
    public static void main(String[] args) {
        int start = 60000;
        int increase = 500;
        int current = start; // current price of keys
        int amount = 100; //keys bought or to buy
        int total = 0;
        for (int i = 0; i < amount; i++) {
            total += current;
            current += increase;
        }
        System.out.println(total);
    }
}
