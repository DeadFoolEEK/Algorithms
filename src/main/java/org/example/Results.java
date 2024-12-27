package org.example;

import java.util.ArrayList;

public class Results{

    private FCFSalgorithm fcfSalgorithm;
    private SJFalgorithm sjFalgorithm;
    private FIFOalgorithm fifOalgorithm;
    private LRUalgorithm lrUalgorithm;
    private String type;

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

            fcfSalgorithm = new FCFSalgorithm();
            sjFalgorithm = new SJFalgorithm();

            for (Process process : processes) {
                fcfSalgorithm.addProcess(new Process(process.getPid(), process.getAt(), process.getBt()));
                sjFalgorithm.addProcess(new Process(process.getPid(), process.getAt(), process.getBt()));
            }

            fcfSalgorithm.performAlgorithm();
            sjFalgorithm.performAlgorithm();

        }
        else if(type.equals("RAM")){
            int numberOfFrames = 0;
            int[] referencesSequence = new int[dataToRAMalgorithm.size()-1];
            int[] referencesSequence1 = new int[dataToRAMalgorithm.size()-1];
            for(int i = 0; i < dataToRAMalgorithm.size() ;i++){
                if(i == 0){
                    numberOfFrames = dataToRAMalgorithm.get(i);
                    continue;
                }
                referencesSequence[i-1] = dataToRAMalgorithm.get(i);
                referencesSequence1[i-1] = dataToRAMalgorithm.get(i);
            }
            fifOalgorithm = new FIFOalgorithm(numberOfFrames, referencesSequence);
            lrUalgorithm = new LRUalgorithm(numberOfFrames, referencesSequence1);
            fifOalgorithm.performAlgorithm();
            lrUalgorithm.performAlgorithm();
        }
    }

    public FCFSalgorithm getFcfSalgorithm(){
        return fcfSalgorithm;
    }

    public FIFOalgorithm getFifOalgorithm(){
        return fifOalgorithm;
    }

    public LRUalgorithm getLrUalgorithm(){
        return lrUalgorithm;
    }

    public SJFalgorithm getSjFalgorithm(){
        return sjFalgorithm;
    }

}
