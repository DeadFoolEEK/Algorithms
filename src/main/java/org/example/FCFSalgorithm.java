package org.example;


public class FCFSalgorithm extends Algorithm {

    FCFSalgorithm(){
        super();
    }

    private void sortProcesses(){
        Process temp;
        boolean swapped;
        for (int i = 0; i < processes.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < processes.size() - i - 1; j++) {
                if (processes.get(j).getAt() > processes.get(j+1).getAt()) {
                    temp = processes.get(j);
                    processes.set(j,processes.get(j+1));
                    processes.set(j+1,temp);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public void performAlgorithm() {
        sortProcesses();
        for (Process process : processes) {
            process.setCt(timePassed + process.getBt());
            process.setTat(process.getCt() - process.getAt());
            process.setWt(process.getTat() - process.getBt());
            timePassed += process.getBt();
        }
        setMeanTat();
        setMeanWt();
    }

}