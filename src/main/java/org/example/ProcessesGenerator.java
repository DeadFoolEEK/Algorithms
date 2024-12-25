package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ProcessesGenerator {

    private double standardDeviation;
    private double mean;

    ProcessesGenerator(){

    }

    ProcessesGenerator(double mean, double standardDeviation) {
        setMean(mean);
        setStandardDeviation(standardDeviation);
    }

    public int[] generateBurstTime(int amount, int minValue, int maxValue) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Ilość musi być większa od 0");
        }
        if (minValue < 0) {
            throw new IllegalArgumentException("Wartość minimalna musi być większa lub równa 0");
        }
        if (maxValue <= minValue) {
            throw new IllegalArgumentException("Wartość maksymalna musi być większa od wartości minimalnej");
        }

        Random random = new Random();
        int[] data = new int[amount];

        for (int i = 0; i < amount; i++) {
            int value;
            do {
                value = (int) Math.round(mean + standardDeviation * random.nextGaussian());
            } while (value < minValue || value > maxValue);

            data[i] = value;
        }

        return data;
    }

    public int[] generateBurstTimeTotalRandom(int amount, int minValue, int maxValue){
        int[] data = new int[amount];
        Random random = new Random();
        for(int i = 0; i < amount ;i++){
            data[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
        }
        return data;
    }

    public int[] generateArrivalTimeIncrement(int amount){
        int[] data = new int[amount];
        for(int i = 0; i < amount ;i++){
            data[i] = i;
        }
        return data;
    }

    public int[] generateArrivalTimeTotalRandom(int amount, int minValue, int maxValue){
        int[] data = new int[amount];
        Random random = new Random();
        for(int i = 0; i < amount ;i++){
            data[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
        }
        return data;
    }

    public int[] generateArrivalTimeConst(int amount){
        return new int[amount];
    }

    public void setMean(double mean){
        this.mean = mean;
    }

    public void setStandardDeviation(double standardDeviation){
        this.standardDeviation = standardDeviation;
    }

}
