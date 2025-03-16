package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPUalgorithmsRandomizePanel extends JPanel {

    private Frame frame;
    private JButton goBackButton;
    private JLabel burstTimeLabel;
    private JLabel arrivalTimeLabel;
    private JLabel amountLabel;
    private JTextField amountField;
    private JRadioButton burstOption1;
    private JRadioButton burstOption2;
    private JRadioButton arrivalOption1;
    private JRadioButton arrivalOption2;
    private JRadioButton arrivalOption3;
    private ButtonGroup burstGroup;
    private ButtonGroup arrivalGroup;
    private JLabel meanLabel;
    private JLabel stdDevLabel;
    private JTextField meanField;
    private JTextField stdDevField;
    private JButton startButton;
    private JLabel gaussMinLabel;
    private JLabel gaussMaxLabel;
    private JTextField gaussMinField;
    private JTextField gaussMaxField;
    private JLabel burstRandomMinLabel;
    private JLabel burstRandomMaxLabel;
    private JTextField burstRandomMinField;
    private JTextField burstRandomMaxField;
    private JLabel arrivalRandomMinLabel;
    private JLabel arrivalRandomMaxLabel;
    private JTextField arrivalRandomMinField;
    private JTextField arrivalRandomMaxField;
    private JRadioButton singleButton;
    private JRadioButton seriesButton;
    private ButtonGroup singleSeriesGroup;
    private JLabel seriesAmountLabel;
    private JTextField seriesAmountField;
    private JPanel upperPanel;

    CPUalgorithmsRandomizePanel(Frame frame) {
        this.frame = frame;
        this.setVisible(false);
        mainPanel();
        createGoBackButton();
        createUpperPanel();
        createAmountLabel();
        createAmountField();
        createArrivalTimeLabel();
        createArrivalTimeOptions();
        createArrivalRandomOptions();
        createBurstTimeLabel();
        createBurstTimeOptions();
        createBurstRandomOptionInputs();
        createBurstGaussOptionInputs();
        createSeriesAmountLabel();
        createSeriesAmountField();
        createSingleSeriesButtonsGroup();
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
        goBackButton.setFont(new Font("Helvetica", Font.BOLD, 15));
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

    private void createBurstTimeLabel() {
        burstTimeLabel = new JLabel("Burst time");
        burstTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        burstTimeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        burstTimeLabel.setForeground(new Color(243, 245, 240));
    }

    private void createBurstTimeOptions() {
        burstOption1 = new JRadioButton("Random");
        burstOption2 = new JRadioButton("Gauss");

        burstOption1.setAlignmentX(Component.CENTER_ALIGNMENT);
        burstOption2.setAlignmentX(Component.CENTER_ALIGNMENT);

        burstOption1.setBackground(new Color(60, 65, 66));
        burstOption2.setBackground(new Color(60, 65, 66));

        burstOption1.setForeground(new Color(243, 245, 240));
        burstOption2.setForeground(new Color(243, 245, 240));

        burstGroup = new ButtonGroup();
        burstGroup.add(burstOption1);
        burstGroup.add(burstOption2);

        burstOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean enabled = burstOption2.isSelected();
                meanField.setEditable(enabled);
                stdDevField.setEditable(enabled);
                gaussMinField.setEditable(enabled);
                gaussMaxField.setEditable(enabled);
                burstRandomMinField.setEditable(!enabled);
                burstRandomMaxField.setEditable(!enabled);
            }
        });

        burstOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean enabled = !burstOption1.isSelected();
                meanField.setEditable(enabled);
                stdDevField.setEditable(enabled);
                gaussMinField.setEditable(enabled);
                gaussMaxField.setEditable(enabled);
                burstRandomMinField.setEditable(!enabled);
                burstRandomMaxField.setEditable(!enabled);
            }
        });
    }

    private void createArrivalRandomOptions(){
        arrivalRandomMinLabel = new JLabel("Min value");
        arrivalRandomMinLabel .setAlignmentX(Component.CENTER_ALIGNMENT);
        arrivalRandomMinLabel .setFont(new Font("Helvetica", Font.PLAIN, 10));
        arrivalRandomMinLabel .setForeground(new Color(243, 245, 240));

        arrivalRandomMinField = new JTextField(10);
        arrivalRandomMinField.setMaximumSize(new Dimension(200, 30));
        arrivalRandomMinField.setAlignmentX(Component.CENTER_ALIGNMENT);
        arrivalRandomMinField.setEditable(false);

        arrivalRandomMaxLabel = new JLabel("Max value");
        arrivalRandomMaxLabel .setAlignmentX(Component.CENTER_ALIGNMENT);
        arrivalRandomMaxLabel .setFont(new Font("Helvetica", Font.PLAIN, 10));
        arrivalRandomMaxLabel .setForeground(new Color(243, 245, 240));

        arrivalRandomMaxField = new JTextField(10);
        arrivalRandomMaxField.setMaximumSize(new Dimension(200, 30));
        arrivalRandomMaxField.setAlignmentX(Component.CENTER_ALIGNMENT);
        arrivalRandomMaxField.setEditable(false);
    }

    private void createBurstRandomOptionInputs() {
        burstRandomMinLabel = new JLabel("Min value");
        burstRandomMinLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        burstRandomMinLabel.setFont(new Font("Helvetica", Font.PLAIN, 10));
        burstRandomMinLabel.setForeground(new Color(243, 245, 240));

        burstRandomMinField = new JTextField(10);
        burstRandomMinField.setMaximumSize(new Dimension(200, 20));
        burstRandomMinField.setAlignmentX(Component.CENTER_ALIGNMENT);
        burstRandomMinField.setEditable(false);

        burstRandomMaxLabel = new JLabel("Max value");
        burstRandomMaxLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        burstRandomMaxLabel.setFont(new Font("Helvetica", Font.PLAIN, 10));
        burstRandomMaxLabel.setForeground(new Color(243, 245, 240));

        burstRandomMaxField = new JTextField(10);
        burstRandomMaxField.setMaximumSize(new Dimension(200, 20));
        burstRandomMaxField.setAlignmentX(Component.CENTER_ALIGNMENT);
        burstRandomMaxField.setEditable(false);
    }

    private void createBurstGaussOptionInputs() {
        meanLabel = new JLabel("Mean");
        meanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        meanLabel.setFont(new Font("Helvetica", Font.PLAIN, 10));
        meanLabel.setForeground(new Color(243, 245, 240));

        meanField = new JTextField(10);
        meanField.setMaximumSize(new Dimension(200, 20));
        meanField.setAlignmentX(Component.CENTER_ALIGNMENT);
        meanField.setEditable(false);

        stdDevLabel = new JLabel("Standard Deviation");
        stdDevLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        stdDevLabel.setFont(new Font("Helvetica", Font.PLAIN, 10));
        stdDevLabel.setForeground(new Color(243, 245, 240));

        stdDevField = new JTextField(10);
        stdDevField.setMaximumSize(new Dimension(200, 20));
        stdDevField.setAlignmentX(Component.CENTER_ALIGNMENT);
        stdDevField.setEditable(false);

        gaussMinLabel = new JLabel("Min value");
        gaussMinLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gaussMinLabel.setFont(new Font("Helvetica", Font.PLAIN, 10));
        gaussMinLabel.setForeground(new Color(243, 245, 240));

        gaussMinField = new JTextField(10);
        gaussMinField.setMaximumSize(new Dimension(200, 20));
        gaussMinField.setAlignmentX(Component.CENTER_ALIGNMENT);
        gaussMinField.setEditable(false);

        gaussMaxLabel = new JLabel("Max value");
        gaussMaxLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gaussMaxLabel.setFont(new Font("Helvetica", Font.PLAIN, 10));
        gaussMaxLabel.setForeground(new Color(243, 245, 240));

        gaussMaxField = new JTextField(10);
        gaussMaxField.setMaximumSize(new Dimension(200, 20));
        gaussMaxField.setAlignmentX(Component.CENTER_ALIGNMENT);
        gaussMaxField.setEditable(false);
    }

    private void createArrivalTimeLabel() {
        arrivalTimeLabel = new JLabel("Arrival time");
        arrivalTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        arrivalTimeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        arrivalTimeLabel.setForeground(new Color(243, 245, 240));
    }

    private void createArrivalTimeOptions() {
        arrivalOption1 = new JRadioButton("Increment");
        arrivalOption2 = new JRadioButton("Random");
        arrivalOption3 = new JRadioButton("Const");

        arrivalOption1.setAlignmentX(Component.CENTER_ALIGNMENT);
        arrivalOption2.setAlignmentX(Component.CENTER_ALIGNMENT);
        arrivalOption3.setAlignmentX(Component.CENTER_ALIGNMENT);

        arrivalOption1.setBackground(new Color(60, 65, 66));
        arrivalOption2.setBackground(new Color(60, 65, 66));
        arrivalOption3.setBackground(new Color(60, 65, 66));

        arrivalOption1.setForeground(new Color(243, 245, 240));
        arrivalOption2.setForeground(new Color(243, 245, 240));
        arrivalOption3.setForeground(new Color(243, 245, 240));

        arrivalGroup = new ButtonGroup();
        arrivalGroup.add(arrivalOption1);
        arrivalGroup.add(arrivalOption2);
        arrivalGroup.add(arrivalOption3);

        arrivalOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean enabled = arrivalOption2.isSelected();
                arrivalRandomMaxField.setEditable(enabled);
                arrivalRandomMinField.setEditable(enabled);
            }
        });

        arrivalOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean enabled = arrivalOption2.isSelected();
                arrivalRandomMaxField.setEditable(enabled);
                arrivalRandomMinField.setEditable(enabled);
            }
        });

        arrivalOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean enabled = arrivalOption2.isSelected();
                arrivalRandomMaxField.setEditable(enabled);
                arrivalRandomMinField.setEditable(enabled);
            }
        });

    }

    private void createAmountLabel() {
        amountLabel = new JLabel("Processes amount");
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        amountLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        amountLabel.setForeground(new Color(243, 245, 240));
    }

    private void createAmountField() {
        amountField = new JTextField(10);
        amountField.setMaximumSize(new Dimension(200, 20));
        amountField.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void createStartButton(){
        startButton = new JButton("Start");
        startButton.setVisible(true);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setFont(new Font("Helvetica", Font.BOLD, 15));
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

    private void createUpperPanel(){
        upperPanel = new JPanel();
        upperPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        upperPanel.setBackground(new Color(60, 65, 66));
        upperPanel.setPreferredSize(new Dimension(1200, 30));
        upperPanel.setMinimumSize(new Dimension(1200, 50));
        upperPanel.setMaximumSize(new Dimension(1200, 50));
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    }

    private void createSeriesAmountField(){
        seriesAmountField = new JTextField(10);
        seriesAmountField.setMaximumSize(new Dimension(200, 20));
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

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public JButton getStartButton(){
        return startButton;
    }

    private void addThings() {
        //this.add(goBackButton);

        upperPanel.add(goBackButton);
        upperPanel.add(startButton);
        this.add(upperPanel);
        this.add(amountLabel);
        this.add(amountField);
        this.add(arrivalTimeLabel);
        this.add(arrivalOption1);
        this.add(arrivalOption2);
        this.add(arrivalRandomMinLabel);
        this.add(arrivalRandomMinField);
        this.add(arrivalRandomMaxLabel);
        this.add(arrivalRandomMaxField);
        this.add(arrivalOption3);
        this.add(burstTimeLabel);
        this.add(burstOption1);
        this.add(burstRandomMinLabel);
        this.add(burstRandomMinField);
        this.add(burstRandomMaxLabel);
        this.add(burstRandomMaxField);
        this.add(burstOption2);
        this.add(meanLabel);
        this.add(meanField);
        this.add(stdDevLabel);
        this.add(stdDevField);
        this.add(gaussMinLabel);
        this.add(gaussMinField);
        this.add(gaussMaxLabel);
        this.add(gaussMaxField);
        this.add(singleButton);
        this.add(seriesButton);
        this.add(seriesAmountLabel);
        this.add(seriesAmountField);

        //this.add(startButton);
    }

    public void setThisVisible() {
        this.setVisible(true);
    }

    public void setThisInvisible() {
        this.setVisible(false);
    }

    public String getSelectedBurstOption() {
        if (burstOption1.isSelected()) {
            return "Option 1";
        } else if (burstOption2.isSelected()) {
            return "Option 2";
        }
        return "None";
    }

    public String getSelectedArrivalOption() {
        if (arrivalOption1.isSelected()) {
            return "Option 1";
        } else if (arrivalOption2.isSelected()) {
            return "Option 2";
        } else if (arrivalOption3.isSelected()) {
            return "Option 3";
        }
        return "None";
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

    public double getMean() {
        try {
            String text = meanField.getText().trim();
            if(Double.parseDouble(text) <= 0){
                JOptionPane.showMessageDialog(this, "Invalid input for Mean. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Mean. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return a default or error value.
        }
    }

    public double getStandardDeviation() {
        try {
            String text = stdDevField.getText().trim();
            if(Double.parseDouble(text) <= 0){
                JOptionPane.showMessageDialog(this, "Invalid input for Standard deviation. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Standard Deviation. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return a default or error value.
        }
    }

    public int getGaussMin() {
        try {
            String text = gaussMinField.getText().trim();
            if(Integer.parseInt(text) <= 0){
                JOptionPane.showMessageDialog(this, "Invalid input for Min value. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Min value. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return a default or error value.
        }
    }

    public int getGaussMax() {
        try {
            String text = gaussMaxField.getText().trim();
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

    public int getBurstRandomMin() {
        try {
            String text = burstRandomMinField.getText().trim();
            if(Integer.parseInt(text) <= 0){
                JOptionPane.showMessageDialog(this, "Invalid input for Min value. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Min value. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return a default or error value.
        }
    }

    public int getBurstRandomMax() {
        try {
            String text = burstRandomMaxField.getText().trim();
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

    public int getArrivalRandomMin() {
        try {
            String text = arrivalRandomMinField.getText().trim();
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

    public int getArrivalRandomMax() {
        try {
            String text = arrivalRandomMaxField.getText().trim();
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
            if(Integer.parseInt(text) <= 0){
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
