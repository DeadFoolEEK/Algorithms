package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperator {

    private ArrayList<ArrayList<Integer>> dataToCPUalgorithm;
    private ArrayList<Integer> dataToRAMalgorithm;

    FileOperator(){

    }

    private void readDataFromFileCPUalgorithm(String fileName){
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            int pidId = 0;
            boolean readingData = false;
            dataToCPUalgorithm = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.equals("START")){
                    readingData = true;
                }
                else if(data.equals("STOP")){
                    break;
                }

                if(readingData && !data.equals("START")){
                    ArrayList<Integer> dataCPU = new ArrayList<>();
                    dataCPU.add(pidId);
                    String[] numbersStr = data.split("\\W+");
                    for(String str : numbersStr){
                        if (!str.isEmpty()) {
                            dataCPU.add(Integer.parseInt(str));
                        }
                    }
                    dataToCPUalgorithm.add(dataCPU);
                    pidId++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void readDataFromFileRAMalgorithm(String fileName){
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            boolean readingData = false;
            boolean numberOfPagesIsRead = false;
            dataToRAMalgorithm = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.equals("START")){
                    readingData = true;
                }
                else if(data.equals("STOP")){
                    break;
                }

                if(readingData && !numberOfPagesIsRead && !data.equals("START")){
                    int numberOfPages = Integer.parseInt(data);
                    dataToRAMalgorithm.add(numberOfPages);
                    numberOfPagesIsRead = true;
                    continue;
                }

                if(readingData && !data.equals("START")){
                    String[] numbersStr = data.split("\\W+");
                    for(String str : numbersStr){
                        if (!str.isEmpty()) {
                            dataToRAMalgorithm.add(Integer.parseInt(str));
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<Integer>> getDataToCPUalgorithm(String fileName){
        readDataFromFileCPUalgorithm(fileName);
        return dataToCPUalgorithm;
    }

    public ArrayList<Integer> getDataToRAMalgorithm(String fileName){
        readDataFromFileRAMalgorithm(fileName);
        return dataToRAMalgorithm;
    }

}