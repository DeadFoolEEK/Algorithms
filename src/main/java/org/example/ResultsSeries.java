package org.example;

import java.util.ArrayList;

public class ResultsSeries {

    private String type;
    private ArrayList<FCFSalgorithm> fcfsAlgorithms;
    private ArrayList<SJFalgorithmNonPreemptive> sjfAlgorithmNonPreemptives;
    private ArrayList<SJFalgorithmPreemptive> sjfAlgorithmPreemptives;
    private ArrayList<FIFOalgorithm> fifoAlgorithms;
    private ArrayList<LRUalgorithm> lruAlgorithms;
    private int referencesAmount;
    private int framesAmount;
    private int processesAmount;
    private ArrayList<ArrayList<Process>> processesToSave;
    private ArrayList<ArrayList<Integer>> referencesToSave;

    ResultsSeries(String type, ArrayList<ArrayList<Integer>> dataToCPUalgorithm, ArrayList<ArrayList<Integer>> dataToRAMalgorithm, int framesAmount){
        if(type.equals("CPU")){
            cpu(dataToCPUalgorithm);
            this.processesAmount = dataToCPUalgorithm.get(0).size();
        }
        else{
            ram(dataToRAMalgorithm, framesAmount);
            this.framesAmount = framesAmount;
            this.referencesAmount = dataToRAMalgorithm.get(0).size() - 1;
        }
    }

    private void cpu(ArrayList<ArrayList<Integer>> dataToCPUalgorithm){
        fcfsAlgorithms = new ArrayList<>();
        sjfAlgorithmNonPreemptives = new ArrayList<>();
        sjfAlgorithmPreemptives = new ArrayList<>();

        ArrayList<ArrayList<Process>> processes = new ArrayList<>();

        for(int i = 0; i < dataToCPUalgorithm.size(); i += 2){
            ArrayList<Process> processes1 = new ArrayList<>();
            for(int j = 0; j < dataToCPUalgorithm.get(i).size(); j++){
                processes1.add(new Process(j,dataToCPUalgorithm.get(i).get(j),dataToCPUalgorithm.get(i+1).get(j)));
            }
            processes.add(processes1);
        }

        processesToSave = processes;

        for (ArrayList<Process> process : processes) {
            FCFSalgorithm fcfSalgorithm = new FCFSalgorithm();
            SJFalgorithmNonPreemptive sjFalgorithmNonPreemptive = new SJFalgorithmNonPreemptive();
            SJFalgorithmPreemptive sjFalgorithmPreemptive = new SJFalgorithmPreemptive();
            for (int j = 0; j < process.size(); j++) {
                fcfSalgorithm.addProcess(new Process(j, process.get(j).getAt(), process.get(j).getBt()));
                sjFalgorithmNonPreemptive.addProcess(new Process(j, process.get(j).getAt(), process.get(j).getBt()));
                sjFalgorithmPreemptive.addProcess(new Process(j, process.get(j).getAt(), process.get(j).getBt()));
            }
            fcfsAlgorithms.add(fcfSalgorithm);
            sjfAlgorithmNonPreemptives.add(sjFalgorithmNonPreemptive);
            sjfAlgorithmPreemptives.add(sjFalgorithmPreemptive);
        }

        for(int i = 0; i < fcfsAlgorithms.size(); i++){
            fcfsAlgorithms.get(i).performAlgorithm();
            sjfAlgorithmNonPreemptives.get(i).performAlgorithm();
            sjfAlgorithmPreemptives.get(i).performAlgorithm();
        }

    }

    public double getFCFSwtMean(){
        int n = fcfsAlgorithms.size();
        double sum = 0;
        for(FCFSalgorithm fcfSalgorithm : fcfsAlgorithms){
            sum += fcfSalgorithm.getMeanWt();
        }
        return sum/n;
    }

    public double getFCFStatMean(){
        int n = fcfsAlgorithms.size();
        double sum = 0;
        for(FCFSalgorithm fcfSalgorithm : fcfsAlgorithms){
            sum += fcfSalgorithm.getMeanTat();
        }
        return sum/n;
    }

    public ArrayList<Double> getFCFSwtMeans(){
        ArrayList<Double> wtMeans = new ArrayList<>();
        for(FCFSalgorithm fcfSalgorithm : fcfsAlgorithms){
            wtMeans.add(fcfSalgorithm.getMeanWt());
        }
        return wtMeans;
    }

    public ArrayList<Double> getFCFStatMeans(){
        ArrayList<Double> tatMeans = new ArrayList<>();
        for(FCFSalgorithm fcfSalgorithm : fcfsAlgorithms){
            tatMeans.add(fcfSalgorithm.getMeanTat());
        }
        return tatMeans;
    }

    public double getSJFnonPreemptiveWtMean(){
        int n = sjfAlgorithmNonPreemptives.size();
        double sum = 0;
        for(SJFalgorithmNonPreemptive sjFalgorithmNonPreemptive : sjfAlgorithmNonPreemptives){
            sum += sjFalgorithmNonPreemptive.getMeanWt();
        }
        return sum/n;
    }

