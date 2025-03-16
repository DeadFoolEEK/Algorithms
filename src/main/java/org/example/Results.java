package org.example;

import java.util.ArrayList;

public class Results{

    private FCFSalgorithm fcfsAlgorithm;
    private SJFalgorithmNonPreemptive sjfAlgorithmNonPreemptive;
    private SJFalgorithmPreemptive sjfAlgorithmPreemptive;
    private FIFOalgorithm fifoAlgorithm;
    private LRUalgorithm lruAlgorithm;
    private String type;
    private int framesAmount;

    Results(String type, ArrayList<ArrayList<Integer>> dataToCPUalgorithm, ArrayList<Integer> dataToRAMalgorithm){
        this.type = type;
        if(type.equals("CPU")){

            if (dataToCPUalgorithm.size() != 2 || dataToCPUalgorithm.get(0).size() != dataToCPUalgorithm.get(1).size()) {
                throw new IllegalArgumentException("Arrival times and burst times must have the same size.");
            }

            if (dataToCPUalgorithm.get(0).isEmpty() || dataToCPUalgorithm.get(1).isEmpty()) {
                throw new IllegalArgumentException("Arrival times or burst times cannot be empty.");
            }

            ArrayList<Process> processes = new ArrayList<>();
            for (int i = 0; i < dataToCPUalgorithm.get(0).size(); i++) {
                int arrivalTime = dataToCPUalgorithm.get(0).get(i);
                int burstTime = dataToCPUalgorithm.get(1).get(i);
                processes.add(new Process(i, arrivalTime, burstTime));
            }

            fcfsAlgorithm = new FCFSalgorithm();
            sjfAlgorithmNonPreemptive = new SJFalgorithmNonPreemptive();
            sjfAlgorithmPreemptive = new SJFalgorithmPreemptive();

            for (Process process : processes) {
                fcfsAlgorithm.addProcess(new Process(process.getPid(), process.getAt(), process.getBt()));
                sjfAlgorithmNonPreemptive.addProcess(new Process(process.getPid(), process.getAt(), process.getBt()));
                sjfAlgorithmPreemptive.addProcess(new Process(process.getPid(), process.getAt(), process.getBt()));
            }

            fcfsAlgorithm.performAlgorithm();
            sjfAlgorithmNonPreemptive.performAlgorithm();
            sjfAlgorithmPreemptive.performAlgorithm();

        }
        else if(type.equals("RAM")){
            int[] referencesSequence = new int[dataToRAMalgorithm.size()-1];
            int[] referencesSequence1 = new int[dataToRAMalgorithm.size()-1];
            for(int i = 0; i < dataToRAMalgorithm.size() ;i++){
                if(i == 0){
                    framesAmount = dataToRAMalgorithm.get(i);
                    continue;
                }
                referencesSequence[i-1] = dataToRAMalgorithm.get(i);
                referencesSequence1[i-1] = dataToRAMalgorithm.get(i);
            }
            fifoAlgorithm = new FIFOalgorithm(framesAmount, referencesSequence);
            lruAlgorithm = new LRUalgorithm(framesAmount, referencesSequence1);
            fifoAlgorithm.performAlgorithm();
            lruAlgorithm.performAlgorithm();
        }
    }

    public int getFramesAmount(){
        return framesAmount;
    }

    public FCFSalgorithm getFcfsAlgorithm(){
        return fcfsAlgorithm;
    }

    public FIFOalgorithm getFifoAlgorithm(){
        return fifoAlgorithm;
    }

    public LRUalgorithm getLruAlgorithm(){
        return lruAlgorithm;
    }

    public SJFalgorithmNonPreemptive getSJFalgorithmNonPreemptive(){
        return sjfAlgorithmNonPreemptive;
    }

    public SJFalgorithmPreemptive getSJFalgorithmPreemptive(){
        return sjfAlgorithmPreemptive;
    }

}
