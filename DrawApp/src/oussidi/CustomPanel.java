package oussidi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class CustomPanel extends JPanel{
    
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    double angle=0;

    boolean goRight;

    
    public CustomPanel(){
        x1=100;
        y1=100;
        x2=200;
        y2=200;
        Timer t =new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rotate();

                repaint();
            }
        });
        t.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        float x = this.getWidth() / 2.0f;
        float y = this.getHeight() / 2.0f;
        ((Graphics2D) g).rotate(Math.toRadians(angle),x,y);

        g.drawLine(x1,y1,x2,y2);
        g.drawLine(x2,y2,x2+x1,y1);




    }



    void rotate()
    {
        
        if (goRight)
            angle-=Math.toRadians(40);
        else
            angle+=Math.toRadians(40);

        if (Math.toRadians(angle)<-Math.PI/4)
            goRight = false;
        else if (Math.toRadians(angle)>Math.PI/4)
            goRight = true;

    }




}
