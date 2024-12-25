package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    private void readDataFromFileCPUalgorithm(File file){
        try {
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