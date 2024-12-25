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
            ArrayList<Process> processes = new ArrayList<>();
            for(int i = 0; i < dataToCPUalgorithm.size() ;i++){
                processes.add(new Process(i,dataToCPUalgorithm.get(i).get(0),dataToCPUalgorithm.get(i).get(1)));
            }
            fcfSalgorithm = new FCFSalgorithm();
            sjFalgorithm = new SJFalgorithm();
            for(Process process : processes){
                fcfSalgorithm.addProcess(process);
                sjFalgorithm.addProcess(process);
            }
            fcfSalgorithm.performAlgorithm();
            sjFalgorithm.performAlgorithm();
        }
        else if(type.equals("RAM")){
            int numberOfFrames = 0;
            int[] referencesSequence = new int[dataToRAMalgorithm.size()-1];
            for(int i = 0; i < dataToRAMalgorithm.size() ;i++){
                if(i == 0){
                    numberOfFrames = dataToRAMalgorithm.get(i);
                    continue;
                }
                referencesSequence[i-1] = dataToRAMalgorithm.get(i);
            }
            fifOalgorithm = new FIFOalgorithm(numberOfFrames, referencesSequence);
            lrUalgorithm = new LRUalgorithm(numberOfFrames, referencesSequence);
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
