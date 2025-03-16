package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOperator {

    private ArrayList<ArrayList<Integer>> dataToCPUalgorithm;
    private ArrayList<Integer> dataToRAMalgorithm;
    private File chosenFile;
    private boolean everythingOk;

    FileOperator(){
        everythingOk = false;
        dataToCPUalgorithm = new ArrayList<>();
        dataToRAMalgorithm = new ArrayList<>();
    }

    private void readDataFromFileCPUalgorithm(String fileName){
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            int pidId = 0;
            boolean readingData = false;
            //dataToCPUalgorithm = new ArrayList<>();
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

    private void readDataFromFileCPUalgorithm(File file) {
        try {
            Scanner myReader = new Scanner(file);
            boolean readingData = false;
            dataToCPUalgorithm = new ArrayList<>();
            dataToCPUalgorithm.add(new ArrayList<>()); // Arrival times
            dataToCPUalgorithm.add(new ArrayList<>()); // Burst times

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();

                if (data.equals("START")) {
                    readingData = true;
                    continue;
                } else if (data.equals("STOP")) {
                    break;
                }

                if (readingData) {
                    String[] numbersStr = data.split("\\W+");
                    if (numbersStr.length != 2) {
                        System.out.println("Invalid line format: " + data);
                        continue;
                    }

                    int arrivalTime = Integer.parseInt(numbersStr[0]);
                    int burstTime = Integer.parseInt(numbersStr[1]);

                    dataToCPUalgorithm.get(0).add(arrivalTime);
                    dataToCPUalgorithm.get(1).add(burstTime);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numbers.");
            e.printStackTrace();
        }
    }

    private void readDataFromFileRAMalgorithm(String fileName){
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            boolean readingData = false;
            boolean numberOfPagesIsRead = false;
            //dataToRAMalgorithm = new ArrayList<>();
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

    private void readDataFromFileRAMalgorithm(File file){
        try {
            Scanner myReader = new Scanner(file);
            boolean readingData = false;
            boolean numberOfPagesIsRead = false;
            //dataToRAMalgorithm = new ArrayList<>();
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

    private boolean checkIfFileIsTxt(String filePath){
        if(filePath.substring(filePath.length()-4).equals(".txt")){
            return true;
        }
        return false;
    }

    public void getFileByFileChooser(){
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = j.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION){
            if(checkIfFileIsTxt(j.getSelectedFile().getAbsolutePath())){
                chosenFile = new File(j.getSelectedFile().getAbsolutePath());
                everythingOk = true;
            }
        }
    }

    public String getFileName(){
        String result = "";
        int index = chosenFile.getAbsolutePath().lastIndexOf('\\');
        if (index != -1) {
            result = chosenFile.getAbsolutePath().substring(index+1);
        }
        return result;
    }

    public void saveCPUresults(ArrayList<Process> processes, double[] meanWt, double[] meanTat){
        Path path = Paths.get("zapis.txt");
        String[] data = new String[processes.size()+4];
        data[0] =  String.valueOf(meanWt[0]) + " " + String.valueOf(meanWt[1] + " " + String.valueOf(meanWt[2]));
        data[1] =  String.valueOf(meanTat[0]) + " " + String.valueOf(meanTat[1]) + " " + String.valueOf(meanTat[2]);
        data[2] = "START";
        int i = 3;
        for(Process process : processes){
            data[i] = String.valueOf(process.getAt()) + " " + String.valueOf(process.getBt());
            i++;
        }
        data[i] = "STOP";
        List<String> dataToSave = List.of(data);
        try {
            Files.write(path, dataToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveRAMresults(int[] referencesSequence, int[] totalPageFaults, int[] totalHits, int framesAmount){
        Path path = Paths.get("zapis.txt");
        String[] data = new String[5];
        data[0] = (double)totalHits[0]/referencesSequence.length + " " + (double)totalHits[1]/referencesSequence.length;
        data[1] = "START";
        data[2] = String.valueOf(framesAmount);

        StringBuilder dataBuilder = new StringBuilder();
        for (int reference : referencesSequence) {
            dataBuilder.append(reference).append(" ");
        }
        data[3] = dataBuilder.toString().trim();
        data[4] = "STOP";
        List<String> dataToSave = Arrays.asList(data);

        try {
            Files.write(path, dataToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveCPUresultsSeries(ArrayList<ArrayList<Process>> processes, double[] meanWt, double[] meanTat){
        Path path = Paths.get("zapis.txt");
        String[] data = new String[processes.size()*processes.get(0).size()+2+processes.size()];
        data[0] =  String.valueOf(meanWt[0]) + " " + String.valueOf(meanWt[1]) + " " + String.valueOf(meanWt[2]);
        data[1] =  String.valueOf(meanTat[0]) + " " + String.valueOf(meanTat[1] + " " + String.valueOf(meanTat[2]));
        int line = 2;
        for(int i = 0; i < processes.size(); i++){
            data[line] = "";
            line++;
            for(int j = 0; j < processes.get(i).size(); j++){
                StringBuilder dataBuilder = new StringBuilder(String.valueOf(processes.get(i).get(j).getAt()) + " " + String.valueOf(processes.get(i).get(j).getBt()));
                data[line] = dataBuilder.toString();
                line++;
            }
        }
        List<String> dataToSave = List.of(data);
        try {
            Files.write(path, dataToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveRAMresultsSeries(ArrayList<ArrayList<Integer>> references, double[] hitRates, int framesAmount){
        Path path = Paths.get("zapis.txt");
        String[] data = new String[references.size()+2];
        data[0] = hitRates[0] + " " + hitRates[1];
        data[1] = String.valueOf(framesAmount);
        int line = 2;
        for(int i = 0; i < references.size(); i++){
            StringBuilder dataBuilder = new StringBuilder();
            for(int j = 0; j < references.get(i).size(); j++){
                dataBuilder.append(references.get(i).get(j)).append(" ");
            }
            data[line] = dataBuilder.toString();
            line++;
        }
        List<String> dataToSave = List.of(data);
        try {
            Files.write(path, dataToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getIsEverythingOk(){
        return everythingOk;
    }

    public File getChosenFile(){
        return chosenFile;
    }

    public ArrayList<ArrayList<Integer>> getDataToCPUalgorithm(String fileName){
        readDataFromFileCPUalgorithm(fileName);
        return dataToCPUalgorithm;
    }

    public ArrayList<ArrayList<Integer>> getDataToCPUalgorithm(File file){
        readDataFromFileCPUalgorithm(file);
        return dataToCPUalgorithm;
    }

    public ArrayList<Integer> getDataToRAMalgorithm(String fileName){
        readDataFromFileRAMalgorithm(fileName);
        return dataToRAMalgorithm;
    }

    public ArrayList<Integer> getDataToRAMalgorithm(File file){
        readDataFromFileRAMalgorithm(file);
        return dataToRAMalgorithm;
    }

}