package Airline_Reservation_System;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class User_Signup {

	 JFrame frameusignup;
	private JTextField tffirstname;
	private JTextField tflastname;
	private JTextField tfusername;
	private JPasswordField pf;
	private JButton btnback;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Signup window = new User_Signup();
					window.frameusignup.setVisible(true);
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
	
	public User_Signup() {
		connection=DataBaseConnectivity.dbconnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameusignup = new JFrame();
		frameusignup.getContentPane().setBackground(new Color(0, 255, 255));
		frameusignup.setBounds(100, 100, 874, 603);
		frameusignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameusignup.getContentPane().setLayout(null);
		
		JLabel L1 = new JLabel("FIRST NAME\r\n");
		L1.setFont(new Font("Tahoma", Font.BOLD, 17));
		L1.setBounds(192, 182, 135, 34);
		frameusignup.getContentPane().add(L1);
		
		tffirstname = new JTextField();
		tffirstname.setBounds(399, 191, 126, 24);
		frameusignup.getContentPane().add(tffirstname);
		tffirstname.setColumns(10);
		
		JLabel L2 = new JLabel("LAST NAME\r\n");
		L2.setFont(new Font("Tahoma", Font.BOLD, 17));
		L2.setBounds(192, 241, 135, 34);
		frameusignup.getContentPane().add(L2);
		
		tflastname = new JTextField();
		tflastname.setColumns(10);
		tflastname.setBounds(399, 250, 126, 24);
		frameusignup.getContentPane().add(tflastname);
		
		JLabel L3 = new JLabel("USERNAME\r\n");
		L3.setFont(new Font("Tahoma", Font.BOLD, 17));
		L3.setBounds(192, 298, 135, 41);
		frameusignup.getContentPane().add(L3);
		
		tfusername = new JTextField();
		tfusername.setColumns(10);
		tfusername.setBounds(399, 310, 126, 24);
		frameusignup.getContentPane().add(tfusername);
		
		JLabel L4 = new JLabel("PASSWORD");
		L4.setFont(new Font("Tahoma", Font.BOLD, 17));
		L4.setBounds(192, 349, 135, 34);
		frameusignup.getContentPane().add(L4);
		
		pf = new JPasswordField();
		pf.setBounds(399, 364, 126, 24);
		frameusignup.getContentPane().add(pf);
		
		JButton btnsave = new JButton("SAVE");
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="insert into user_login_data (firstname,lastname,username,password) values (?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,tffirstname.getText());
					pst.setString(2,tflastname.getText());
					pst.setString(3,tfusername.getText());
					pst.setString(4,pf.getText());
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA SAVED");
					
					pst.close(); 
					
					User_Login lp=new User_Login();
					lp.frameUL.setVisible(true);
					frameusignup.dispose();
					
					
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				
				}
				
			}
		});
		btnsave.setBounds(317, 425, 114, 48);
		frameusignup.getContentPane().add(btnsave);
		
		btnback = new JButton("BACK");
		btnback.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User_Login ul=new User_Login();
				ul.frameUL.setVisible(true);
				frameusignup.dispose();
				
			}
		});
		btnback.setBounds(756, 10, 94, 41);
		frameusignup.getContentPane().add(btnback);
	}

}
