package com.company;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Number_1 {

    public static void main(String[] args){
        Timer timer = new Timer();
        int numberOfRuns = 10;
        long intervalInMillis = 5000;

        ProcessBuilder procBuilder = new ProcessBuilder("notepad.exe", "C:\\Users\\Paguro\\Downloads\\adsdsa.txt");
        procBuilder.redirectErrorStream(true);

        for (int i = 0; i < numberOfRuns; i++) {
            int currentRun = i + 1;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Выполнение процесса " + currentRun);
                    try {
                        Process process = procBuilder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, i * intervalInMillis);
        }}
}
