package Airline_Reservation_System;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class search_customer {

	 JFrame framesc;
	private JTextField tffn;
	private JTextField tfln;
	private JTextField tfpID;
	private JTextField tfdob;
	private JTextField tfc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_customer window = new search_customer();
					window.framesc.setVisible(true);
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
	private JTextField tfgender;
	public search_customer() {
		connection=DataBaseConnectivity.dbconnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void refresh() {
		try {
			
			String query="select *from add_customer ";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery(); 
			pst.close();
			rs.close();
			
		}
		
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
	}
	
	
	private void initialize() {
		framesc = new JFrame();
		framesc.getContentPane().setBackground(new Color(202, 188, 181));
		framesc.setBounds(100, 100, 922, 615);
		framesc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framesc.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("First Name");
		l1.setFont(new Font("Tahoma", Font.BOLD, 17));
		l1.setBounds(106, 202, 104, 30);
		framesc.getContentPane().add(l1);
		
		tffn = new JTextField();
		tffn.setColumns(10);
		tffn.setBounds(220, 208, 103, 25);
		framesc.getContentPane().add(tffn);
		
		JLabel l2 = new JLabel("Last Name");
		l2.setFont(new Font("Tahoma", Font.BOLD, 17));
		l2.setBounds(106, 246, 104, 30);
		framesc.getContentPane().add(l2);
		
		tfln = new JTextField();
		tfln.setColumns(10);
		tfln.setBounds(220, 251, 103, 25);
		framesc.getContentPane().add(tfln);
		
		JLabel l3 = new JLabel("Passport ID");
		l3.setFont(new Font("Tahoma", Font.BOLD, 17));
		l3.setBounds(106, 52, 104, 41);
		framesc.getContentPane().add(l3);
		
		tfpID = new JTextField();
		tfpID.setColumns(10);
		tfpID.setBounds(220, 63, 103, 25);
		framesc.getContentPane().add(tfpID);
		
		JLabel l4 = new JLabel("Address");
		l4.setFont(new Font("Tahoma", Font.BOLD, 17));
		l4.setBounds(106, 302, 107, 30);
		framesc.getContentPane().add(l4);
		
		final JTextArea address = new JTextArea();
		address.setBounds(220, 308, 173, 130);
		framesc.getContentPane().add(address);
		
		JLabel l5 = new JLabel("DOB");
		l5.setFont(new Font("Tahoma", Font.BOLD, 17));
		l5.setBounds(410, 202, 104, 30);
		framesc.getContentPane().add(l5);
		
		tfdob = new JTextField();
		tfdob.setColumns(10);
		tfdob.setBounds(524, 210, 103, 25);
		framesc.getContentPane().add(tfdob);
		
		JLabel l6 = new JLabel("Gender");
		l6.setFont(new Font("Tahoma", Font.BOLD, 17));
		l6.setBounds(410, 246, 96, 30);
		framesc.getContentPane().add(l6);
		
		JLabel l7 = new JLabel("Contact");
		l7.setFont(new Font("Tahoma", Font.BOLD, 17));
		l7.setBounds(410, 334, 96, 30);
		framesc.getContentPane().add(l7);
		
		tfc = new JTextField();
		tfc.setColumns(10);
		tfc.setBounds(524, 340, 103, 25);
		framesc.getContentPane().add(tfc);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query="select*from customers where passportID=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, tfpID.getText());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						tffn.setText(rs.getString("firstname"));
						tfln.setText(rs.getString("lastname"));
						address.setText(rs.getString("address"));
						tfdob.setText(rs.getString("dob"));
						tfgender.setText(rs.getString("gender"));
						tfc.setText(rs.getString("contact"));
					}
					rs.close();
					pst.close();
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton.setBounds(395, 38, 117, 41);
		framesc.getContentPane().add(btnNewButton);
		
		tfgender = new JTextField();
		tfgender.setBounds(523, 250, 104, 25);
		framesc.getContentPane().add(tfgender);
		tfgender.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="update customers set firstname='"+tffn.getText()+"', lastname='"+tfln.getText()+"' ,address='"+address.getText()+"', dob='"+tfdob.getText()+"', gender='"+tfgender.getText()+"', contact='"+tfc.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);		
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					search_customer sc=new search_customer();
					sc.framesc.setVisible(true);
					framesc.dispose();
					
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton_1.setBounds(562, 38, 117, 41);
		framesc.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User_dashboard ud=new User_dashboard();
				ud.frameudb.setVisible(true);
				framesc.dispose();
				
			}
		});
		btnNewButton_2.setBounds(802, 527, 96, 41);
		framesc.getContentPane().add(btnNewButton_2);
	}
}
