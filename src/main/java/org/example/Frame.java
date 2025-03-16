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
    private ResultsSeriesPanelRAM resultsSeriesPanelRAM;
    private ResultsSeriesPanelCPU resultsSeriesPanelCPU;
    private Results results;
    private ResultsSeries resultsSeries;
    private String type;
    private ProcessesGenerator processesGenerator;
    private ReferencesGenerator referencesGenerator;
    private SeriesRAMchartsPanel seriesRAMchartsPanel;
    private SeriesCPUchartsPanel seriesCPUchartsPanel;

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
        resultsSeriesPanelCPU = new ResultsSeriesPanelCPU(this);
        resultsSeriesPanelRAM = new ResultsSeriesPanelRAM(this);
        seriesRAMchartsPanel = new SeriesRAMchartsPanel(this);
        seriesCPUchartsPanel = new SeriesCPUchartsPanel(this);

        this.add(menu.getMainPanel());
        this.add(getDataPanel);
        this.add(resultsPanel);
        this.add(cpUalgorithmsRandomizePanel);
        this.add(raMalgorithmsRandomizePanel);
        this.add(resultsSeriesPanelRAM);
        this.add(resultsSeriesPanelCPU);
        this.add(seriesRAMchartsPanel);
        this.add(seriesCPUchartsPanel);
        this.setVisible(true);
    }

    public Results getResults(){
        return results;
    }

    public ResultsSeries getResultsSeries(){
        return resultsSeries;
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
                cpUalgorithmsRandomizePanel.setThisInvisible();
                resultsPanel.setType(type);
                resultsPanel.setThisVisible();
            }

            else if(type.equals("RAM")){
                results = new Results(type, new ArrayList<ArrayList<Integer>>(), fileOperator.getDataToRAMalgorithm(fileOperator.getChosenFile()));
                raMalgorithmsRandomizePanel.setThisInvisible();
                resultsPanel.setType(type);
                resultsPanel.setThisVisible();
            }

            getDataPanel.setThisInvisible();
            resultsPanel.setThisVisible();

        }

        else if(e.getSource() == cpUalgorithmsRandomizePanel.getStartButton()){

            if(cpUalgorithmsRandomizePanel.getSelectedSingleSeriesOption().equals("Option 1")){

                if(!cpUalgorithmsRandomizePanel.getSelectedBurstOption().equals("None") && !cpUalgorithmsRandomizePanel.getSelectedArrivalOption().equals("None") && cpUalgorithmsRandomizePanel.getAmount() != -1){

                    int amount = cpUalgorithmsRandomizePanel.getAmount();
                    processesGenerator = new ProcessesGenerator();
                    ArrayList<ArrayList<Integer>> dataToCPUalgorithm = new ArrayList<>();

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

                    if(dataToCPUalgorithm.size() == 2){
                        results = new Results(type, dataToCPUalgorithm, new ArrayList<Integer>());
                        cpUalgorithmsRandomizePanel.setThisInvisible();
                        resultsPanel.setType(type);
                        resultsPanel.setThisVisible();
                    }

                }
            }

            else if(cpUalgorithmsRandomizePanel.getSelectedSingleSeriesOption().equals("Option 2")){

                if(!cpUalgorithmsRandomizePanel.getSelectedBurstOption().equals("None") && !cpUalgorithmsRandomizePanel.getSelectedArrivalOption().equals("None") && cpUalgorithmsRandomizePanel.getAmount() != -1 && cpUalgorithmsRandomizePanel.getSeriesAmount() != -1){

                    int seriesAmount = cpUalgorithmsRandomizePanel.getSeriesAmount();
                    int amount = cpUalgorithmsRandomizePanel.getAmount();
                    processesGenerator = new ProcessesGenerator();
                    ArrayList<ArrayList<Integer>> dataToCPUalgorithm = new ArrayList<>();

                    ArrayList<ArrayList<Integer>> at = new ArrayList<>();

                    if(cpUalgorithmsRandomizePanel.getSelectedArrivalOption().equals("Option 1")){

                        for(int i = 0; i < seriesAmount; i++){
                            at.add(processesGenerator.generateArrivalTimeIncrement(amount));
                        }

                    }

                    else if(cpUalgorithmsRandomizePanel.getSelectedArrivalOption().equals("Option 2")){

                        for(int i = 0; i < seriesAmount; i++){
                            at.add(processesGenerator.generateArrivalTimeTotalRandom(amount, cpUalgorithmsRandomizePanel.getArrivalRandomMin(), cpUalgorithmsRandomizePanel.getArrivalRandomMax()));
                        }

                    }

                    else if(cpUalgorithmsRandomizePanel.getSelectedArrivalOption().equals("Option 3")){

                        for(int i = 0; i < seriesAmount; i++){
                            at.add(processesGenerator.generateArrivalTimeConst(amount));
                        }

                    }

                    ArrayList<ArrayList<Integer>> bt = new ArrayList<>();

                    if(cpUalgorithmsRandomizePanel.getSelectedBurstOption().equals("Option 2")){

                        if(cpUalgorithmsRandomizePanel.getMean() != -1 && cpUalgorithmsRandomizePanel.getStandardDeviation() != -1 && cpUalgorithmsRandomizePanel.getGaussMin() != -1 && cpUalgorithmsRandomizePanel.getGaussMax() != -1){

                            processesGenerator.setMean(cpUalgorithmsRandomizePanel.getMean());
                            processesGenerator.setStandardDeviation(cpUalgorithmsRandomizePanel.getStandardDeviation());

                            for(int i = 0; i < seriesAmount; i++){
                                bt.add(processesGenerator.generateBurstTime(amount, cpUalgorithmsRandomizePanel.getGaussMin(), cpUalgorithmsRandomizePanel.getGaussMax()));
                            }

                        }
                    }

                    else if(cpUalgorithmsRandomizePanel.getSelectedBurstOption().equals("Option 1")){

                        if(cpUalgorithmsRandomizePanel.getBurstRandomMin() != -1 && cpUalgorithmsRandomizePanel.getBurstRandomMax() != -1){

                            for(int i = 0; i < seriesAmount; i++){
                                bt.add(processesGenerator.generateBurstTimeTotalRandom(amount, cpUalgorithmsRandomizePanel.getBurstRandomMin(), cpUalgorithmsRandomizePanel.getBurstRandomMax()));
                            }

                        }

                    }

                    if(bt.size() + at.size() == seriesAmount * 2){
                        for(int i = 0; i < seriesAmount; i++){
                            dataToCPUalgorithm.add(at.get(i));
                            dataToCPUalgorithm.add(bt.get(i));
                        }

                        resultsSeries = new ResultsSeries(type,dataToCPUalgorithm,new ArrayList<ArrayList<Integer>>(),0);
                        cpUalgorithmsRandomizePanel.setThisInvisible();
                        resultsSeriesPanelCPU.dataInLabelsSetter();
                        resultsSeriesPanelCPU.setVisible(true);

                        seriesCPUchartsPanel.setData(resultsSeries.getFCFSwtMeans(), resultsSeries.getFCFStatMeans(), resultsSeries.getSJFnonPreemptiveWtMeans(), resultsSeries.getSJFnonPreemptiveTatMeans(), resultsSeries.getSJFpreemptiveWtMeans(), resultsSeries.getSJFpreemptiveTatMeans());
                    }

                }

            }

        }

        else if(e.getSource() == raMalgorithmsRandomizePanel.getStartButton()){

            if(raMalgorithmsRandomizePanel.getSelectedSingleSeriesOption().equals("Option 1")){

                if(raMalgorithmsRandomizePanel.getAmount() != -1 && raMalgorithmsRandomizePanel.getNumberOfFrames() != -1 && raMalgorithmsRandomizePanel.getReferencesRandomMin() != -1 && raMalgorithmsRandomizePanel.getReferencesRandomMax() != -1){
                    referencesGenerator = new ReferencesGenerator();
                    ArrayList<Integer> references = referencesGenerator.generateReferencesTotalRandom(raMalgorithmsRandomizePanel.getAmount(), raMalgorithmsRandomizePanel.getReferencesRandomMin(), raMalgorithmsRandomizePanel.getReferencesRandomMax(), raMalgorithmsRandomizePanel.getNumberOfFrames());
                    results = new Results(type, new ArrayList<ArrayList<Integer>>(), references);
                    raMalgorithmsRandomizePanel.setThisInvisible();
                    resultsPanel.setType(type);
                    resultsPanel.setThisVisible();
                }

            }

            else if(raMalgorithmsRandomizePanel.getSelectedSingleSeriesOption().equals("Option 2")){

                if(raMalgorithmsRandomizePanel.getAmount() != -1 && raMalgorithmsRandomizePanel.getNumberOfFrames() != -1 && raMalgorithmsRandomizePanel.getReferencesRandomMin() != -1 && raMalgorithmsRandomizePanel.getReferencesRandomMax() != -1 && raMalgorithmsRandomizePanel.getSeriesAmount() != -1){

                    ReferencesGenerator referencesGenerator = new ReferencesGenerator();
                    ArrayList<ArrayList<Integer>> data = new ArrayList<>();
                    int numberOfFrames = raMalgorithmsRandomizePanel.getNumberOfFrames();
                    int n = raMalgorithmsRandomizePanel.getSeriesAmount();
                    int referencesAmount = raMalgorithmsRandomizePanel.getAmount();
                    int minValue = raMalgorithmsRandomizePanel.getReferencesRandomMin();
                    int maxValue = raMalgorithmsRandomizePanel.getReferencesRandomMax();

                    for(int i = 0; i < n; i++){
                        data.add(referencesGenerator.generateReferencesTotalRandom(referencesAmount,minValue,maxValue,numberOfFrames));
                    }

                    resultsSeries = new ResultsSeries(type,new ArrayList<ArrayList<Integer>>(), data, numberOfFrames);

                    raMalgorithmsRandomizePanel.setThisInvisible();
                    resultsSeriesPanelRAM.dataInLabelsSetter();
                    resultsSeriesPanelRAM.setVisible(true);

                    seriesRAMchartsPanel.setData(resultsSeries.getFIFOhitRates(), resultsSeries.getLRUhitRates());

                }

            }

        }

        else if(e.getSource() == resultsPanel.getSaveButton()){

            if(type.equals("CPU")){
                double[] meanWt = {results.getFcfsAlgorithm().getMeanWt(), results.getSJFalgorithmNonPreemptive().getMeanWt(), results.getSJFalgorithmPreemptive().getMeanWt()};
                double[] meanTat = {results.getFcfsAlgorithm().getMeanTat(), results.getSJFalgorithmNonPreemptive().getMeanTat(), results.getSJFalgorithmPreemptive().getMeanTat()};
                fileOperator.saveCPUresults(results.getFcfsAlgorithm().getProcesses(),meanWt, meanTat);
            }

            else{
                int[] totalPageFaults = {results.getFifoAlgorithm().getTotalPageFaults(), results.getLruAlgorithm().getTotalPageFaults()};
                int[] totalHits = {results.getFifoAlgorithm().getTotalHits(), results.getLruAlgorithm().getTotalHits()};
                fileOperator.saveRAMresults(results.getFifoAlgorithm().referencesSequence, totalPageFaults, totalHits, results.getFramesAmount());
            }

            resultsPanel.getSaveButton().setVisible(false);
            resultsPanel.getSaveButton().setEnabled(false);

        }

        else if(e.getSource() == resultsSeriesPanelCPU.getSaveButton()){
            double[] wt = {resultsSeries.getFCFSwtMean(), resultsSeries.getSJFnonPreemptiveWtMean(), resultsSeries.getSJFpreemptiveWtMean()};
            double[] tat = {resultsSeries.getFCFStatMean(), resultsSeries.getSJFnonPreemptiveTatMean(), resultsSeries.getSJFpreemptiveTatMean()};
            fileOperator.saveCPUresultsSeries(resultsSeries.getProcessesToSave(), wt, tat);
            resultsSeriesPanelCPU.getSaveButton().setVisible(false);
            resultsSeriesPanelCPU.getSaveButton().setEnabled(false);
        }

        else if(e.getSource() == resultsSeriesPanelRAM.getSaveButton()){
            double[] hitRates = {resultsSeries.getFIFOmeanHitRate(), resultsSeries.getLRUmeanHitRate()};
            fileOperator.saveRAMresultsSeries(resultsSeries.getReferencesToSave(), hitRates, resultsSeries.getFramesAmount());
            resultsSeriesPanelRAM.getSaveButton().setVisible(false);
            resultsSeriesPanelRAM.getSaveButton().setEnabled(false);
        }

        else if(e.getSource() == resultsSeriesPanelCPU.getChartsButton()){
            resultsSeriesPanelCPU.setVisible(false);
            seriesCPUchartsPanel.setVisible(true);
        }

        else if(e.getSource() == seriesCPUchartsPanel.getGoBackButton()){
            resultsSeriesPanelCPU.setVisible(true);
            seriesCPUchartsPanel.setVisible(false);
        }

        else if(e.getSource() == resultsSeriesPanelRAM.getChartsButton()){
            resultsSeriesPanelRAM.setVisible(false);
            seriesRAMchartsPanel.setVisible(true);
        }

        else if(e.getSource() == seriesRAMchartsPanel.getGoBackButton()){
            resultsSeriesPanelRAM.setVisible(true);
            seriesRAMchartsPanel.setVisible(false);
        }

        else if(e.getSource() == resultsPanel.getExitButton()){
            System.exit(0);
        }

        else if(e.getSource() == resultsSeriesPanelRAM.getExitButton()){
            System.exit(0);
        }

        else if(e.getSource() == resultsSeriesPanelCPU.getExitButton()){
            System.exit(0);
        }

    }

}