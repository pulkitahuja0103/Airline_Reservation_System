package Airline_Reservation_System;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Font;

public class add_customer {

	 JFrame frameac;
	 private JTextField tffn;
	 private JTextField tfln;
	 private JTextField tfpid;
	 private JTextArea address;
	 private JTextField tfdob;
	 private JRadioButton rb1=null;
	 private JRadioButton rb2=null;
	 private JRadioButton rb3=null;
	 private JTextField tfc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_customer window = new add_customer();
					window.frameac.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connection=null;
	public add_customer() {
		connection=DataBaseConnectivity.dbconnector();
		initialize();
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frameac = new JFrame();
		frameac.getContentPane().setBackground(new Color(202, 188, 181));
		frameac.setBounds(100, 100, 828, 609);
		frameac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameac.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("First Name");
		l1.setFont(new Font("Tahoma", Font.BOLD, 17));
		l1.setBounds(94, 143, 107, 30);
		frameac.getContentPane().add(l1);
		
		tffn = new JTextField();
		tffn.setBounds(211, 148, 103, 25);
		frameac.getContentPane().add(tffn);
		tffn.setColumns(10);
		
		JLabel l2 = new JLabel("Last Name");
		l2.setFont(new Font("Tahoma", Font.BOLD, 17));
		l2.setBounds(94, 187, 107, 30);
		frameac.getContentPane().add(l2);
		
		tfln = new JTextField();
		tfln.setColumns(10);
		tfln.setBounds(211, 192, 103, 25);
		frameac.getContentPane().add(tfln);
		
		JLabel l3 = new JLabel("Passport ID");
		l3.setFont(new Font("Tahoma", Font.BOLD, 17));
		l3.setBounds(94, 231, 107, 30);
		frameac.getContentPane().add(l3);
		
		tfpid = new JTextField();
		tfpid.setColumns(10);
		tfpid.setBounds(211, 236, 103, 25);
		frameac.getContentPane().add(tfpid);
		
		JLabel l4 = new JLabel("Address");
		l4.setFont(new Font("Tahoma", Font.BOLD, 17));
		l4.setBounds(94, 275, 107, 34);
		frameac.getContentPane().add(l4);
		
		final JTextArea address = new JTextArea();
		address.setBounds(211, 280, 173, 130);
		frameac.getContentPane().add(address);
		
		JLabel l7 = new JLabel("Contact");
		l7.setFont(new Font("Tahoma", Font.BOLD, 17));
		l7.setBounds(398, 236, 107, 34);
		frameac.getContentPane().add(l7);
		
		tfc = new JTextField();
		tfc.setColumns(10);
		tfc.setBounds(515, 241, 103, 25);
		frameac.getContentPane().add(tfc);
		
		JLabel l5 = new JLabel("DOB");
		l5.setFont(new Font("Tahoma", Font.BOLD, 17));
		l5.setBounds(398, 143, 107, 30);
		frameac.getContentPane().add(l5);
		
		JLabel l6 = new JLabel("Gender");
		l6.setFont(new Font("Tahoma", Font.BOLD, 17));
		l6.setBounds(398, 187, 107, 30);
		frameac.getContentPane().add(l6);
		
		tfdob = new JTextField();
		tfdob.setColumns(10);
		tfdob.setBounds(515, 151, 103, 25);
		frameac.getContentPane().add(tfdob);
		
		final JRadioButton rb1 = new JRadioButton("MALE");
		rb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rb1.isSelected()) {
					rb2.setSelected(false);
					rb3.setSelected(false);
				}
			}
		});
		rb1.setBounds(515, 194, 78, 21);
		frameac.getContentPane().add(rb1);
		
		final JRadioButton rb2 = new JRadioButton("FEMALE");
		rb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rb2.isSelected()) {
					rb1.setSelected(false);
					rb3.setSelected(false);
				}
			}
		});
		rb2.setBounds(606, 194, 78, 21);
		frameac.getContentPane().add(rb2);
		
		final JRadioButton rb3 = new JRadioButton("OTHER");
		rb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rb3.isSelected()) {
					rb1.setSelected(false);
					rb2.setSelected(false);
				}
				
			}
		});
		rb3.setBounds(704, 194, 78, 21);
		frameac.getContentPane().add(rb3);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="insert into customers (firstname,lastname,passportID,address,dob,gender,contact) values (?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,tffn.getText());
					pst.setString(2,tfln.getText());
					pst.setString(3,tfpid.getText());
					pst.setString(4,address.getText());
					pst.setString(5,tfdob.getText());
					
					if(rb1.isSelected()) {
						pst.setString(6,rb1.getText());
					}
					else if(rb2.isSelected()) {
						pst.setString(6,rb2.getText());
					}
					else if(rb3.isSelected()) {
						pst.setString(6,rb3.getText());
					}
					pst.setString(7,tfc.getText());
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA SAVED");
					
					pst.close(); 
					
					User_dashboard udb=new User_dashboard();
					udb.frameudb.setVisible(true);
					frameac.dispose();
					
					
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				
				}
				
			}
		});
		btnNewButton.setBounds(361, 460, 117, 43);
		frameac.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User_dashboard ud=new User_dashboard();
				ud.frameudb.setVisible(true);
				frameac.dispose();
				
				
			}
		});
		btnNewButton_1.setBounds(716, 519, 88, 43);
		frameac.getContentPane().add(btnNewButton_1);
	}
}
