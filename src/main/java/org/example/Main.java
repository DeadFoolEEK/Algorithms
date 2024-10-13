package org.example;

public class Main {

    public static void main(String[] args) {
       //testFCFS();
       //testSJF();
       //testFIFO();
       //testLRU();
    }

    public static void testFCFS(){
        Process process1 = new Process(1,2,6);
        Process process2 = new Process(2,5,2);
        Process process3 = new Process(3,1,8);
        Process process4 = new Process(4,0,3);
        Process process5 = new Process(5,4,4);

        FCFSalgorithm fcs = new FCFSalgorithm();

        fcs.addProcess(process1);
        fcs.addProcess(process2);
        fcs.addProcess(process3);
        fcs.addProcess(process4);
        fcs.addProcess(process5);

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

        SJFalgorithm sjf = new SJFalgorithm();

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

}