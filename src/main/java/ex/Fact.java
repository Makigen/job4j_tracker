package ex;

import java.util.Scanner;

public class Fact {
    public static void main(String[] args) {
        System.out.println("Insert number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0) {
            throw new IllegalArgumentException ("Number should be >= 0");
        } else {
            Fact fact = new Fact();
            System.out.println(fact.calc(n));
        }
    }

    public int calc(int n) {
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}