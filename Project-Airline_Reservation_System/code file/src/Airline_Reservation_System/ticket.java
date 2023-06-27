package Airline_Reservation_System;

import java.awt.Color;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;

public class ticket {

	public JFrame framet;
	public static JTable table;
	public static 	JTextField tf_c_pid;
	public static  	JTextField tf_first_name;
	public static   JTextField tf_last_name;
	public static   JTextField tf_contact;
	public static   JTextField tf_flight_name;
	public static   JTextField tf_dept_time;
	public static   JTextField tf_date;
	public static   JTextField tf_price;
	public static  	JComboBox cb1;
	public static  	JComboBox cb2;
	public static  	JComboBox cb_class;
	public static  	JSpinner txtseats ;
	public static  	JLabel txttotal;
	
	
	public static 	String Source;
	public static 	String Departure;
	public static 	String Set_class;
	public static 	String number_of_seats;
	public static 	String total_price;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticket window = new ticket();
					window.framet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	
	
	
	
	public ticket() {
		connection=DataBaseConnectivity.dbconnector();
		initialize();
	}

	
	private void initialize() {
		framet = new JFrame();
		framet.getContentPane().setBackground(new Color(202, 188, 181));
		framet.setBounds(100, 100, 1006, 673);
		framet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framet.getContentPane().setLayout(null);
		
		 final JComboBox cb1 = new JComboBox();
		 cb1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	Source=cb1.getSelectedItem().toString();
		 	}
		 	
		 });
		cb1.setModel(new DefaultComboBoxModel(new String[] {"", "India", "SriLanka", "UK", "USA", "Canada", "China"}));
		cb1.setBounds(43, 78, 115, 21);
		framet.getContentPane().add(cb1);
		
		final JComboBox cb2 = new JComboBox();
		cb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departure=cb2.getSelectedItem().toString();
			}
		});
		cb2.setModel(new DefaultComboBoxModel(new String[] {"", "India", "SriLanka", "UK", "USA", "Canada", "China"}));
		cb2.setBounds(189, 78, 115, 21);
		framet.getContentPane().add(cb2);
		
		JLabel lblNewLabel = new JLabel("SOURCE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(61, 51, 83, 17);
		framet.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DEPARTURE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(189, 51, 119, 17);
		framet.getContentPane().add(lblNewLabel_1);
		
		JScrollPane tb1 = new JScrollPane();
		tb1.setBounds(43, 167, 457, 318);
		framet.getContentPane().add(tb1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					int row=table.getSelectedRow();
					String flight_name=(table.getModel().getValueAt(row, 0)).toString();
					
					String query="select*from flight where flightname= '"+flight_name+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						tf_flight_name.setText(rs.getString("flightname"));
						
						tf_dept_time.setText(rs.getString("dep_time"));
						
						tf_date.setText(rs.getString("date"));
						
						tf_price.setText(rs.getString("charge"));
					}
					pst.close();
					rs.close();
					
				}catch(Exception e4) {
					JOptionPane.showMessageDialog(null, e4);
				}
			}
		});
		tb1.setViewportView(table);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 
					String selection1=(String)cb1.getSelectedItem();
		 			String selection2=(String)cb2.getSelectedItem();
					
					String query="select*from flight where source=? and departure =? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, selection1);
					pst.setString(2, selection2);
					
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					
				}catch(Exception e4) {
					JOptionPane.showMessageDialog(null, e4);
				}
				
			}
		});
		btnNewButton.setBounds(245, 118, 106, 36);
		framet.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Passport ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(545, 33, 207, 31);
		framet.getContentPane().add(lblNewLabel_2);
		
		tf_c_pid = new JTextField();
		tf_c_pid.setBounds(762, 41, 115, 21);
		framet.getContentPane().add(tf_c_pid);
		tf_c_pid.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("First Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(545, 70, 187, 31);
		framet.getContentPane().add(lblNewLabel_2_1);
		
		tf_first_name = new JTextField();
		tf_first_name.setColumns(10);
		tf_first_name.setBounds(762, 78, 115, 21);
		framet.getContentPane().add(tf_first_name);
		
		JLabel lblNewLabel_2_2 = new JLabel("Last Name");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(545, 111, 187, 31);
		framet.getContentPane().add(lblNewLabel_2_2);
		
		tf_last_name = new JTextField();
		tf_last_name.setColumns(10);
		tf_last_name.setBounds(762, 118, 115, 21);
		framet.getContentPane().add(tf_last_name);
		
		JLabel lblNewLabel_2_3 = new JLabel("Contact");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_3.setBounds(545, 157, 187, 31);
		framet.getContentPane().add(lblNewLabel_2_3);
		
		tf_contact = new JTextField();
		tf_contact.setColumns(10);
		tf_contact.setBounds(762, 165, 115, 21);
		framet.getContentPane().add(tf_contact);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				 
		 			
					String selection1=(String)tf_c_pid.getText();
					String query="select*from customers where passportID=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, selection1);
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()== false) {
						JOptionPane.showMessageDialog(null, "NOT FOUND");
					}
					else {
						String fname=rs.getString("firstname");
						String lname=rs.getString("lastname");
						String contact=rs.getString("contact");
						
						tf_first_name.setText(fname);
						tf_last_name.setText(lname);
						tf_contact.setText(contact);
						
					}
					
					
					
					pst.close();
					rs.close();
					
				}catch(Exception e4) {
					JOptionPane.showMessageDialog(null, e4);
				}
				
				
			}
		});
		btnNewButton_1.setBounds(887, 78, 95, 36);
		framet.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Flight Name");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_3_1.setBounds(545, 231, 187, 31);
		framet.getContentPane().add(lblNewLabel_2_3_1);
		
		tf_flight_name = new JTextField();
		tf_flight_name.setColumns(10);
		tf_flight_name.setBounds(762, 244, 115, 21);
		framet.getContentPane().add(tf_flight_name);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Dept. Time");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_3_2.setBounds(545, 272, 187, 31);
		framet.getContentPane().add(lblNewLabel_2_3_2);
		
		tf_dept_time = new JTextField();
		tf_dept_time.setColumns(10);
		tf_dept_time.setBounds(762, 282, 115, 21);
		framet.getContentPane().add(tf_dept_time);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("Date");
		lblNewLabel_2_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_3_2_1.setBounds(545, 313, 181, 31);
		framet.getContentPane().add(lblNewLabel_2_3_2_1);
		
		tf_date = new JTextField();
		tf_date.setColumns(10);
		tf_date.setBounds(762, 321, 115, 21);
		framet.getContentPane().add(tf_date);
		
		JLabel lblNewLabel_2_3_2_1_1 = new JLabel("Class");
		lblNewLabel_2_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_3_2_1_1.setBounds(545, 344, 187, 31);
		framet.getContentPane().add(lblNewLabel_2_3_2_1_1);
		
		final JComboBox cb_class = new JComboBox();
		cb_class.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Set_class=cb_class.getSelectedItem().toString();
				
			}
		});
		cb_class.setModel(new DefaultComboBoxModel(new String[] {"", "Economy", "Business"}));
		cb_class.setBounds(762, 352, 115, 21);
		framet.getContentPane().add(cb_class);
		
		JLabel lblNewLabel_2_3_2_1_2 = new JLabel("Price");
		lblNewLabel_2_3_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_3_2_1_2.setBounds(545, 380, 181, 31);
		framet.getContentPane().add(lblNewLabel_2_3_2_1_2);
		
		tf_price = new JTextField();
		tf_price.setColumns(10);
		tf_price.setBounds(762, 388, 115, 21);
		framet.getContentPane().add(tf_price);
		
		final JLabel txttotal = new JLabel("Total Price");
		txttotal.setFont(new Font("Tahoma", Font.BOLD, 17));
		txttotal.setBounds(271, 528, 101, 60);
		framet.getContentPane().add(txttotal);
		
		JLabel lblNewLabel_2_3_2_1_2_1 = new JLabel("seats");
		lblNewLabel_2_3_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_3_2_1_2_1.setBounds(545, 421, 181, 31);
		framet.getContentPane().add(lblNewLabel_2_3_2_1_2_1);
		
		final JSpinner txtseats = new JSpinner();
		txtseats.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				
				number_of_seats=txtseats.getValue().toString();
				int price=Integer.parseInt(tf_price.getText());
				int qty=Integer.parseInt(txtseats.getValue().toString());
				int total=price*qty;
				total_price=Integer.toString(total);
				
				
				txttotal.setText(String.valueOf(total));
				
			}
		});
		txtseats.setBounds(762, 442, 30, 20);
		framet.getContentPane().add(txtseats);
		
		JButton btnNewButton_2 = new JButton("BOOK");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="insert into tickets (cust_passport_id,first_name,last_name,contact,flight_name,source,departure,dep_time,date,class,seats,total_fair) values (?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,tf_c_pid.getText());
					pst.setString(2,tf_first_name.getText());
					pst.setString(3,tf_last_name.getText());
					pst.setString(4,tf_contact.getText());
					pst.setString(5,tf_flight_name.getText());
					pst.setString(6,(String)cb1.getSelectedItem());
					pst.setString(7,(String)cb2.getSelectedItem());
					
					pst.setString(8,tf_dept_time.getText());
					pst.setString(9,tf_date.getText());
					pst.setString(10,(String)cb_class.getSelectedItem());
					pst.setString(11,txtseats.getValue().toString());
					pst.setString(12,txttotal.getText());
					
				
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA SAVED");
					
					pst.close(); 
					
					
					
					
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					
				
				}
				
				
			}
		});
		btnNewButton_2.setBounds(603, 493, 101, 42);
		framet.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CANCEL");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ticket t=new ticket();
				t.framet.setVisible(true);
				framet.dispose();
				
			}
		});
		btnNewButton_3.setBounds(732, 493, 115, 37);
		framet.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Generate Ticket");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Download_ticket dt=new Download_ticket();
				dt.framedt.setVisible(true);
				framet.dispose();
				
			}
		});
		btnNewButton_4.setBounds(628, 555, 205, 49);
		framet.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("BACK\r\n");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User_dashboard ud=new User_dashboard();
				ud.frameudb.setVisible(true);
				framet.dispose();
				
			}
		});
		btnNewButton_5.setBounds(897, 590, 85, 36);
		framet.getContentPane().add(btnNewButton_5);
		
		
		
	}
}
