package com.java.elallaoui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Ex1ClavierSecurise extends JFrame {
    JButton[] buttons = new JButton[10];
    JButton reset;
    JButton ok;
    public Ex1ClavierSecurise(){
        super("Clavier Mot de passe");
        setLayout(new FlowLayout());
        JPanel p1 = new JPanel(new GridLayout(4,3));
        JPanel p2 = new JPanel(new GridLayout(2,1));
        Font font =new Font("arial",Font.BOLD,20);
        
        // init components
        reset = new JButton("Reset");
        reset.setPreferredSize(new Dimension(160,120));
        reset.setFont(font);
        ok = new JButton("Ok");
        ok.setPreferredSize(new Dimension(160,120));
        ok.setFont(font);
        
        for (int i=0;i<buttons.length;i++){
            buttons[i] = new JButton(""+i);
            buttons[i].setPreferredSize(new Dimension(100,60));
            buttons[i].setFont(font);
            if (i==buttons.length-1){
                p1.add(new JLabel(" "));
            }
            p1.add(buttons[i]);
        }
    
        p2.add(ok);
        p2.add(reset);
        
        // add event listener
        reset.addActionListener(e->{
            redistrubierButtons();
        });
        
        // add components to window
        add(p1);
        add(p2);
    
        // for 30 sec refresh
        Timer timer = new Timer(30000, (ActionEvent e) -> redistrubierButtons());
        timer.start();
        
        // parametres d'affichage
        setSize(500,320);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    
    private void redistrubierButtons(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        int nb_rand = rand.nextInt(10);

        for(int i=0;i<buttons.length;i++){
            buttons[i].setText(""+randUniqueInt(list,nb_rand));
        }
    }
    public int randUniqueInt(ArrayList list,int nb){
        Random rand = new Random();
        int new_nb_rand = rand.nextInt(10);
        if (!list.contains(nb)){
            list.add(nb);
            return nb;
        }else {
            return randUniqueInt(list,new_nb_rand);
        }
    }
    
    public static void main(String[] args) {
        new Ex1ClavierSecurise();
    }
}
