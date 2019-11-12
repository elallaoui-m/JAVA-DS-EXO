package com.java.elallaoui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Ex2_Info_Amis extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton infoButton;
    ArrayList<Ex2_User> listFriends;
    int selectedIndex;
    public  Ex2_Info_Amis(String name){
        super("Liste amis");
        setLayout(new FlowLayout());
    
        // initialize componnents
        JLabel titleLabel = new JLabel("Bonjour "+name);
        titleLabel.setPreferredSize(new Dimension(420,40));
        titleLabel.setFont(new Font("arial",Font.BOLD,16));
        infoButton = new JButton("Info");
    
        String[] titres = {"Nom","DT naissance"};
        DefaultTableModel tableModel = new DefaultTableModel(titres, 0);
    
        // get the data from the file auth.txt
        try {
            String ligne;
            LineNumberReader lnr = new LineNumberReader(new FileReader("ressources/info.txt"));
            listFriends = new ArrayList<>();
            try {
                while((ligne=lnr.readLine()) != null){
                    String[] tab_info = ligne.split("=");
                    Object[] obj = {tab_info[0], tab_info[1]};
                    listFriends.add(new Ex2_User(tab_info[0],tab_info[1]));
                    tableModel.addRow(obj);
                }
            }finally {
                lnr.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    
        JTable table_data = new JTable(tableModel);
        ListSelectionModel selectedModel = table_data.getSelectionModel();
        selectedModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectedModel.addListSelectionListener(e -> {
            int[] selectedRow = table_data.getSelectedRows();
            if (e.getValueIsAdjusting()==true)
                if (selectedRow.length==1) {
                    selectedIndex = selectedRow[0];
                }
        
        });
        
        
        // show info when click on info button
        ListenerButton handler = new ListenerButton(listFriends, selectedIndex);
        infoButton.addActionListener(handler);
    
        // ajouter la table au scrollPane et le dernier au frame
        JScrollPane sp = new JScrollPane(table_data);
        sp.setPreferredSize(new Dimension(420,200));
        add(titleLabel);
        add(sp);
        add(infoButton);
    
        // parametres d'affichage
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,340);
        setLocationRelativeTo(null);
    }    
    
    
}
