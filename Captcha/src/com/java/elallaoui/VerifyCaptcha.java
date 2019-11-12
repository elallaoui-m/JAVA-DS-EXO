package com.java.elallaoui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/**
 * Class that verifies captcha from the captcha hashMap in DATA
 */
public class VerifyCaptcha implements ActionListener {

    JLabel captcha;
    JTextField response;

    public VerifyCaptcha(JLabel captcha, JTextField response) {
        this.captcha = captcha;
        this.response = response;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String expression = captcha.getText();

        if (!expression.isEmpty())
        {
            double resp = Double.parseDouble(response.getText());
            if (resp == DATA.CaptchaData.get(expression))
            {
                //if answer is right show message and change captcha
                JOptionPane.showMessageDialog(null,"Verified");
                String[] keys = DATA.CaptchaData.keySet().toArray(new String[DATA.CaptchaData.size()]);
                String equation = keys[new Random().nextInt(keys.length)];
                captcha.setText(equation);
            }
            else
            {
                //if wrong answer show feedback
                JOptionPane.showMessageDialog(null,"Wrong Captcha Answer");
            }
        }

    }
}
