package com.java.elallaoui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainCaptchaWindow extends JFrame {

    private JButton go;
    private JButton verifier;
    private JTextField response;
    private JLabel captcha;
    private Timer timer;

    public MainCaptchaWindow()
    {
        setTitle("Captcha");
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        /**
         * Using a personalied layout MiGLayout
         * http://www.miglayout.com/
         * http://www.migcalendar.com/miglayout/versions/4.0/
         */
        MigLayout Mig = new MigLayout();
        setLayout(Mig);

        //Initialize compements
        go = new JButton("Go");
        verifier = new JButton("Verifier");
        response = new JTextField(20);
        captcha = new JLabel("Captcha");

        //initialise the label with the first captcha
        String[] keys = DATA.CaptchaData.keySet().toArray(new String[DATA.CaptchaData.size()]);
        String equation = keys[new Random().nextInt(keys.length)];
        captcha.setText(equation);


        //Organise compement inside frame
        add(go,"cell 3 0");
        add(captcha,"cell 0 1");
        add(response,"cell 1 1 3 1");
        add(verifier , "cell 5 1");


        //Initialise timer
        timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                response.setEditable(false);
            }
        });
        timer.start();

        //add action listener to go button
        go.addActionListener(new ChangeCaptchaActionListener(captcha,timer,response));

        //add verification listener
        verifier.addActionListener(new VerifyCaptcha(captcha,response));

        //pack and setVisible to true
        pack();
        setVisible(true);
    }



    public static void main(String[] args) {

        MainCaptchaWindow mainCaptchaWindow = new MainCaptchaWindow();
    }
}


