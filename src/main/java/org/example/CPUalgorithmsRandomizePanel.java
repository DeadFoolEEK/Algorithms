package org.example;

import javax.swing.*;
import java.awt.*;

public class CPUalgorithmsRandomizePanel extends JPanel {

    private Frame frame;
    private JButton goBackButton;
    private JLabel burstTimeLabel;
    private JLabel arrivalTimeLabel;
    private JLabel amountLabel;

    CPUalgorithmsRandomizePanel(Frame frame){
        this.frame = frame;
        this.setVisible(false);
        mainPanel();
        createGoBackButton();
        createAmountLabel();
        createArrivalTimeLabel();
        createBurstTimeLabel();
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

    private void createBurstTimeLabel(){
        burstTimeLabel = new JLabel("Burst time");
        burstTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        burstTimeLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        burstTimeLabel.setForeground(new Color(243, 245, 240));
    }

    private void createArrivalTimeLabel(){
        arrivalTimeLabel = new JLabel("Arrival time");
        arrivalTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        arrivalTimeLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        arrivalTimeLabel.setForeground(new Color(243, 245, 240));
    }

    private void createAmountLabel(){
        amountLabel = new JLabel("Processes amount");
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        amountLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        amountLabel.setForeground(new Color(243, 245, 240));
    }

    public JButton getGoBackButton(){
        return goBackButton;
    }

    private void addThings(){
        this.add(goBackButton);
        this.add(amountLabel);
        this.add(arrivalTimeLabel);
        this.add(burstTimeLabel);
    }

    public void setThisVisible(){
        this.setVisible(true);
    }

    public void setThisInvisible(){
        this.setVisible(false);
    }

}
