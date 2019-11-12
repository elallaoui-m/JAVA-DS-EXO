package com.java.elallaoui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Ex2_Login extends JFrame {
    JButton loginButton;
    JTextField loginInput;
    JPasswordField passwordInput;
    ArrayList<String> infoLogin;
    public Ex2_Login(){
        super("Authentification");
        setLayout(new FlowLayout());
        // initialize componnents
        JLabel titleLabel = new JLabel("Authentification");
        titleLabel.setPreferredSize(new Dimension(420,80));
        titleLabel.setFont(new Font("arial",Font.BOLD,20));
        JLabel loginLabel = new JLabel("Login :");
        loginLabel.setPreferredSize(new Dimension(100,40));
        JLabel passwordLabel = new JLabel("Mot de passe :");
        passwordLabel.setPreferredSize(new Dimension(100,40));
    
        loginButton = new JButton("Valider");
        loginInput = new JTextField();
        loginInput.setPreferredSize(new Dimension(300,40));
        passwordInput = new JPasswordField();
        passwordInput.setPreferredSize(new Dimension(300,40));
        
        // get the data from the file auth.txt
        try {
            String ligne;
            LineNumberReader lnr = new LineNumberReader(new FileReader("ressources/auth.txt"));
            infoLogin = new ArrayList<>();
            try {
                while((ligne=lnr.readLine()) != null){
                    infoLogin.add(ligne);
                }
            }finally {
                lnr.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    
        // add listener to login button
        loginButton.addActionListener(e->{
           if (loginInput.getText().equals(infoLogin.get(0)) && passwordInput.getText().equals(infoLogin.get(1))){
                new Ex2_Info_Amis(loginInput.getText());
                dispose();
           }else{
                JOptionPane.showMessageDialog(this,"Login ou mot de passe Incorrect");
                passwordInput.setText("");
            }
        });
        
        //add componnents to window
        add(titleLabel);
        add(loginLabel);
        add(loginInput);
        add(passwordLabel);
        add(passwordInput);
        add(loginButton);
        
        // parametres d'affichage
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,320);
        setLocationRelativeTo(null);

    }
    
    public static void main(String[] args) {
        new Ex2_Login();
    }
}
