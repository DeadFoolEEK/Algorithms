package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.awt.*;

public class SeriesRAMchartsPanel extends JPanel {

    private Frame frame;
    private JButton goBackButton;
    private JPanel chartsPanel;
    private double data1[];
    private double data2[];

    SeriesRAMchartsPanel(Frame frame){
        this.frame = frame;
        this.setVisible(false);
        mainPanel();
        chartsPanel();
        createGoBackButton();
        addThings();
    }

    public void setData(double[] data1, double[] data2){
        this.data1 = data1;
        this.data2 = data2;
        createCharts();
    }

    private void createCharts(){
        chartsPanel.add(createChartPanel(data1, "FIFO"));
        chartsPanel.add(createChartPanel(data2, "LRU"));
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
        chartsPanel.setLayout(new GridLayout(1, 2, 10, 10));
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

    private static JPanel createChartPanel(double[] data, String title) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Frequency", data, 10);

        JFreeChart chart = ChartFactory.createHistogram(
                title,
                "Hit rate",
                "Frequency",
                dataset
        );

        return new ChartPanel(chart);
    }

    public JButton getGoBackButton(){
        return goBackButton;
    }

}
