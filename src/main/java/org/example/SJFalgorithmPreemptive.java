package org.example;

public class SJFalgorithmPreemptive extends CPUalgorithm{

        SJFalgorithmPreemptive(){
            super();
            this.name = "SRTF";
        }

    public void performAlgorithm() {
        int completedProcesses = 0;
        int currentTime = 0;
        Process currentProcess = null;

        // Initialize remaining burst times
        for (Process process : processes) {
            process.setRemainingBt(process.getBt());
        }

        while (completedProcesses < processes.size()) {
            // Find the process with the shortest remaining time that has arrived
            Process nextProcess = null;
            for (Process process : processes) {
                if (process.getAt() <= currentTime && !process.getIsDone()) {
                    if (nextProcess == null || process.getRemainingBt() < nextProcess.getRemainingBt() ||
                            (process.getRemainingBt() == nextProcess.getRemainingBt() && process.getPid() < nextProcess.getPid())) {
                        nextProcess = process;
                    }
                }
            }

            if (nextProcess != null) {
                if (currentProcess != nextProcess) {
                    currentProcess = nextProcess;
                }

                // Process for 1 unit of time
                currentProcess.setRemainingBt(currentProcess.getRemainingBt() - 1);
                currentTime++;

                // Check if the process is completed
                if (currentProcess.getRemainingBt() == 0) {
                    currentProcess.setCt(currentTime);
                    currentProcess.setTat(currentProcess.getCt() - currentProcess.getAt());
                    currentProcess.setWt(currentProcess.getTat() - currentProcess.getBt());
                    currentProcess.setIsDoneToTrue();
                    processingOrder.add(currentProcess);
                    completedProcesses++;
                }
            } else {
                // No process is ready to execute, increment time
                currentTime++;
            }
        }
        timePassed = currentTime;
        setMeanTat();
        setMeanWt();
    }

}
