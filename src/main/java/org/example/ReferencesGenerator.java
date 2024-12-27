package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ReferencesGenerator {

    ReferencesGenerator(){

    }

    public ArrayList<Integer> generateReferencesTotalRandom(int amount, int minValue, int maxValue, int numberOfFrames){
        ArrayList<Integer> data = new ArrayList<>();
        data.add(numberOfFrames);
        Random random = new Random();
        for(int i = 0; i < amount ;i++){
            data.add(random.nextInt((maxValue - minValue) + 1) + minValue);
        }
        return data;
    }

}
