package org.example;

import java.util.ArrayList;

public class FCFSalgorithm extends CPUalgorithm {

    FCFSalgorithm() {
        super();
        this.name = "FCFS";
    }

    public void performAlgorithm() {
        while (true) {
            ArrayList<Process> availableProcesses = new ArrayList<>();
            for (Process process : processes) {
                if (!process.getIsDone() && process.getAt() <= timePassed) {
                    availableProcesses.add(process);
                }
            }

            if (availableProcesses.isEmpty()) {
                Process nextArrival = null;
                for (Process process : processes) {
                    if (!process.getIsDone()) {
                        if (nextArrival == null || process.getAt() < nextArrival.getAt()) {
                            nextArrival = process;
                        }
                    }
                }

                if (nextArrival == null) {
                    break;
                }

                timePassed = nextArrival.getAt();
                continue;
            }

            availableProcesses.sort((p1, p2) -> Integer.compare(p1.getAt(), p2.getAt()));

            Process nextProcess = availableProcesses.get(0);
            processingOrder.add(nextProcess);

            nextProcess.setCt(timePassed + nextProcess.getBt());
            nextProcess.setTat(nextProcess.getCt() - nextProcess.getAt());
            nextProcess.setWt(nextProcess.getTat() - nextProcess.getBt());
            nextProcess.setIsDoneToTrue();
            timePassed = nextProcess.getCt();
        }

        setMeanTat();
        setMeanWt();
    }
}