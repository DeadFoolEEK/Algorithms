package org.example;

import java.util.ArrayList;

public abstract class CPUalgorithm {

    protected ArrayList<Process> processes;
    protected ArrayList<Process> processingOrder;
    protected int timePassed;
    protected double meanWt;
    protected double meanTat;

    CPUalgorithm(){
        processes = new ArrayList<>();
        processingOrder = new ArrayList<>();
    }

    public void addProcess(Process process){
        processes.add(process);
    }

    public void getFullProcessesData(){
        for(Process process : processes){
            System.out.println("PID: " + process.getPid() + ", Arrival time: " + process.getAt() + ", Burst Time: " + process.getBt() + ", Completion time: " + process.getCt() + ", Turn around time: " + process.getTat() + ", Waiting Time: " + process.getWt());
        }
    }

    public void showPrecessingOrder(){
        for(Process process : processingOrder){
            System.out.println("PD" + process.getPid());
        }
    }

    protected void setMeanWt(){
        int sum = 0;
        for(Process process : processes){
            sum += process.getWt();
        }
        meanWt = (double) sum /processes.size();
    }

    protected void setMeanTat(){
        int sum = 0;
        for(Process process : processes){
            sum += process.getTat();
        }
        meanTat = (double) sum /processes.size();
    }

    public double getMeanWt(){
        return meanWt;
    }

    public double getMeanTat(){return meanTat;}

    public int getTimePassed(){
        return timePassed;
    }

    public ArrayList<Process> getProcessingOrder(){
        return processingOrder;
    }

}
