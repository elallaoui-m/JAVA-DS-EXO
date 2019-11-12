package pkg.ds2018;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class LocationVoiture extends JFrame {
    JButton ajouterVoiture;
    JButton saveCommand;
    JTextField nomInput;
    JTextField voitureInput;
    JTextField dateDebutInput;
    JTextField dateFinInput;
    ArrayList<Voiture> listVoitures;
    int selectedIndex;
    int id_client;
    DefaultListModel model;
    Connection con = DbConnection.getConnection();
    
    public LocationVoiture(int id_client){
        super("Agence De location");
        setLayout(new FlowLayout());
        this.id_client=id_client;
        
        // initialize componnents
        JLabel titleLabel = new JLabel("Liste des voitures");
        titleLabel.setPreferredSize(new Dimension(360,40));
        titleLabel.setFont(new Font("arial",Font.BOLD,16));
        JLabel nomLabel = new JLabel("Nom : ");
        nomLabel.setPreferredSize(new Dimension(100,30));
        JLabel voitureLabel = new JLabel("Voiture : ");
        voitureLabel.setPreferredSize(new Dimension(100,30));
        JLabel dateDebutLabel = new JLabel("Date Debut : ");
        dateDebutLabel.setPreferredSize(new Dimension(100,30));
        JLabel dateFinLabel = new JLabel("Date Fin : ");
        dateFinLabel.setPreferredSize(new Dimension(100,30));
        nomInput = new JTextField();
        nomInput.setPreferredSize(new Dimension(260,30));
        voitureInput = new JTextField();
        voitureInput.setPreferredSize(new Dimension(260,30));
        dateDebutInput = new JTextField();
        dateDebutInput.setPreferredSize(new Dimension(260,30));
        dateFinInput = new JTextField();
        dateFinInput.setPreferredSize(new Dimension(260,30));
        listVoitures = new ArrayList<>();
        ajouterVoiture = new JButton("+");
        saveCommand = new JButton("Enregistrer");
        model = new DefaultListModel();
        
        // load voitures data
        load_voitures_data();
        
        // load client data
        load_client_data();
        
        // ajouter la table au scrollPane et le dernier au frame
        JList list_data = new JList(model);
        list_data.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int month = Calendar.getInstance().get(Calendar.MONTH)+1;
                int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                int year = Calendar.getInstance().get(Calendar.YEAR);
                String dayString = day>10 ? ""+day:"0"+day;
                String monthString = month>10 ? ""+month:"0"+month;
                
                selectedIndex = list_data.getSelectedIndex();
                voitureInput.setText(listVoitures.get(selectedIndex).designation);
                dateDebutInput.setText(dayString+"/"+monthString+"/"+year);
                dateFinInput.setText(dayString+"/"+monthString+"/"+year);
            }
        });
        JScrollPane sp = new JScrollPane(list_data);
        sp.setPreferredSize(new Dimension(360,150));
        add(titleLabel);
        add(sp);
        add(nomLabel);
        add(nomInput);
        add(voitureLabel);
        add(voitureInput);
        add(dateDebutLabel);
        add(dateDebutInput);
        add(dateFinLabel);
        add(dateFinInput);
        add(ajouterVoiture);
        add(saveCommand);
        
        // parametres d'affichage
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400,440);
        setLocationRelativeTo(null);
    }
    
    private void load_voitures_data() {
        try
        {
            String query = "Select * from voitures";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
        
            while(rs.next()){
                model.addElement(rs.getString(2)+" \t " +rs.getString(5)+"DH");
                listVoitures.add(new Voiture(rs.getString(2),rs.getString(3),rs.getDouble(5),rs.getString(4)));
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void load_client_data(){
        try
        {
            String query = "Select * from clients where id_client=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1,id_client);
            ResultSet rst = st.executeQuery();
        
            while(rst.next()){
                nomInput.setText(rst.getString(2)+" "+rst.getString(3));
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
