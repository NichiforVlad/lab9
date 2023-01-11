package pb9;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Problema9());
        setVisible(true);
    }
}
