package org.example;

import java.util.Arrays;

public abstract class RAMalgorithm {
    //https://os-project-page-replacement.vercel.app
    protected int totalPageFaults;
    protected int totalHits;
    protected double hitRate;
    protected int numberOfFrames;
    protected int[] referencesSequence;
    protected int[] memory;
    protected String name;

    RAMalgorithm(int numberOfFrames, int[] referencesSequence){
        this.numberOfFrames = numberOfFrames;
        this.referencesSequence = referencesSequence;
        memory = new int[numberOfFrames];
        Arrays.fill(memory, -1);
    }

    protected void computeHitRate(){
        hitRate = (double) totalHits / (totalHits + totalPageFaults);
    }

    protected int getTotalPageFaults(){
        return totalPageFaults;
    }

    protected int getTotalHits(){
        return totalHits;
    }

    protected double getHitRate(){
        return hitRate;
    }

    public String getName(){
        return name;
    }

}