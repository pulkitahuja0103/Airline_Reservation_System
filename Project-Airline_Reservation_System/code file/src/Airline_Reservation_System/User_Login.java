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

public class User_Login {

	 JFrame frameUL;
	 private JTextField tfusername;
	 private JPasswordField pf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Login window = new User_Login();
					window.frameUL.setVisible(true);
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
	public User_Login() {
		connection = DataBaseConnectivity.dbconnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUL = new JFrame();
		frameUL.getContentPane().setBackground(new Color(0, 255, 255));
		frameUL.setBounds(100, 100, 833, 596);
		frameUL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUL.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(220, 207, 135, 39);
		frameUL.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(220, 287, 128, 39);
		frameUL.getContentPane().add(lblNewLabel_1);
		
		tfusername = new JTextField();
		tfusername.setBounds(383, 215, 120, 29);
		frameUL.getContentPane().add(tfusername);
		tfusername.setColumns(10);
		
		pf = new JPasswordField();
		pf.setBounds(383, 295, 120, 29);
		frameUL.getContentPane().add(pf);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					String query="select *from user_login_data where username=? and password=? ";
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
						
						User_dashboard udb=new User_dashboard();
						udb.frameudb.setVisible(true);
						frameUL.dispose();
						
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
				}
				
				
			}
		});
		btnNewButton.setBounds(237, 372, 118, 49);
		frameUL.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGN UP\r\n");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User_Signup usu=new User_Signup();
				usu.frameusignup.setVisible(true);
				frameUL.dispose();
				
			}
		});
		btnNewButton_1.setBounds(438, 372, 128, 49);
		frameUL.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Front_Page fp=new Front_Page();
				fp.frameFP.setVisible(true);
				frameUL.dispose();
			}
		});
		btnNewButton_2.setBounds(709, 21, 100, 49);
		frameUL.getContentPane().add(btnNewButton_2);
	}
}
