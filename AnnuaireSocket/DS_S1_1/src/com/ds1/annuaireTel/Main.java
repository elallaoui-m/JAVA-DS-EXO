package com.ds1.annuaireTel;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Main {

	public static void main(String[] args) {
		
		
		try {
			LoginFrame demo = new LoginFrame();
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(demo);
			demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			demo.setSize(600, 300);
			demo.setResizable(false);
			demo.setVisible(true);
			}catch(Exception e) {
				e.printStackTrace();
			}

	}

}
