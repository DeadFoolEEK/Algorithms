package org.example;

import java.util.Arrays;

public class LRUalgorithm extends RAMalgorithm{

    private int[] age;

    LRUalgorithm(int numberOfFrames, int[] referencesSequence){
        super(numberOfFrames, referencesSequence);
        fillAge();
        this.name = "LRU";
    }

    private void fillAge(){
        age = new int[numberOfFrames];
        Arrays.fill(age, Integer.MAX_VALUE);
    }

    public void performAlgorithm() {
        for (int i = 0; i < referencesSequence.length; i++) {
            boolean isAlreadyInMemory = false;
            for (int j = 0; j < numberOfFrames; j++) {
                if (memory[j] == referencesSequence[i]) {
                    isAlreadyInMemory = true;
                    totalHits++;
                    updateAge(j);
                    break;
                }
            }
            if (!isAlreadyInMemory) {
                int oldestIndex = findTheOldestIndex();
                memory[oldestIndex] = referencesSequence[i];
                incrementAllAges();
                age[oldestIndex] = 0;
                totalPageFaults++;
            }
        }
        computeHitRate();
    }

    private int findTheOldestIndex() {
        int oldestIndex = 0;
        for (int i = 1; i < age.length; i++) {
            if (age[i] > age[oldestIndex]) {
                oldestIndex = i;
            }
        }
        return oldestIndex;
    }

    private void incrementAllAges() {
        for (int i = 0; i < age.length; i++) {
            if (age[i] != Integer.MAX_VALUE) {
                age[i]++;
            }
        }
    }

    private void updateAge(int index){
        age[index] = 0;
    }

}