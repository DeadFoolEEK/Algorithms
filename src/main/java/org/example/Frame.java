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
    private Results results;
    private String type;

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

        this.add(menu.getMainPanel());
        this.add(getDataPanel);
        this.add(resultsPanel);
        this.add(cpUalgorithmsRandomizePanel);
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

            }
        }
        else if(e.getSource() == cpUalgorithmsRandomizePanel.getGoBackButton()){
            cpUalgorithmsRandomizePanel.setThisInvisible();
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
        else if(e.getSource() == resultsPanel.getSaveButton()){

        }
        else if(e.getSource() == resultsPanel.getExitButton()){
            System.exit(0);
        }
    }

}