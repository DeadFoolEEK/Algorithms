package org.example;

public class Process {

    //process id
    private int pid;
    // waiting time
    private int wt;
    //arrival time
    private int at;
    // turn around time
    private int tat;
    // burst time
    private int bt;
    // completion time
    private int ct;

    Process(int pid, int at, int bt){
        this.pid = pid;
        this.at = at;
        this.bt = bt;
    }

    public int getPid(){
        return pid;
    }

    public int getAt(){
        return at;
    }

    public int getCt(){
        return ct;
    }

    public void setCt(int n){
        ct = n;
    }

    public int getBt(){
        return bt;
    }

    public void setWt(int n){
        wt = n;
    }

    public int getWt(){
        return wt;
    }

    public void setBt(int n){
        bt = n;
    }

    public void setTat(int n){
        tat = n;
    }

    public int getTat(){
        return tat;
    }

}