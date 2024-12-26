package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener {

    private Menu menu;
    private FileOperator fileOperator;
    private GetDataPanel getDataPanel;
    private ResultsPanel resultsPanel;
    private CPUalgorithmsRandomizePanel cpUalgorithmsRandomizePanel;
    private RAMalgorithmsRandomizePanel raMalgorithmsRandomizePanel;
    private Results results;
    private String type;
    private ProcessesGenerator processesGenerator;

    Frame(){
        this.setResizable(false);
        this.setSize(1200,700);
        this.setTitle("Algorithms");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fileOperator = new FileOperator();
        menu = new Menu(this);
        getDataPanel = new GetDataPanel(this);
        resultsPanel = new ResultsPanel(this);
        cpUalgorithmsRandomizePanel = new CPUalgorithmsRandomizePanel(this);
        raMalgorithmsRandomizePanel = new RAMalgorithmsRandomizePanel(this);

        this.add(menu.getMainPanel());
        this.add(getDataPanel);
        this.add(resultsPanel);
        this.add(cpUalgorithmsRandomizePanel);
        this.add(raMalgorithmsRandomizePanel);
        this.setVisible(true);
    }

    public Results getResults(){
        return results;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menu.getCpuAlgorithmButton()){
            menu.hideMainPanel();
            getDataPanel.setThisVisible();
            type = "CPU";
        }
        else if(e.getSource() == menu.getRamAlgorithmButton()){
            menu.hideMainPanel();
            getDataPanel.setThisVisible();
            type = "RAM";
        }
        else if(e.getSource() == menu.getExitButton()){
            System.exit(0);
        }
        else if(e.getSource() == getDataPanel.getGoBackButton()){
            getDataPanel.setThisInvisible();
            menu.showMainPanel();
        }
        else if(e.getSource() == getDataPanel.getChooseFileButton()){
           fileOperator.getFileByFileChooser();
           if(fileOperator.getIsEverythingOk()){
               getDataPanel.setChosenFileNameLabelText(fileOperator.getFileName());
               getDataPanel.setGoNextButtonVisible();
           }
           else{
               getDataPanel.setChosenFileNameLabelText("Select file");
               getDataPanel.setGoNextButtonInvisible();
           }
        }
        else if(e.getSource() == getDataPanel.getRandomizedDataButton()){
            if(type.equals("CPU")){
                getDataPanel.setThisInvisible();
                cpUalgorithmsRandomizePanel.setThisVisible();
            }
            else if(type.equals("RAM")){
                getDataPanel.setThisInvisible();
                raMalgorithmsRandomizePanel.setThisVisible();
            }
        }
        else if(e.getSource() == cpUalgorithmsRandomizePanel.getGoBackButton()){
            cpUalgorithmsRandomizePanel.setThisInvisible();
            getDataPanel.setThisVisible();
        }
        else if(e.getSource() == raMalgorithmsRandomizePanel.getGoBackButton()){
            raMalgorithmsRandomizePanel.setThisInvisible();
            getDataPanel.setThisVisible();
        }
        else if(e.getSource() == getDataPanel.getGoNextButton()){
            if(type.equals("CPU")){
                results = new Results(type, fileOperator.getDataToCPUalgorithm(fileOperator.getChosenFile()), new ArrayList<Integer>());
            }
            else if(type.equals("RAM")){
                results = new Results(type, new ArrayList<ArrayList<Integer>>(), fileOperator.getDataToRAMalgorithm(fileOperator.getChosenFile()));
            }
            getDataPanel.setThisInvisible();
            resultsPanel.setThisVisible();
        }
        else if(e.getSource() == cpUalgorithmsRandomizePanel.getStartButton()){
            if(!cpUalgorithmsRandomizePanel.getSelectedBurstOption().equals("None") && !cpUalgorithmsRandomizePanel.getSelectedArrivalOption().equals("None") && cpUalgorithmsRandomizePanel.getAmount() != -1){
                // Process(int pid, int at, int bt)
                int amount = cpUalgorithmsRandomizePanel.getAmount();
                processesGenerator = new ProcessesGenerator();
                ArrayList<ArrayList<Integer>> dataToCPUalgorithm = new ArrayList<>();

                if(cpUalgorithmsRandomizePanel.getSelectedBurstOption().equals("Option 2")){
                    if(cpUalgorithmsRandomizePanel.getMean() != -1 && cpUalgorithmsRandomizePanel.getStandardDeviation() != -1 && cpUalgorithmsRandomizePanel.getGaussMin() != -1 && cpUalgorithmsRandomizePanel.getGaussMax() != -1){
                        processesGenerator.setMean(cpUalgorithmsRandomizePanel.getMean());
                        processesGenerator.setStandardDeviation(cpUalgorithmsRandomizePanel.getStandardDeviation());
                        ArrayList<Integer> bt = processesGenerator.generateBurstTime(amount, cpUalgorithmsRandomizePanel.getGaussMin(), cpUalgorithmsRandomizePanel.getGaussMax());
                        dataToCPUalgorithm.add(bt);
                    }
                }
                else if(cpUalgorithmsRandomizePanel.getSelectedBurstOption().equals("Option 1")){
                    if(cpUalgorithmsRandomizePanel.getBurstRandomMin() != -1 && cpUalgorithmsRandomizePanel.getBurstRandomMax() != -1){
                        ArrayList<Integer> bt = processesGenerator.generateBurstTimeTotalRandom(amount, cpUalgorithmsRandomizePanel.getBurstRandomMin(), cpUalgorithmsRandomizePanel.getBurstRandomMax());
                        dataToCPUalgorithm.add(bt);
                    }
                }

                if(cpUalgorithmsRandomizePanel.getSelectedArrivalOption().equals("Option 1")){
                    ArrayList<Integer> at = processesGenerator.generateArrivalTimeIncrement(amount);
                    dataToCPUalgorithm.add(at);
                }
                else if(cpUalgorithmsRandomizePanel.getSelectedArrivalOption().equals("Option 2")){
                    ArrayList<Integer> at = processesGenerator.generateArrivalTimeTotalRandom(amount, cpUalgorithmsRandomizePanel.getArrivalRandomMin(), cpUalgorithmsRandomizePanel.getArrivalRandomMax());
                    dataToCPUalgorithm.add(at);
                }
                else if(cpUalgorithmsRandomizePanel.getSelectedArrivalOption().equals("Option 3")){
                    ArrayList<Integer> at = processesGenerator.generateArrivalTimeConst(amount);
                    dataToCPUalgorithm.add(at);
                }

                if(dataToCPUalgorithm.size() == 2){
                    results = new Results(type, dataToCPUalgorithm, new ArrayList<Integer>());
                    cpUalgorithmsRandomizePanel.setThisInvisible();
                    resultsPanel.setThisVisible();
                }

            }
        }
        else if(e.getSource() == resultsPanel.getSaveButton()){

        }
        else if(e.getSource() == resultsPanel.getExitButton()){
            System.exit(0);
        }
    }

}