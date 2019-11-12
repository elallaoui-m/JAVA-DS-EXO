package oussidi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomPanel extends JPanel{
    
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    public CustomPanel(){
        x1=100;
        y1=100;
        x2=200;
        y2=200;
        Timer t =new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ntf");
                rotate();
            }
        });
        t.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g.drawLine(x1,y1,x2,y2);
        g.drawLine(x2,y2,x2+x1,y1);
    }
    
    public void rotate() {
        Graphics2D g2 = (Graphics2D) getGraphics();
        g2.rotate(Math.toRadians(45));
        repaint();
    }
}
