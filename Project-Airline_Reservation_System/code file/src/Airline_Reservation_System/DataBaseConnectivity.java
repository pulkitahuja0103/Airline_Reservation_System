package Airline_Reservation_System;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DataBaseConnectivity {

	 JFrame framedbc;

	/**
	 * Launch the application.
	 */
	 Connection connection=null;
	 public static Connection dbconnector() {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_reservation_system", "root" , "root");
				
				return con;
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
				return null;
	 }}
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataBaseConnectivity window = new DataBaseConnectivity();
					window.framedbc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataBaseConnectivity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framedbc = new JFrame();
		framedbc.setBounds(100, 100, 450, 300);
		framedbc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
