package org.example;

import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {

    private Frame frame;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JPanel upperLeftPanel;
    private JPanel upperRightPanel;
    private JButton saveButton;
    private JButton exitButton;

    ResultsPanel(Frame frame){
        this.frame = frame;
        this.setVisible(false);
        createThings();
        addThings();
    }

    private void mainPanel() {
        this.setBackground(new Color(60, 65, 66));
        this.setSize(1200, 700);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void upperPanel(){
        upperPanel = new JPanel(new GridLayout(1, 2));
    }

    private void lowerPanel(){
        lowerPanel = new JPanel();
        lowerPanel.setBackground(Color.CYAN);
    }

    private void upperLeftPanel(){
        upperLeftPanel = new JPanel();
        upperLeftPanel.setBackground(Color.YELLOW);
    }

    private void upperRightPanel(){
        upperRightPanel = new JPanel();
        upperRightPanel.setBackground(Color.BLUE);
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
        lowerPanel();
        upperRightPanel();
        upperLeftPanel();
        createSaveButton();
        createExitButton();
    }

    private void addThings(){
        lowerPanel.add(saveButton);
        lowerPanel.add(exitButton);
        this.add(upperRightPanel);
        this.add(upperLeftPanel);
        this.add(upperPanel, BorderLayout.NORTH);
        this.add(lowerPanel, BorderLayout.CENTER);
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
