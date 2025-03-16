package org.example;

import javax.swing.*;
import java.awt.*;

public class ResultsSeriesPanelCPU extends JPanel {

    private Frame frame;
    private JPanel upperPanel;
    private JPanel middlePanel;
    private JPanel middleLeftPanel;
    private JPanel middleMiddlePanel;
    private JPanel middleRightPanel;
    private JPanel lowerPanel;
    private JButton saveButton;
    private JButton exitButton;
    private JLabel amountLabel;
    private JLabel algorithmNo1Name;
    private JLabel algorithmNo2Name;
    private JLabel algorithmNo3Name;
    private JLabel infoLabel11;
    private JLabel infoLabel12;
    private JLabel infoLabel21;
    private JLabel infoLabel22;
    private JLabel infoLabel31;
    private JLabel infoLabel32;
    private JButton chartsButton;

    ResultsSeriesPanelCPU(Frame frame){
        this.frame = frame;
        this.setVisible(false);
        mainPanel();
        upperPanel();
        middlePanels();
        lowerPanel();
        createLabels();
        createInfoLabels();
        createSaveButton();
        createChartsButton();
        createExitButton();
        addThings();
    }

    private void mainPanel() {
        this.setBackground(new Color(60, 65, 66));
        this.setSize(1200, 700);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void upperPanel(){
        upperPanel = new JPanel();
        upperPanel.setBackground(new Color(60, 65, 66));
        upperPanel.setPreferredSize(new Dimension(1200, 100));
    }

    private void lowerPanel(){
        lowerPanel = new JPanel();
        lowerPanel.setBackground(new Color(60, 65, 66));
        lowerPanel.setPreferredSize(new Dimension(1200, 100));
    }

    private void middlePanels(){
        middlePanel = new JPanel(new GridLayout(1, 3));

        middleLeftPanel = new JPanel(new GridLayout(0, 1));
        middleLeftPanel.setBackground(new Color(60, 65, 66));

        middleMiddlePanel = new JPanel(new GridLayout(0, 1));
        middleMiddlePanel.setBackground(new Color(60, 65, 66));

        middleRightPanel = new JPanel(new GridLayout(0, 1));
        middleRightPanel.setBackground(new Color(60, 65, 66));

        middlePanel.add(middleLeftPanel);
        middlePanel.add(middleMiddlePanel);
        middlePanel.add(middleRightPanel);
    }

    private void createLabels(){
        amountLabel = new JLabel("Probes amount: ... Processes amount : ...", SwingConstants.CENTER);
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        amountLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        amountLabel.setForeground(new Color(243, 245, 240));

        algorithmNo1Name = new JLabel("FCFS", SwingConstants.CENTER);
        algorithmNo1Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        algorithmNo1Name.setFont(new Font("Helvetica", Font.BOLD, 30));
        algorithmNo1Name.setForeground(new Color(243, 245, 240));

        algorithmNo2Name = new JLabel("SJF", SwingConstants.CENTER);
        algorithmNo2Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        algorithmNo2Name.setFont(new Font("Helvetica", Font.BOLD, 30));
        algorithmNo2Name.setForeground(new Color(243, 245, 240));

        algorithmNo3Name = new JLabel("SRTF", SwingConstants.CENTER);
        algorithmNo3Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        algorithmNo3Name.setFont(new Font("Helvetica", Font.BOLD, 30));
        algorithmNo3Name.setForeground(new Color(243, 245, 240));
    }

    private void createInfoLabels(){
        infoLabel11 = new JLabel("Info label 11", SwingConstants.CENTER);
        infoLabel11.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel11.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel11.setForeground(new Color(243, 245, 240));

        infoLabel12 = new JLabel("Info label 12", SwingConstants.CENTER);
        infoLabel12.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel12.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel12.setForeground(new Color(243, 245, 240));

        infoLabel31 = new JLabel("Info label 13", SwingConstants.CENTER);
        infoLabel31.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel31.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel31.setForeground(new Color(243, 245, 240));

        infoLabel21 = new JLabel("Info label 21", SwingConstants.CENTER);
        infoLabel21.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel21.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel21.setForeground(new Color(243, 245, 240));

        infoLabel22 = new JLabel("Info label 22", SwingConstants.CENTER);
        infoLabel22.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel22.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel22.setForeground(new Color(243, 245, 240));

        infoLabel32 = new JLabel("Info label 23", SwingConstants.CENTER);
        infoLabel32.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel32.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel32.setForeground(new Color(243, 245, 240));
    }

    private void addThings(){
        upperPanel.add(amountLabel);

        middleLeftPanel.add(algorithmNo1Name);
        middleLeftPanel.add(infoLabel11);
        middleLeftPanel.add(infoLabel21);

        middleMiddlePanel.add(algorithmNo2Name);
        middleMiddlePanel.add(infoLabel12);
        middleMiddlePanel.add(infoLabel22);

        middleRightPanel.add(algorithmNo3Name);
        middleRightPanel.add(infoLabel31);
        middleRightPanel.add(infoLabel32);

        lowerPanel.add(saveButton);
        lowerPanel.add(chartsButton);
        lowerPanel.add(exitButton);

        this.add(upperPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(lowerPanel, BorderLayout.SOUTH);
    }

    private void createSaveButton(){
        saveButton = new JButton("Save");
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        saveButton.setBackground(new Color(204, 119, 34));
        saveButton.setForeground(new Color(243, 245, 240));
        saveButton.setBorderPainted(false);
        saveButton.setFocusPainted(false);
        //saveButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        saveButton.addActionListener(frame);
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveButton.setBackground(new Color(204, 119, 34));
            }
        });
    }

    private void createChartsButton(){
        chartsButton = new JButton("Charts");
        chartsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        chartsButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        chartsButton.setBackground(new Color(204, 119, 34));
        chartsButton.setForeground(new Color(243, 245, 240));
        chartsButton.setBorderPainted(false);
        chartsButton.setFocusPainted(false);
        //saveButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        chartsButton.addActionListener(frame);
        chartsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chartsButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chartsButton.setBackground(new Color(204, 119, 34));
            }
        });
    }

    private void createExitButton(){
        exitButton = new JButton("Exit");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        exitButton.setBackground(new Color(204, 119, 34));
        exitButton.setForeground(new Color(243, 245, 240));
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        //exitButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        exitButton.addActionListener(frame);
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButton.setBackground(new Color(204, 119, 34));
            }
        });
    }

    public void dataInLabelsSetter(){
        amountLabel.setText("Series amount : " + frame.getResultsSeries().getFCFSwtMeans().size() + " Processes amount : " + frame.getResultsSeries().getProcessesAmount());

        infoLabel11.setText("Mean wt: " + String.format("%.3f",frame.getResultsSeries().getFCFSwtMean()));
        infoLabel12.setText("Mean wt: " + String.format("%.3f",frame.getResultsSeries().getSJFnonPreemptiveWtMean()));

        infoLabel21.setText("Mean tat: " + String.format("%.3f",frame.getResultsSeries().getFCFStatMean()));
        infoLabel22.setText("Mean tat: " + String.format("%.3f",frame.getResultsSeries().getSJFnonPreemptiveTatMean()));

        infoLabel31.setText("Mean wt: " + String.format("%.3f",frame.getResultsSeries().getSJFpreemptiveWtMean()));
        infoLabel32.setText("Mean tat: " + String.format("%.3f",frame.getResultsSeries().getSJFpreemptiveTatMean()));
    }

    public JButton getSaveButton(){
        return saveButton;
    }

    public JButton getExitButton(){
        return exitButton;
    }

    public JButton getChartsButton(){
        return chartsButton;
    }

}
