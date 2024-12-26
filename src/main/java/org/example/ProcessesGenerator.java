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

    public ArrayList<Integer> generateBurstTime(int amount, int minValue, int maxValue) {
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
        ArrayList<Integer> data = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            int value;
            do {
                value = (int) Math.round(mean + standardDeviation * random.nextGaussian());
            } while (value < minValue || value > maxValue);

            data.add(value);
        }

        return data;
    }

    public ArrayList<Integer> generateBurstTimeTotalRandom(int amount, int minValue, int maxValue){
        ArrayList<Integer> data = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < amount ;i++){
            data.add(random.nextInt((maxValue - minValue) + 1) + minValue);
        }
        return data;
    }

    public ArrayList<Integer> generateArrivalTimeIncrement(int amount){
        ArrayList<Integer> data = new ArrayList<>();
        for(int i = 0; i < amount ;i++){
            data.add(i);
        }
        return data;
    }

    public ArrayList<Integer> generateArrivalTimeTotalRandom(int amount, int minValue, int maxValue){
        ArrayList<Integer> data = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < amount ;i++){
            data.add(random.nextInt((maxValue - minValue) + 1) + minValue);
        }
        return data;
    }

    public ArrayList<Integer> generateArrivalTimeConst(int amount){
        ArrayList<Integer> data = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            data.add(0);
        }
        return data;
    }

    public void setMean(double mean){
        this.mean = mean;
    }

    public void setStandardDeviation(double standardDeviation){
        this.standardDeviation = standardDeviation;
    }

}
