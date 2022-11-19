package oomP;

import javax.swing.JFrame;
import java.awt.*;

public class MyFrame extends JFrame{
    MyFrame() {
        this.setVisible(true);
        this.setSize(500,500);
        this.setTitle("Prototype App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(255,255,255));
    }
}
