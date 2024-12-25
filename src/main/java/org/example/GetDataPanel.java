package org.example;

import javax.swing.*;
import java.awt.*;

public class GetDataPanel extends JPanel {

    private Frame frame;
    private JButton goBackButton;
    private JButton chooseFileButton;
    private JButton randomizedDataButton;
    private JButton goNextButton;
    private JLabel chosenFileNameLabel;

    GetDataPanel(Frame frame){
        this.frame = frame;
        this.setVisible(false);
        mainPanel();
        createChooseFileButton();
        createChosenFileNameLabel();
        createRandomizedDataButton();
        createGoNextButton();
        createGoBackButton();
        addThings();
    }

    private void mainPanel(){
        this.setBackground(new Color(60, 65, 66));
        this.setSize(1200,700);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void createGoBackButton(){
        goBackButton = new JButton("Back");
        goBackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        goBackButton.setFont(new Font("Helvetica", Font.BOLD, 30));
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

    private void createChooseFileButton(){
        chooseFileButton = new JButton("Browse");
        chooseFileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        chooseFileButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        chooseFileButton.setBackground(new Color(204, 119, 34));
        chooseFileButton.setForeground(new Color(243, 245, 240));
        chooseFileButton.setBorderPainted(false);
        chooseFileButton.setFocusPainted(false);
        chooseFileButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        chooseFileButton.addActionListener(frame);
        chooseFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chooseFileButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chooseFileButton.setBackground(new Color(204, 119, 34));
            }
        });
    }

    private void createRandomizedDataButton(){
        randomizedDataButton = new JButton("Randomize");
        randomizedDataButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        randomizedDataButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        randomizedDataButton.setBackground(new Color(204, 119, 34));
        randomizedDataButton.setForeground(new Color(243, 245, 240));
        randomizedDataButton.setBorderPainted(false);
        randomizedDataButton.setFocusPainted(false);
        randomizedDataButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        randomizedDataButton.addActionListener(frame);
        randomizedDataButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                randomizedDataButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                randomizedDataButton.setBackground(new Color(204, 119, 34));
            }
        });
    }

    private void createGoNextButton(){
        goNextButton = new JButton("Next");
        goNextButton.setVisible(false);
        goNextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        goNextButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        goNextButton.setBackground(new Color(204, 119, 34));
        goNextButton.setForeground(new Color(243, 245, 240));
        goNextButton.setBorderPainted(false);
        goNextButton.setFocusPainted(false);
        goNextButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        goNextButton.addActionListener(frame);
        goNextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goNextButton.setBackground(new Color(204, 140, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                goNextButton.setBackground(new Color(204, 119, 34));
            }
        });
    }

    private void createChosenFileNameLabel(){
        chosenFileNameLabel = new JLabel("Select file");
        chosenFileNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        chosenFileNameLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        chosenFileNameLabel.setForeground(new Color(243, 245, 240));
    }

    public void setGoNextButtonVisible(){
        goNextButton.setVisible(true);
    }

    public void setGoNextButtonInvisible(){
        goNextButton.setVisible(false);
    }

    private void addThings(){
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(chooseFileButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(chosenFileNameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(randomizedDataButton);
        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(goNextButton);
        this.add(Box.createRigidArea(new Dimension(0, 75)));
        this.add(goBackButton);
    }

    public void setChosenFileNameLabelText(String fileName){
        chosenFileNameLabel.setText(fileName);
    }

    public JButton getGoBackButton(){
        return goBackButton;
    }

    public JButton getChooseFileButton(){
        return chooseFileButton;
    }

    public JButton getRandomizedDataButton(){
        return randomizedDataButton;
    }

    public JButton getGoNextButton(){
        return goNextButton;
    }

    public void setThisVisible(){
        this.setVisible(true);
    }

    public void setThisInvisible(){
        this.setVisible(false);
    }

}
