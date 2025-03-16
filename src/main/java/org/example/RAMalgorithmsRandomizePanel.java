package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RAMalgorithmsRandomizePanel extends JPanel {

    private Frame frame;
    private JButton goBackButton;
    private JButton startButton;
    private JLabel amountLabel;
    private JTextField amountField;
    private JLabel referenceSequenceLabel;
    private JLabel numberOfFramesLabel;
    private JTextField numberOfFramesField;
    private JLabel referencesRandomMinLabel;
    private JLabel referencesRandomMaxLabel;
    private JTextField referencesRandomMinField;
    private JTextField referencesRandomMaxField;
    private JRadioButton singleButton;
    private JRadioButton seriesButton;
    private ButtonGroup singleSeriesGroup;
    private JLabel seriesAmountLabel;
    private JTextField seriesAmountField;

    RAMalgorithmsRandomizePanel(Frame frame){
        this.frame = frame;
        this.setVisible(false);
        mainPanel();
        createGoBackButton();
        createStartButton();
        createAmountLabel();
        createAmountField();
        createReferenceSequenceLabel();
        createNumberOfFramesLabel();
        createNumberOfFramesField();
        createReferencesRandomOptions();
        createSeriesAmountLabel();
        createSeriesAmountField();
        createSingleSeriesButtonsGroup();
        addThings();
    }

    private void mainPanel() {
        this.setBackground(new Color(60, 65, 66));
        this.setSize(1200, 700);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void createAmountLabel() {
        amountLabel = new JLabel("References amount");
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        amountLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        amountLabel.setForeground(new Color(243, 245, 240));
    }

    private void createReferenceSequenceLabel() {
        referenceSequenceLabel = new JLabel("Reference sequence");
        referenceSequenceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        referenceSequenceLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        referenceSequenceLabel.setForeground(new Color(243, 245, 240));
    }

    private void createNumberOfFramesLabel() {
        numberOfFramesLabel = new JLabel("Number of frames");
        numberOfFramesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        numberOfFramesLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        numberOfFramesLabel.setForeground(new Color(243, 245, 240));
    }

    private void createAmountField() {
        amountField = new JTextField(10);
        amountField.setMaximumSize(new Dimension(200, 30));
        amountField.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void createNumberOfFramesField() {
        numberOfFramesField = new JTextField(10);
        numberOfFramesField.setMaximumSize(new Dimension(200, 30));
        numberOfFramesField.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void createReferencesRandomOptions(){
        referencesRandomMinLabel = new JLabel("Min value");
        referencesRandomMinLabel .setAlignmentX(Component.CENTER_ALIGNMENT);
        referencesRandomMinLabel .setFont(new Font("Helvetica", Font.PLAIN, 10));
        referencesRandomMinLabel .setForeground(new Color(243, 245, 240));

        referencesRandomMinField = new JTextField(10);
        referencesRandomMinField.setMaximumSize(new Dimension(200, 30));
        referencesRandomMinField.setAlignmentX(Component.CENTER_ALIGNMENT);
        //referencesRandomMinField.setEditable(false);

        referencesRandomMaxLabel = new JLabel("Max value");
        referencesRandomMaxLabel .setAlignmentX(Component.CENTER_ALIGNMENT);
        referencesRandomMaxLabel .setFont(new Font("Helvetica", Font.PLAIN, 10));
        referencesRandomMaxLabel .setForeground(new Color(243, 245, 240));

        referencesRandomMaxField = new JTextField(10);
        referencesRandomMaxField.setMaximumSize(new Dimension(200, 30));
        referencesRandomMaxField.setAlignmentX(Component.CENTER_ALIGNMENT);
        //referencesRandomMaxField.setEditable(false);
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

    private void createSeriesAmountLabel(){
        seriesAmountLabel = new JLabel("Series amount");
        seriesAmountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        seriesAmountLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        seriesAmountLabel.setForeground(new Color(243, 245, 240));
    }

    private void createSeriesAmountField(){
        seriesAmountField = new JTextField(10);
        seriesAmountField.setMaximumSize(new Dimension(200, 30));
        seriesAmountField.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void createSingleSeriesButtonsGroup() {
        singleButton = new JRadioButton("Single");
        seriesButton = new JRadioButton("Series");

        singleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        seriesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        singleButton.setBackground(new Color(60, 65, 66));
        seriesButton.setBackground(new Color(60, 65, 66));

        singleButton.setForeground(new Color(243, 245, 240));
        seriesButton.setForeground(new Color(243, 245, 240));

        singleSeriesGroup = new ButtonGroup();

        singleButton.setSelected(true);
        seriesAmountField.setEditable(false);

        singleSeriesGroup.add(singleButton);
        singleSeriesGroup.add(seriesButton);

        seriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seriesAmountField.setEditable(true);
            }
        });

        singleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seriesAmountField.setEditable(false);
            }
        });
    }

    public String getSelectedSingleSeriesOption() {
        if (singleButton.isSelected()) {
            return "Option 1";
        } else if (seriesButton.isSelected()) {
            return "Option 2";
        }
        return "None";
    }

    private void addThings() {
        this.add(goBackButton);
        this.add(amountLabel);
        this.add(amountField);
        this.add(referenceSequenceLabel);
        this.add(referencesRandomMinLabel);
        this.add(referencesRandomMinField);
        this.add(referencesRandomMaxLabel);
        this.add(referencesRandomMaxField);
        this.add(numberOfFramesLabel);
        this.add(numberOfFramesField);
        this.add(singleButton);
        this.add(seriesButton);
        this.add(seriesAmountLabel);
        this.add(seriesAmountField);
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

    public int getAmount() {
        try {
            String text = amountField.getText().trim();
            if(Integer.parseInt(text) <= 0){
                JOptionPane.showMessageDialog(this, "Invalid input for Processes Amount. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Processes Amount. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return a default or error value.
        }
    }

    public int getNumberOfFrames() {
        try {
            String text = numberOfFramesField.getText().trim();
            if(Integer.parseInt(text) <= 0){
                JOptionPane.showMessageDialog(this, "Invalid input for Number of frames. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Number of frames. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return a default or error value.
        }
    }

    public int getReferencesRandomMin() {
        try {
            String text = referencesRandomMinField.getText().trim();
            if(Integer.parseInt(text) < 0){
                JOptionPane.showMessageDialog(this, "Invalid input for Min value. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Min value. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return a default or error value.
        }
    }

    public int getReferencesRandomMax() {
        try {
            String text = referencesRandomMaxField.getText().trim();
            if(Integer.parseInt(text) <= 0){
                JOptionPane.showMessageDialog(this, "Invalid input for Max value. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Max value. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return a default or error value.
        }
    }

    public int getSeriesAmount() {
        try {
            String text = seriesAmountField.getText().trim();
            if(Integer.parseInt(text) <= 1){
                JOptionPane.showMessageDialog(this, "Invalid input for Series amount. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Series amount. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return a default or error value.
        }
    }

}
