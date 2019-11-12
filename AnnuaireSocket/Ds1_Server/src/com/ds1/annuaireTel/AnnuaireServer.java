package com.ds1.annuaireTel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnnuaireServer extends Thread {
	private int port;
	private ServerSocket server;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private boolean isValid = false;
	private ArrayList<Annuaire> listeClients;

	public AnnuaireServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			Socket client;
			Annuaire annuaire = new Annuaire();
			server = new ServerSocket(port);
			System.out.println("Waiting for clients");
			client = server.accept();
			System.out.println("Server : A client was connected!!!!");
			ois = new ObjectInputStream(client.getInputStream());
			annuaire = (Annuaire) ois.readObject();
			System.out.println("Server : login " + annuaire.getLogin());
			isValid = Singleton.getDbCon().testLogin(annuaire.getLogin(), annuaire.getPassword());
			oos = new ObjectOutputStream(client.getOutputStream());
			if (isValid) {
				listeClients = Singleton.getDbCon().getAllClients();
				oos.writeObject(listeClients);
				System.out.println("server : liste des clients envoyes" + listeClients.get(0).getNom());
				oos.close();
				ois.close();
				client.close();
			} else {
				System.out.println("Nothind to send from the server");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