    public double getSJFnonPreemptiveTatMean(){
        int n = sjfAlgorithmNonPreemptives.size();
        double sum = 0;
        for(SJFalgorithmNonPreemptive sjFalgorithmNonPreemptive : sjfAlgorithmNonPreemptives){
            sum += sjFalgorithmNonPreemptive.getMeanTat();
        }
        return sum/n;
    }

    public ArrayList<Double> getSJFnonPreemptiveWtMeans(){
        ArrayList<Double> wtMeans = new ArrayList<>();
        for(SJFalgorithmNonPreemptive sjFalgorithmNonPreemptive : sjfAlgorithmNonPreemptives){
            wtMeans.add(sjFalgorithmNonPreemptive.getMeanWt());
        }
        return wtMeans;
    }

    public ArrayList<Double> getSJFnonPreemptiveTatMeans(){
        ArrayList<Double> tatMeans = new ArrayList<>();
        for(SJFalgorithmNonPreemptive sjFalgorithmNonPreemptive : sjfAlgorithmNonPreemptives){
            tatMeans.add(sjFalgorithmNonPreemptive.getMeanTat());
        }
        return tatMeans;
    }

    public double getSJFpreemptiveWtMean(){
        int n = sjfAlgorithmPreemptives.size();
        double sum = 0;
        for(SJFalgorithmPreemptive sjFalgorithmPreemptive : sjfAlgorithmPreemptives){
            sum += sjFalgorithmPreemptive.getMeanWt();
        }
        return sum/n;
    }

    public double getSJFpreemptiveTatMean(){
        int n = sjfAlgorithmPreemptives.size();
        double sum = 0;
        for(SJFalgorithmPreemptive sjFalgorithmPreemptive : sjfAlgorithmPreemptives){
            sum += sjFalgorithmPreemptive.getMeanTat();
        }
        return sum/n;
    }

    public ArrayList<Double> getSJFpreemptiveWtMeans(){
        ArrayList<Double> wtMeans = new ArrayList<>();
        for(SJFalgorithmPreemptive sjFalgorithmPreemptive : sjfAlgorithmPreemptives){
            wtMeans.add(sjFalgorithmPreemptive.getMeanWt());
        }
        return wtMeans;
    }

    public ArrayList<Double> getSJFpreemptiveTatMeans(){
        ArrayList<Double> tatMeans = new ArrayList<>();
        for(SJFalgorithmPreemptive sjFalgorithmPreemptive : sjfAlgorithmPreemptives){
            tatMeans.add(sjFalgorithmPreemptive.getMeanTat());
        }
        return tatMeans;
    }

    private void ram(ArrayList<ArrayList<Integer>> dataToRAMalgorithm, int framesAmount){
        referencesToSave = dataToRAMalgorithm;
        fifoAlgorithms = new ArrayList<>();
        lruAlgorithms = new ArrayList<>();

        for(ArrayList<Integer> integers : dataToRAMalgorithm){
            int[] references = new int[integers.size()];
            int[] references1 = new int[integers.size()];
            for (int j = 0; j < integers.size(); j++) {
                references[j] = integers.get(j);
                references1[j] = integers.get(j);
            }
            fifoAlgorithms.add(new FIFOalgorithm(framesAmount, references));
            lruAlgorithms.add(new LRUalgorithm(framesAmount, references1));
        }

        for(int i = 0; i < fifoAlgorithms.size(); i++){
            fifoAlgorithms.get(i).performAlgorithm();
            lruAlgorithms.get(i).performAlgorithm();
        }

    }

    public double getFIFOmeanHitRate(){
        double sum = 0;
        for(FIFOalgorithm fifOalgorithm : fifoAlgorithms){
            sum += fifOalgorithm.getHitRate();
        }
        return sum/ fifoAlgorithms.size();
    }
    
    public double[] getFIFOhitRates(){
        double[] hitRates = new double[fifoAlgorithms.size()];
        for(int i = 0; i < fifoAlgorithms.size(); i++){
            hitRates[i] = fifoAlgorithms.get(i).getHitRate();
        }
        return hitRates;
    }
    
    public double getLRUmeanHitRate(){
        double sum = 0;
        for (LRUalgorithm lrUalgorithm : lruAlgorithms) {
            sum += lrUalgorithm.getHitRate();
        }
        return sum/ fifoAlgorithms.size();
    }

    public double[] getLRUhitRates(){
        double[] hitRates = new double[lruAlgorithms.size()];
        for(int i = 0; i < lruAlgorithms.size(); i++){
            hitRates[i] = lruAlgorithms.get(i).getHitRate();
        }
        return hitRates;
    }

    public int getReferencesAmount(){
        return referencesAmount;
    }

    public int getFramesAmount(){
        return framesAmount;
    }

    public int getProcessesAmount(){
        return processesAmount;
    }

    public ArrayList<ArrayList<Process>> getProcessesToSave(){
        return processesToSave;
    }

    public ArrayList<ArrayList<Integer>> getReferencesToSave(){
        return referencesToSave;
    }

}
