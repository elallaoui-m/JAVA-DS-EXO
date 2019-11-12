package com.ds1.annuaireTel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientPage extends JFrame{
	private DefaultTableModel model;
	private JTable table;
	public ClientPage(ArrayList<Annuaire> listClients) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setResizable(false);
		System.out.println("Client Page");
		setLayout(new FlowLayout());
		String[] columnNames = { "Nom", "Prenom", "Tel" };
		Object[][] data = {};
		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		model = (DefaultTableModel) table.getModel();
		table.setPreferredScrollableViewportSize(new Dimension(350, 120));
		table.setFillsViewportHeight(true);
		JScrollPane pane = new JScrollPane(table);
		for(int i=0 ; i<listClients.size();i++) {
			model.addRow(new Object[] { listClients.get(i).getNom(), listClients.get(i).getPrenom(),listClients.get(i).getTel()});
		}
		add(pane);
		
		
	}
}
