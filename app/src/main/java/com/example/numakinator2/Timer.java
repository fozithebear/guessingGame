package com.example.numakinator2;

import java.util.concurrent.TimeUnit;

public class Timer {
    private static long minutes;

    public Timer() {
    }

    public String start() throws InterruptedException {

        long startTime = System.currentTimeMillis();

        while (true) {
            TimeUnit.SECONDS.sleep(1);
            long timePassed = System.currentTimeMillis() - startTime;
            long seconds = timePassed / 1000;
            if (seconds == 60) {
                seconds = 0;
                startTime = System.currentTimeMillis();
            }
            if ((seconds % 60) == 0) {
                minutes++;
            }
            System.out.println(minutes + ":" + String.format("%02d", seconds));
        }
    }

    public static long getMinutes() {
        return minutes;
    }
}
