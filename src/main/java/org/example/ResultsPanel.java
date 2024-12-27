package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ResultsPanel extends JPanel {

    private String type;
    private FCFSalgorithm cpu1;
    private SJFalgorithm cpu2;
    private FIFOalgorithm ram1;
    private LRUalgorithm ram2;
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
    private JLabel infoLabel11;
    private JLabel infoLabel12;
    private JLabel infoLabel21;
    private JLabel infoLabel22;
    private JLabel infoLabel31;
    private JLabel infoLabel32;

    ResultsPanel(Frame frame){
        this.frame = frame;
        this.setVisible(false);
        createThings();
        addThings();
    }

    public void setType(String type){
        this.type = type;
        if(type.equals("CPU")){
            cpu1 = frame.getResults().getFcfSalgorithm();
            cpu2 = frame.getResults().getSjFalgorithm();
        }
        else{
            ram1 = frame.getResults().getFifOalgorithm();
            ram2 = frame.getResults().getLrUalgorithm();
        }
        dataInLabelsSetter();
    }

    private void dataInLabelsSetter(){
        if(type.equals("CPU")){
            amountLabel.setText("Processes amount: " + cpu1.getProcesses().size());
            algorithmNo1Name.setText(cpu1.getName());
            algorithmNo2Name.setText(cpu2.getName());
            infoLabel11.setText("Passed time: " + cpu1.getTimePassed());
            infoLabel12.setText("Passed time: " + cpu2.getTimePassed());
            infoLabel21.setText("Mean Waiting time: " + cpu1.getMeanWt());
            infoLabel22.setText("Mean Waiting time: " + cpu2.getMeanWt());
            infoLabel31.setText("Mean Turn Around Time: " + cpu1.getMeanTat());
            infoLabel32.setText("Mean Turn Around Time: " + cpu2.getMeanTat());
        }
        else{
            amountLabel.setText("Pages amount: " + ram1.getReferencesSequence().length);
            algorithmNo1Name.setText(ram1.getName());
            algorithmNo2Name.setText(ram2.getName());
            infoLabel11.setText("Total hits: " + ram1.getTotalHits());
            infoLabel12.setText("Total hits: " + ram2.getTotalHits());
            infoLabel21.setText("Total page faults: " + ram1.getTotalPageFaults());
            infoLabel22.setText("Total page faults: " + ram2.getTotalPageFaults());
            infoLabel31.setText("Hit rate: " + ram1.getHitRate());
            infoLabel32.setText("Hit rate: " + ram2.getHitRate());

            System.out.println(Arrays.toString(ram1.getReferencesSequence()));
            System.out.println(Arrays.toString(ram2.getReferencesSequence()));
        }
    }

    private void createLabels(){
        amountLabel = new JLabel("Amount", SwingConstants.CENTER);
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        amountLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        amountLabel.setForeground(new Color(243, 245, 240));

        algorithmNo1Name = new JLabel("Algorithm 1", SwingConstants.CENTER);
        algorithmNo1Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        algorithmNo1Name.setFont(new Font("Helvetica", Font.BOLD, 30));
        algorithmNo1Name.setForeground(new Color(243, 245, 240));

        algorithmNo2Name = new JLabel("Algorithm 2", SwingConstants.CENTER);
        algorithmNo2Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        algorithmNo2Name.setFont(new Font("Helvetica", Font.BOLD, 30));
        algorithmNo2Name.setForeground(new Color(243, 245, 240));
    }

    private void createInfoLabels(){
        infoLabel11 = new JLabel("Info label 1", SwingConstants.CENTER);
        infoLabel11.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel11.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel11.setForeground(new Color(243, 245, 240));

        infoLabel12 = new JLabel("Info label 1", SwingConstants.CENTER);
        infoLabel12.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel12.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel12.setForeground(new Color(243, 245, 240));

        infoLabel21 = new JLabel("Info label 2", SwingConstants.CENTER);
        infoLabel21.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel21.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel21.setForeground(new Color(243, 245, 240));

        infoLabel22 = new JLabel("Info label 2", SwingConstants.CENTER);
        infoLabel22.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel22.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel22.setForeground(new Color(243, 245, 240));

        infoLabel31 = new JLabel("Info label 3", SwingConstants.CENTER);
        infoLabel31.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel31.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel31.setForeground(new Color(243, 245, 240));

        infoLabel32 = new JLabel("Info label 3", SwingConstants.CENTER);
        infoLabel32.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel32.setFont(new Font("Helvetica", Font.BOLD, 20));
        infoLabel32.setForeground(new Color(243, 245, 240));
    }

    private void mainPanel() {
        this.setBackground(new Color(60, 65, 66));
        this.setSize(1200, 700);
        this.setLayout(new BorderLayout());
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

    private void createThings(){
        mainPanel();
        upperPanel();
        middlePanels();
        lowerPanel();
        createLabels();
        createInfoLabels();
        createSaveButton();
        createExitButton();
    }

    private void addThings(){
        upperPanel.add(amountLabel);
        middleLeftPanel.add(algorithmNo1Name);
        middleLeftPanel.add(infoLabel11);
        middleLeftPanel.add(infoLabel21);
        middleLeftPanel.add(infoLabel31);
        middleRightPanel.add(algorithmNo2Name);
        middleRightPanel.add(infoLabel12);
        middleRightPanel.add(infoLabel22);
        middleRightPanel.add(infoLabel32);
        lowerPanel.add(saveButton);
        lowerPanel.add(exitButton);
        this.add(upperPanel, BorderLayout.NORTH);
        this.add(lowerPanel, BorderLayout.SOUTH);
        this.add(middlePanel, BorderLayout.CENTER);
    }

    public void setThisVisible(){
        this.setVisible(true);
    }

    public JButton getExitButton(){
        return exitButton;
    }

    public JButton getSaveButton(){
        return saveButton;
    }

}
