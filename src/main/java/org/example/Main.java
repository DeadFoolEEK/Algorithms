package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
       //testFCFS();
       //testSJF();
       //testFIFO();
       //testLRU();
        // dataReadTestCPU();
        //dataReadTestRAM();
        new Frame();
        //testProcessesGenerator();
        //testResultsSeriesCPU();
        //testResultsSeriesRAM();
    }

    public static void testResultsSeriesCPU(){
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        ProcessesGenerator processesGenerator = new ProcessesGenerator();

        int n = 10;
        int processesAmount = 5;

        for(int i = 0 ; i < n; i++){
            data.add(processesGenerator.generateArrivalTimeConst(processesAmount));
            data.add(processesGenerator.generateBurstTimeTotalRandom(processesAmount,1,10));
        }

        ResultsSeries resultsSeries = new ResultsSeries("CPU",data, new ArrayList<ArrayList<Integer>>(), 0);

        System.out.println("FCFS");

        System.out.println(resultsSeries.getFCFSwtMeans());
        System.out.println(resultsSeries.getFCFSwtMean());
        System.out.println(resultsSeries.getFCFStatMeans());
        System.out.println(resultsSeries.getFCFStatMean());

        System.out.println("SJF");

        System.out.println(resultsSeries.getSJFnonPreemptiveWtMeans());
        System.out.println(resultsSeries.getSJFnonPreemptiveWtMean());
        System.out.println(resultsSeries.getSJFnonPreemptiveTatMeans());
        System.out.println(resultsSeries.getSJFnonPreemptiveTatMean());

    }

    public static void testResultsSeriesRAM(){
        ReferencesGenerator referencesGenerator = new ReferencesGenerator();
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        int numberOfFrames = 3;
        int n = 10;
        int referencesAmount = 50;

        for(int i = 0; i < n; i++){
            data.add(referencesGenerator.generateReferencesTotalRandom(referencesAmount,0,10,numberOfFrames));
        }

        ResultsSeries resultsSeries = new ResultsSeries("RAM",new ArrayList<ArrayList<Integer>>(), data, numberOfFrames);

        System.out.println("FIFO");

        System.out.println(resultsSeries.getFIFOmeanHitRate());
        System.out.println(Arrays.toString(resultsSeries.getFIFOhitRates()));

        System.out.println("LRU");

        System.out.println(resultsSeries.getLRUmeanHitRate());
        System.out.println(Arrays.toString(resultsSeries.getLRUhitRates()));

    }

    public static void testProcessesGenerator(){
        ProcessesGenerator generator = new ProcessesGenerator();
        generator.setMean(10.0);
        generator.setStandardDeviation(5.0);

       ArrayList<Integer> burstTimes = generator.generateBurstTime(100, 1,10);

        double sum = 0;

        for (int time : burstTimes) {
            //System.out.println("Burst Time: " + time);
            sum += time;
        }

        double mean = sum/burstTimes.size();

        double sum2 = 0;

        for (int time : burstTimes) {
            sum2 += Math.pow((time-mean),2);
        }

        double sDeviation = Math.sqrt(sum2/burstTimes.size());

        System.out.println("Średnia: " + mean + ", Odchyelenie standardowe: " + sDeviation);

        ArrayList<Integer> at = generator.generateArrivalTimeIncrement(100);

        //ArrayList<Process> processes = new ArrayList<>();

        FCFSalgorithm fcs = new FCFSalgorithm();

        for(int i = 0; i < 100; i++){
            fcs.addProcess(new Process(i,at.get(i),burstTimes.get(i)));
        }

        fcs.performAlgorithm();
        fcs.getFullProcessesData();
        System.out.println("Time passed: " + fcs.getTimePassed());
        System.out.println("Mean Tat: " + fcs.getMeanTat());
        System.out.println("Mean Wt: " + fcs.getMeanWt());

    }

    public static void testFCFS(){
        Process process1 = new Process(1,0,21);
        Process process2 = new Process(2,0,3);
        Process process3 = new Process(3,0,6);
        Process process4 = new Process(4,0,2);

        FCFSalgorithm fcs = new FCFSalgorithm();

        fcs.addProcess(process1);
        fcs.addProcess(process2);
        fcs.addProcess(process3);
        fcs.addProcess(process4);

        fcs.performAlgorithm();
        fcs.getFullProcessesData();
        System.out.println("Time passed: " + fcs.getTimePassed());
        System.out.println("Mean Tat: " + fcs.getMeanTat());
        System.out.println("Mean Wt: " + fcs.getMeanWt());
    }

    public static void testSJF(){
        Process process1 = new Process(1,2,6);
        Process process2 = new Process(2,5,2);
        Process process3 = new Process(3,1,8);
        Process process4 = new Process(4,0,3);
        Process process5 = new Process(5,4,4);

        SJFalgorithmNonPreemptive sjf = new SJFalgorithmNonPreemptive();

        sjf.addProcess(process1);
        sjf.addProcess(process2);
        sjf.addProcess(process3);
        sjf.addProcess(process4);
        sjf.addProcess(process5);

        sjf.performAlgorithm();
        sjf.getFullProcessesData();
        System.out.println("Time passed: " + sjf.getTimePassed());
        System.out.println("Mean Tat: " + sjf.getMeanTat());
        System.out.println("Mean Wt: " + sjf.getMeanWt());
    }

    public static void testFIFO(){
        int[] pages = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int numberOfFrames = 3;
        FIFOalgorithm fifo = new FIFOalgorithm(numberOfFrames,pages);
        fifo.performAlgorithm();
        System.out.println("Page Faults: " + fifo.getTotalPageFaults());
        System.out.println("Hits: " + fifo.getTotalHits());
        System.out.println("Hir rate: " + fifo.getHitRate() * 100);
    }

    public static void testLRU(){
        int[] pages = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int numberOfFrames = 3;
        LRUalgorithm lru = new LRUalgorithm(numberOfFrames,pages);
        lru.performAlgorithm();
        System.out.println("Page Faults: " + lru.getTotalPageFaults());
        System.out.println("Hits: " + lru.getTotalHits());
        System.out.println("Hit rate: " + lru.getHitRate() * 100);
    }

    public static void dataReadTestCPU(){
        FileOperator fileOperator = new FileOperator();
        System.out.println(fileOperator.getDataToCPUalgorithm("daneCPU.txt"));
    }

    public static void dataReadTestRAM(){
        FileOperator fileOperator = new FileOperator();
        System.out.println(fileOperator.getDataToRAMalgorithm("daneRAM.txt"));
    }

}