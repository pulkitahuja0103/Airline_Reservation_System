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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Admin_Login {

	 JFrame frameAL;
	 private JTextField tfusername;
	 private JPasswordField pf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login window = new Admin_Login();
					window.frameAL.setVisible(true);
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
	private JButton btnNewButton_1;
	public Admin_Login() {
		connection=DataBaseConnectivity.dbconnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAL = new JFrame();
		frameAL.getContentPane().setBackground(new Color(0, 255, 255));
		frameAL.setBounds(100, 100, 976, 652);
		frameAL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAL.getContentPane().setLayout(null);
		
		JLabel L1 = new JLabel("USERNAME");
		L1.setFont(new Font("Tahoma", Font.BOLD, 18));
		L1.setBounds(275, 220, 157, 39);
		frameAL.getContentPane().add(L1);
		
		JLabel lblNewLabel = new JLabel("PASSWORD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(275, 308, 157, 39);
		frameAL.getContentPane().add(lblNewLabel);
		
		tfusername = new JTextField();
		tfusername.setBounds(467, 230, 135, 25);
		frameAL.getContentPane().add(tfusername);
		tfusername.setColumns(10);
		
		pf = new JPasswordField();
		pf.setBounds(467, 318, 135, 25);
		frameAL.getContentPane().add(pf);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	try {
					
					String query="select *from admin_login where username=? and password=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, tfusername.getText());
					pst.setString(2, pf.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					
					while(rs.next()) {
						count++;
					}
					
					if(count==1) {
						JOptionPane.showMessageDialog(null, "CORRECT");
						
						Admin_dashboard fd=new Admin_dashboard();
						fd.frameadb.setVisible(true);
						frameAL.dispose();
						
					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null, "DUPLICATE");
					}
					else {
						JOptionPane.showMessageDialog(null, "INCORRECT");
					}
					rs.close();
					pst.close();
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}}
				
		
				
			
		});
		btnNewButton.setBounds(394, 429, 93, 39);
		frameAL.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Front_Page fp=new Front_Page();
				fp.frameFP.setVisible(true);
				frameAL.dispose();
				
			}
		});
		btnNewButton_1.setBounds(831, 550, 93, 39);
		frameAL.getContentPane().add(btnNewButton_1);
	}
}
