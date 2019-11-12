package com.ds1.annuaireTel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class LoginFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Socket socket ;
	private int port = 9000;
	private JButton loginBtn, cancel;
	private JTextField login;
	private JPasswordField password;
	private JLabel loginLabel , pwdLabel;
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public LoginFrame() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 10, 10, 0);
		
		loginLabel = new JLabel("Login");
		c.fill = GridBagConstraints.HORIZONTAL;	
		c.gridx = 0;
		c.gridy = 0;
		add(loginLabel,c);
		login = new JTextField(15);
		c.fill = GridBagConstraints.HORIZONTAL;	
		c.gridx = 1;
		c.gridy = 0;
		add(login,c);
		pwdLabel = new JLabel("Password");
		c.fill = GridBagConstraints.HORIZONTAL;	
		c.gridx = 0;
		c.gridy = 1;
		add(pwdLabel,c);
		password = new JPasswordField(15);
		c.fill = GridBagConstraints.HORIZONTAL;	
		c.gridx = 1;
		c.gridy = 1;
		add(password,c);
		loginBtn =  new JButton("ok");
		c.fill = GridBagConstraints.HORIZONTAL;	
		c.gridx = 0;
		c.gridy = 2;
		add(loginBtn,c);
		cancel =  new JButton("cancel");
		c.fill = GridBagConstraints.HORIZONTAL;	
		c.gridx = 1;
		c.gridy = 2;
		add(cancel,c);
		//listeners
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Annuaire client = new Annuaire(login.getText(), password.getText());
				try {
					socket = new Socket(InetAddress.getLocalHost(),port);
					System.out.println("client connected to the server");
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(client);
					System.out.println("object sent");
					//if the infos are correct he will receive the clients object from the server
					ois = new ObjectInputStream(socket.getInputStream());
					@SuppressWarnings("unchecked")
					ArrayList<Annuaire> readObject = (ArrayList<Annuaire>) ois.readObject();
					System.out.println(readObject.get(0));
					if(readObject != null) {
						System.out.println("We read this objjjjjj  "+readObject.get(0).getLogin());
						ClientPage page = new ClientPage(readObject);
						setVisible(false);
						setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						
					}
					else {
						JOptionPane.showMessageDialog(LoginFrame.this, "wrong Input","Error",JOptionPane.WARNING_MESSAGE);
					}
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		try {
			boolean b = Singleton.getDbCon().testLogin("client1", "1234");
			System.out.println("test ???? "+b);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
