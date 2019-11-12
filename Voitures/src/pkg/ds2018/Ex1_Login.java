package pkg.ds2018;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class Ex1_Login extends JFrame {
    JButton loginButton;
    JTextField loginInput;
    JPasswordField passwordInput;
    ArrayList<String> infoLogin;
    public Ex1_Login(){
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
    
        // add listener to login button
        loginButton.addActionListener(e->{
    
            Connection conn = DbConnection.getConnection();
            try
            {
                String query = "Select id_client from clients where login=? and password=?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1,loginInput.getText());
                st.setString(2,passwordInput.getText());
                ResultSet rst = st.executeQuery();
    
                int id_client = -1;
                while(rst.next())
                    id_client=rst.getInt(1);
        
                if (id_client==-1){
                    JOptionPane.showMessageDialog(this,"Login ou mot de passe Incorrect");
                    passwordInput.setText("");
                }else{
                   new LocationVoiture(id_client);
                   dispose();
                }
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }finally {
                try{
                    conn.close();
                }catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
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
        new Ex1_Login();
    }
}
