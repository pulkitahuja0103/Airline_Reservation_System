package Airline_Reservation_System;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;

public class User_dashboard {

	 JFrame frameudb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_dashboard window = new User_dashboard();
					window.frameudb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public User_dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameudb = new JFrame();
		frameudb.getContentPane().setBackground(new Color(255, 228, 181));
		frameudb.setBounds(100, 100, 915, 623);
		frameudb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frameudb.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Customer");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Customer");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				add_customer ac=new add_customer();
				ac.frameac.setVisible(true);
				frameudb.dispose();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Search Customer");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				search_customer sc=new search_customer();
				sc.framesc.setVisible(true);
				frameudb.dispose();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Ticket");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Book Ticket");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticket t=new ticket();
				t.framet.setVisible(true);
				frameudb.dispose();
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Logout");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Front_Page fp=new Front_Page();
				fp.frameFP.setVisible(true);
				frameudb.dispose();
				
			}
		});
		menuBar.add(mntmNewMenuItem_3);
		frameudb.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/cdb.jpg")).getImage();	
		Image img1 = img.getScaledInstance(830, 450, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(23, 124, 836, 415);
		frameudb.getContentPane().add(lblNewLabel);
		
		JLabel lblwelcomeToAirline = new JLabel("<html><b><u>WELCOME TO AIRLINE RESERVATION !!</u><b></html>");
		lblwelcomeToAirline.setFont(new Font("Source Code Pro", Font.BOLD | Font.ITALIC, 30));
		lblwelcomeToAirline.setBounds(96, 30, 646, 79);
		frameudb.getContentPane().add(lblwelcomeToAirline);
	}
}
