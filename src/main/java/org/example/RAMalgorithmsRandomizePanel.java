package org.example;

import javax.swing.*;
import java.awt.*;

public class RAMalgorithmsRandomizePanel extends JPanel {

    private Frame frame;
    private JButton goBackButton;
    private JButton startButton;

    RAMalgorithmsRandomizePanel(Frame frame){
        this.frame = frame;
        this.setVisible(false);
        mainPanel();
        createGoBackButton();
        createStartButton();
        addThings();
    }

    private void mainPanel() {
        this.setBackground(new Color(60, 65, 66));
        this.setSize(1200, 700);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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

    private void createStartButton(){
        startButton = new JButton("Start");
        startButton.setVisible(true);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setFont(new Font("Helvetica", Font.BOLD, 20));
        startButton.setBackground(new Color(204, 119, 34));
        startButton.setForeground(new Color(243, 245, 240));
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        startButton.addActionListener(frame);
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButton.setBackground(new Color(204, 119, 34));
            }
        });
    }

    private void addThings() {
        this.add(goBackButton);
        this.add(startButton);
    }

    public void setThisVisible() {
        this.setVisible(true);
    }

    public void setThisInvisible() {
        this.setVisible(false);
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public JButton getStartButton(){
        return startButton;
    }

}
