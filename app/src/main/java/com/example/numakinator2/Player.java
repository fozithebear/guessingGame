package com.example.numakinator2;

import java.util.HashMap;
import java.util.Scanner;

public class Player {
    private String name;
    private int interval;
    private int guesses;

    public Player(String name, int interval, int guesses) {
        this.name = name;
        this.interval = interval + 1;
        this.guesses = guesses;
    }

    public Player(String name) {
        this.name = name;
        this.interval = 101;
        this.guesses = 10;
    }


    public String getName() {
        return name;

    }

    public int getInterval() {
        return interval;
    }

    public int getGuesses() {
        return guesses;
    }

    private int getRandomNumber(){
        return (int) (Math.random() * (interval));
    }

    public void startGame() {
        HashMap<String, Integer> history = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        int num = getRandomNumber();

        String low = "L";
        String high = "H";
        for (int i = 0; i < guesses; i++) {
            int guess = scanner.nextInt();
            if (guess < num) {
                history.put(low, guess);
            } else if (guess > num) {
                history.put(high, guess);
            }

            for (String key : history.keySet()) {
                String values = history.values().toString();
                System.out.println(key + " " + values);
            }
        }
    }
}
