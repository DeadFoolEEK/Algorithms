package org.example;

public class SJFalgorithmNonPreemptive extends CPUalgorithm {

    SJFalgorithmNonPreemptive() {
        super();
        this.name = "SJF";
    }

    private boolean areAllProcessesDone() {
        for (Process process : processes) {
            if (!process.getIsDone()) {
                return false;
            }
        }
        return true;
    }

    private Process getNextProcess(int currentTime) {
        Process chosenProcess = null;
        for (Process process : processes) {
            if (!process.getIsDone() && process.getAt() <= currentTime) {
                if (chosenProcess == null || process.getBt() < chosenProcess.getBt() || (process.getBt() == chosenProcess.getBt() && process.getPid() < chosenProcess.getPid())) {
                    chosenProcess = process;
                }
            }
        }
        return chosenProcess;
    }

    public void performAlgorithm() {
        while (!areAllProcessesDone()) {
            Process chosenProcess = getNextProcess(timePassed);

            if (chosenProcess != null) {
                chosenProcess.setCt(timePassed + chosenProcess.getBt());
                chosenProcess.setTat(chosenProcess.getCt() - chosenProcess.getAt());
                chosenProcess.setWt(chosenProcess.getTat() - chosenProcess.getBt());
                timePassed += chosenProcess.getBt();
                chosenProcess.setIsDoneToTrue();
                processingOrder.add(chosenProcess);
            } else {
                timePassed++;
            }
        }
        setMeanTat();
        setMeanWt();
    }
}