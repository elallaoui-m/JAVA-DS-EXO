package oussidi;

import javax.swing.*;
import java.awt.*;

public class DrawWindow extends JFrame {
    public DrawWindow() {
        super("Thread+Rotation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        CustomPanel panel =new CustomPanel();
        getContentPane().add(panel);
        setSize(400,400);
        setVisible(true);


    }
}
