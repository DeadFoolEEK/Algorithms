package org.example;

import javax.swing.*;
import java.awt.*;

public class ResultsSeriesPanelRAM extends JPanel {

    private Frame frame;
    private JPanel upperPanel;
    private JPanel middlePanel;
    private JPanel middleLeftPanel;
    private JPanel middleRightPanel;
    private JPanel lowerPanel;
    private JButton saveButton;
    private JButton exitButton;
    private JLabel amountLabel;
    private JLabel algorithmNo1Name;
    private JLabel algorithmNo2Name;
    private JLabel infoLabel1;
    private JLabel infoLabel2;
    private JButton chartsButton;

    ResultsSeriesPanelRAM(Frame frame){
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
        middlePanel = new JPanel(new GridLayout(1, 2));

        middleLeftPanel = new JPanel(new GridLayout(0, 1));
        middleLeftPanel.setBackground(new Color(60, 65, 66));

        middleRightPanel = new JPanel(new GridLayout(0, 1));
        middleRightPanel.setBackground(new Color(60, 65, 66));

        middlePanel.add(middleLeftPanel);
        middlePanel.add(middleRightPanel);
    }

    private void createLabels(){
        amountLabel = new JLabel("Probes amount: ... References amount : ...", SwingConstants.CENTER);
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        amountLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        amountLabel.setForeground(new Color(243, 245, 240));

        algorithmNo1Name = new JLabel("FIFO", SwingConstants.CENTER);
        algorithmNo1Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        algorithmNo1Name.setFont(new Font("Helvetica", Font.BOLD, 30));
        algorithmNo1Name.setForeground(new Color(243, 245, 240));

        algorithmNo2Name = new JLabel("LRU", SwingConstants.CENTER);
        algorithmNo2Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        algorithmNo2Name.setFont(new Font("Helvetica", Font.BOLD, 30));
        algorithmNo2Name.setForeground(new Color(243, 245, 240));
    }

    private void createInfoLabels(){
        infoLabel1 = new JLabel("Info label 1", SwingConstants.CENTER);
        infoLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel1.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel1.setForeground(new Color(243, 245, 240));

        infoLabel2 = new JLabel("Info label 1", SwingConstants.CENTER);
        infoLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel2.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel2.setForeground(new Color(243, 245, 240));
    }

    public void dataInLabelsSetter(){
        amountLabel.setText("Series amount : " + frame.getResultsSeries().getFIFOhitRates().length + " References amount : " + frame.getResultsSeries().getReferencesAmount());
        infoLabel1.setText("Mean hit rate: " + String.format("%.3f", frame.getResultsSeries().getFIFOmeanHitRate()));
        infoLabel2.setText("Mean hit rate: " + String.format("%.3f",frame.getResultsSeries().getLRUmeanHitRate()));
    }

    private void addThings(){
        upperPanel.add(amountLabel);
        middleLeftPanel.add(algorithmNo1Name);
        middleLeftPanel.add(infoLabel1);
        middleRightPanel.add(algorithmNo2Name);
        middleRightPanel.add(infoLabel2);
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
