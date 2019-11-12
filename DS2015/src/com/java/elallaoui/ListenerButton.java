package com.java.elallaoui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ListenerButton implements ActionListener {
	
	private ArrayList<Ex2_User> list;
	private int index;
	
	public ListenerButton(ArrayList<Ex2_User> list, int index) {
		this.list = list;
		this.index = index;
	}
	public long getDaysBirthday(String date) throws ParseException {
		  
	    SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date dateBirth = dateF.parse(date);  
	    LocalDateTime now = LocalDateTime.now();  
	    LocalDate localDate = dateBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    localDate = localDate.withYear(now.getYear());
	    System.out.println("after change :" +localDate);
	    if(localDate.isBefore(now.toLocalDate())) {
	    	localDate = localDate.plusYears(1);
	    }	    
	    return Math.abs(ChronoUnit.DAYS.between(localDate, now));
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Ex2_User user = list.get(index);
        String[] date_info = user.dateNaissance.split("/");
        
        try {
			JOptionPane.showMessageDialog(null,getDaysBirthday(user.dateNaissance));
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

}
