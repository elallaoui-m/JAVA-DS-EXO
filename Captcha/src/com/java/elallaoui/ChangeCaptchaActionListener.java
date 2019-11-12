package com.java.elallaoui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Action listener that changes the captcha in the lable
 */
public class ChangeCaptchaActionListener implements ActionListener {

    JLabel captcha;
    Timer timer;
    JTextField response;

    public ChangeCaptchaActionListener(JLabel captcha, Timer timer, JTextField response) {
        this.captcha = captcha;
        this.timer = timer;
        this.response = response;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Make the Response field editable
        response.setEditable(true);

        //pick a random key from the DATA label
        String[] keys = DATA.CaptchaData.keySet().toArray(new String[DATA.CaptchaData.size()]);
        String equation = keys[new Random().nextInt(keys.length)];
        captcha.setText(equation);
        if (timer != null)
            timer.restart();
    }
}
