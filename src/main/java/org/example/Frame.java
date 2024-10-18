package org.example;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private Menu menu;

    Frame(){
        this.setResizable(false);
        this.setSize(1200,700);
        this.setTitle("Algorithms");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new Menu();

        this.add(menu.getMainPanel());
        this.setVisible(true);
    }

}