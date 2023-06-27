package Airline_Reservation_System;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class add_flight {

	 JFrame frameaf;
	private JTextField tffn;
	private JTextField tfdate;
	private JTextField tfdt;
	private JTextField tfat;
	private JTextField tffc;
	private JComboBox cbs;
	private JComboBox cbd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_flight window = new add_flight();
					window.frameaf.setVisible(true);
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
	public add_flight() {
		connection=DataBaseConnectivity.dbconnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameaf = new JFrame();
		frameaf.getContentPane().setBackground(new Color(202, 188, 181));
		frameaf.setBounds(100, 100, 868, 602);
		frameaf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameaf.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("Flight Name");
		l1.setFont(new Font("Tahoma", Font.BOLD, 17));
		l1.setBounds(120, 73, 130, 34);
		frameaf.getContentPane().add(l1);
		
		tffn = new JTextField();
		tffn.setBounds(285, 82, 105, 24);
		frameaf.getContentPane().add(tffn);
		tffn.setColumns(10);
		
		JLabel l2 = new JLabel("Source");
		l2.setFont(new Font("Tahoma", Font.BOLD, 17));
		l2.setBounds(120, 157, 130, 34);
		frameaf.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("Departure");
		l3.setFont(new Font("Tahoma", Font.BOLD, 17));
		l3.setBounds(120, 247, 130, 34);
		frameaf.getContentPane().add(l3);
		
		JLabel l4 = new JLabel("Date");
		l4.setFont(new Font("Tahoma", Font.BOLD, 17));
		l4.setBounds(471, 78, 130, 29);
		frameaf.getContentPane().add(l4);
		
		tfdate = new JTextField();
		tfdate.setColumns(10);
		tfdate.setBounds(636, 84, 105, 24);
		frameaf.getContentPane().add(tfdate);
		
		JLabel l5 = new JLabel("Dep. Time");
		l5.setFont(new Font("Tahoma", Font.BOLD, 17));
		l5.setBounds(471, 157, 130, 34);
		frameaf.getContentPane().add(l5);
		
		tfdt = new JTextField();
		tfdt.setColumns(10);
		tfdt.setBounds(636, 166, 105, 24);
		frameaf.getContentPane().add(tfdt);
		
		JLabel l6 = new JLabel("Arr Time");
		l6.setFont(new Font("Tahoma", Font.BOLD, 17));
		l6.setBounds(471, 247, 130, 34);
		frameaf.getContentPane().add(l6);
		
		tfat = new JTextField();
		tfat.setColumns(10);
		tfat.setBounds(636, 256, 105, 24);
		frameaf.getContentPane().add(tfat);
		
		JLabel l7 = new JLabel("Flight Charge");
		l7.setFont(new Font("Tahoma", Font.BOLD, 17));
		l7.setBounds(471, 341, 130, 34);
		frameaf.getContentPane().add(l7);
		
		tffc = new JTextField();
		tffc.setColumns(10);
		tffc.setBounds(636, 350, 105, 24);
		frameaf.getContentPane().add(tffc);
		
		final JComboBox cbs = new JComboBox();
		cbs.setModel(new DefaultComboBoxModel(new String[] {"India", "SriLanka", "UK", "USA", "Canada", "China"}));
		cbs.setBounds(285, 165, 105, 25);
		frameaf.getContentPane().add(cbs);
		
		final JComboBox cbd = new JComboBox();
		cbd.setModel(new DefaultComboBoxModel(new String[] {"India", "SriLanka", "UK", "USA", "Canada", "China"}));
		cbd.setBounds(285, 255, 105, 25);
		frameaf.getContentPane().add(cbd);
		
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="insert into flight (flightname,source,departure,date,dep_time,arr_time,charge) values (?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,tffn.getText());
					pst.setString(2,(String)cbs.getSelectedItem());
					pst.setString(3,(String)cbd.getSelectedItem());
					pst.setString(4,tfdate.getText());
					pst.setString(5,tfdt.getText());
					pst.setString(6,tfat.getText());
					pst.setString(7,tffc.getText());
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "FLIGHT ADDED");
					
					pst.close(); 
					add_flight af=new add_flight();
					af.frameaf.setVisible(true);
					frameaf.dispose();
					
					
					
					
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				
				}
				
				
			}
		});
		btnNewButton.setBounds(331, 471, 105, 37);
		frameaf.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_dashboard adb= new Admin_dashboard();
				adb.frameadb.setVisible(true);
				frameaf.dispose();
			}
		});
		btnNewButton_1.setBounds(470, 471, 105, 37);
		frameaf.getContentPane().add(btnNewButton_1);
		
		
	}
}
