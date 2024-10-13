package org.example;

public class Main {

    public static void main(String[] args) {
       testFCFS();
    }

    public static void testFCFS(){
        Process process1 = new Process(1,0,4);
        Process process2 = new Process(2,1,3);
        Process process3 = new Process(3,2,1);
        Process process4 = new Process(4,3,2);
        Process process5 = new Process(5,4,5);

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

}