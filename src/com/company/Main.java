package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Hello! Welcome to my guessing game! What is your name?");

        String user = input.nextLine();

        System.out.println("what game mode would you like to play " + user + "?");
        System.out.println("1.Guess MY secret number");
        System.out.println("2.Guess YOUR secret number");

        int mode = input.nextInt();

        if (mode == 1) {
            System.out.println("You've selected game mode 1: MY secret number");
        } else {
            System.out.println("You've selected game mode 2: YOUR secret number");
        }

        System.out.println("which difficulty would you like " + user + "?");
        System.out.println("1. Easy (Range 1-10)");
        System.out.println("2. Medium (Range 1-100)");
        System.out.println("3. Hard (Range 1-1000)");
        System.out.println("4. Extreme (range 1-10000)");

        int level = input.nextInt();
        int max = (int) (Math.pow(10, level));
        int game = (int) (Math.random() * max + 1);
        String guesses = "here are your past guesses: ";
        String guesses2 = "here are my past guesses: ";
        if (mode == 1) {
            System.out.println("Guess my secret number: ");
            int guess = input.nextInt();

            while (guess != game) {

                if (guess < game) {
                    System.out.println("Too low " + user);
                    guesses = guesses + guess + ",";

                } else if (guess > game) {
                    System.out.println("Too high " + user);
                    guesses = guesses + guess + ",";
                }
                System.out.print("Guess again " + user + ": ");
                guess = input.nextInt();
            }
            System.out.println("Correct! " + user + " the secret number was " + guess + "!");
            System.out.println(guesses);
        } else {
            System.out.println("Pick a secret number between 1 and " + max + "(Please respond correct, higher, or lower)");
            System.out.println("is your number " + game);
            String answer = input.nextLine();
            String right = "correct";
            String high = "higher";
            String low = "lower";
            while (!answer.equals(right)) {
                if (answer.equals(high)) {
                    max = (int) (Math.random() * max + game);
                    System.out.println("is your number " + max + "?");
                } else if(answer.equals(low)){
                   max = game;
                    System.out.println("is your number " + max + "?");
                }
                answer = input.nextLine();
                System.out.println("is your number " + game + "?");

            }
            System.out.println("Your number is " + game + "!");
            System.out.println(guesses2);
        }
    }
}
