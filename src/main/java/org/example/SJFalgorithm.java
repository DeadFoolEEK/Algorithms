package org.example;

public class SJFalgorithm extends CPUalgorithm {

    SJFalgorithm(){
        super();
    }

    private int getNextArrivalTime(int currentTime) {
        int nextArrival = Integer.MAX_VALUE;
        for (Process process : processes) {
            if (!process.getIsDone() && process.getAt() > currentTime) {
                nextArrival = Math.min(nextArrival, process.getAt());
            }
        }
        return nextArrival == Integer.MAX_VALUE ? currentTime : nextArrival;
    }

    private boolean getIsThisTheEnd() {
        for (Process process : processes) {
            if (!process.getIsDone()) {
                return false;
            }
        }
        return true;
    }

    private Process getProcess(int currentTime) {
        Process chosenProcess = null;
        for (Process process : processes) {
            if (!process.getIsDone() && process.getAt() <= currentTime) {
                if (chosenProcess == null || process.getBt() < chosenProcess.getBt()) {
                    chosenProcess = process;
                }
            }
        }
        return chosenProcess;
    }

    public void performAlgorithm() {
        boolean done = false;
        Process chosenProcess;
        while (!done) {
            chosenProcess = getProcess(timePassed);
            if (chosenProcess != null) {
                chosenProcess.setCt(timePassed + chosenProcess.getBt());
                chosenProcess.setTat(chosenProcess.getCt() - chosenProcess.getAt());
                chosenProcess.setWt(chosenProcess.getTat() - chosenProcess.getBt());
                timePassed += chosenProcess.getBt();
                chosenProcess.setIsDoneToTrue();
                processingOrder.add(chosenProcess);
            }

            else {
                timePassed = getNextArrivalTime(timePassed);
            }
            done = getIsThisTheEnd();
        }
        setMeanTat();
        setMeanWt();
    }

}