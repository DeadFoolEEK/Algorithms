package org.example;


public class FIFOalgorithm extends RAMalgorithm{

    FIFOalgorithm(int numberOfFrames, int[] referencesSequence){
        super(numberOfFrames, referencesSequence);
        this.name = "FIFO";
    }

    public void performAlgorithm() {
        int lastAddedIndex = 0;

        for (int i = 0; i < referencesSequence.length; i++) {
            boolean isAlreadyInMemory = false;

            for (int j = 0; j < numberOfFrames; j++) {
                if (memory[j] == referencesSequence[i]) {
                    isAlreadyInMemory = true;
                    break;
                }
            }

            if (!isAlreadyInMemory) {
                memory[lastAddedIndex] = referencesSequence[i];
                lastAddedIndex = (lastAddedIndex + 1) % numberOfFrames;
                totalPageFaults++;
            } else {
                totalHits++;
            }
        }

        computeHitRate();
    }

}