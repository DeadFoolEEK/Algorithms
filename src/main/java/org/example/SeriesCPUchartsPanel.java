package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeriesCPUchartsPanel extends JPanel{

    private Frame frame;
    private JButton goBackButton;
    private JPanel chartsPanel;
    private double[] data1;
    private double[] data2;
    private double[] data3;
    private double[] data4;
    private double[] data5;
    private double[] data6;

    SeriesCPUchartsPanel(Frame frame){
        this.frame = frame;
        this.setVisible(false);
        mainPanel();
        chartsPanel();
        createGoBackButton();
        addThings();
    }

    public void setData(ArrayList<Double> data1, ArrayList<Double> data2, ArrayList<Double> data3, ArrayList<Double> data4, ArrayList<Double> data5, ArrayList<Double> data6){
        int size = data1.size();
        this.data1 = new double[size];
        this.data2 = new double[size];
        this.data3 = new double[size];
        this.data4 = new double[size];
        this.data5 = new double[size];
        this.data6 = new double[size];

        for(int i = 0; i < size; i++){
            this.data1[i] = data1.get(i);
            this.data2[i] = data2.get(i);
            this.data3[i] = data3.get(i);
            this.data4[i] = data4.get(i);
            this.data5[i] = data5.get(i);
            this.data6[i] = data6.get(i);
        }

        createCharts();
    }

    private void createCharts(){
        chartsPanel.add(createChartPanel(data1, "FCFS mean wt","Waiting time"));
        chartsPanel.add(createChartPanel(data3, "SJF mean wt","Waiting time"));
        chartsPanel.add(createChartPanel(data5, "SRTF mean wt","Waiting time"));
        chartsPanel.add(createChartPanel(data2, "FCFS mean tat","Turn around time"));
        chartsPanel.add(createChartPanel(data4, "SJF mean tat", "Turn around time"));
        chartsPanel.add(createChartPanel(data6, "SRTF mean tat", "Turn around time"));
    }

    private void addThings(){
        this.add(chartsPanel, BorderLayout.CENTER);
        this.add(goBackButton, BorderLayout.SOUTH);
    }

    private void mainPanel(){
        this.setBackground(new Color(60, 65, 66));
        this.setSize(1200, 700);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void chartsPanel(){
        chartsPanel = new JPanel();
        chartsPanel.setLayout(new GridLayout(2, 3, 10, 10));
    }

    private void createGoBackButton() {
        goBackButton = new JButton("Back");
        goBackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        goBackButton.setFont(new Font("Helvetica", Font.BOLD, 20));
        goBackButton.setBackground(new Color(204, 119, 34));
        goBackButton.setForeground(new Color(243, 245, 240));
        goBackButton.setBorderPainted(false);
        goBackButton.setFocusPainted(false);
        goBackButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        goBackButton.addActionListener(frame);
        goBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goBackButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                goBackButton.setBackground(new Color(204, 119, 34));
            }
        });
    }

    private static JPanel createChartPanel(double[] data, String title, String xLabel) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Frequency", data, 10);

        JFreeChart chart = ChartFactory.createHistogram(
                title,
                xLabel,
                "Frequency",
                dataset
        );

        return new ChartPanel(chart);
    }

    public JButton getGoBackButton(){
        return goBackButton;
    }

}
