package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    // 204, 119, 34 Ochre RGB
    // 243, 245, 240 Snow white RGB
    private Frame frame;
    private JPanel mainPanel;
    private JButton cpuAlgorithmButton;
    private JButton ramAlgorithmButton;
    private JButton exitButton;
    private JLabel menuTitle;

    Menu(Frame frame){
        this.frame = frame;
        mainPanel();
        mainPanelMakeGap();
        createMenuTitle();
        createCpuAlgorithmButton();
        createRamAlgorithmButton();
        createExitButton();
        addToMainPanel();
    }

    private void mainPanel(){
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(60, 65, 66));
        mainPanel.setSize(1200,700);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    private void mainPanelMakeGap(){
        mainPanel.add(Box.createVerticalGlue());
    }

    private void addToMainPanel(){
        mainPanel.add(menuTitle);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(cpuAlgorithmButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(ramAlgorithmButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(exitButton);
        mainPanel.add(Box.createVerticalGlue());
    }

    private void createMenuTitle(){
        menuTitle = new JLabel("Algorithms");
        menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuTitle.setFont(new Font("Helvetica", Font.BOLD, 60));
        menuTitle.setForeground(new Color(243, 245, 240));
    }

    private void createCpuAlgorithmButton(){
        cpuAlgorithmButton = new JButton("CPU Algorithms");
        cpuAlgorithmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cpuAlgorithmButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        cpuAlgorithmButton.setBackground(new Color(204, 119, 34));
        cpuAlgorithmButton.setForeground(new Color(243, 245, 240));
        cpuAlgorithmButton.setBorderPainted(false);
        cpuAlgorithmButton.setFocusPainted(false);
        cpuAlgorithmButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        cpuAlgorithmButton.addActionListener(frame);
        cpuAlgorithmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cpuAlgorithmButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cpuAlgorithmButton.setBackground(new Color(204, 119, 34));
            }
        });
    }

    private void createRamAlgorithmButton(){
        ramAlgorithmButton = new JButton("RAM Algorithms");
        ramAlgorithmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ramAlgorithmButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        ramAlgorithmButton.setBackground(new Color(204, 119, 34));
        ramAlgorithmButton.setForeground(new Color(243, 245, 240));
        ramAlgorithmButton.setBorderPainted(false);
        ramAlgorithmButton.setFocusPainted(false);
        ramAlgorithmButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        ramAlgorithmButton.addActionListener(frame);
        ramAlgorithmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ramAlgorithmButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ramAlgorithmButton.setBackground(new Color(204, 119, 34));
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
        exitButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
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

    public JButton getCpuAlgorithmButton(){
        return cpuAlgorithmButton;
    }

    public JButton getRamAlgorithmButton(){
        return ramAlgorithmButton;
    }

    public JButton getExitButton(){
        return exitButton;
    }

    public void showMainPanel(){
        mainPanel.setVisible(true);
    }

    public void hideMainPanel(){
        mainPanel.setVisible(false);
    }

}