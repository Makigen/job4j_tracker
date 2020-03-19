package oop;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int matches = 11;
        int count = 1;
        int player = 1;
        System.out.println("Welcome to the MATCHES GAME! There are " + matches + " matches on the table." + System.lineSeparator() + "Player can take 1-3 matches in one turn. Player taking the last match wins!");
        while (run && matches > 0) {
            System.out.println("There are " + matches + " matches on the table.");
            if (count % 2 == 0) {
                player = 2;
            } else {
                player = 1;
            }
            System.out.println("Player " + player + " turn:");
            int turn = Integer.valueOf(input.nextLine());
            if (turn <= 3 && turn >= 1) {
                matches = matches - turn;
                count++;
            }
            if (matches <= 0) {
                run = false;
                System.out.println("The winner is Player " + player + "!");
            }
        }
    }
}
