package Airline_Reservation_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

public class Admin_dashboard {

	 JFrame frameadb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_dashboard window = new Admin_dashboard();
					window.frameadb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameadb = new JFrame();
		frameadb.getContentPane().setBackground(new Color(255, 228, 181));
		frameadb.setBounds(100, 100, 850, 605);
		frameadb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frameadb.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Flight");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Flight");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			add_flight af=new add_flight();
			af.frameaf.setVisible(true);
			frameadb.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Front_Page fp=new Front_Page();
				fp.frameFP.setVisible(true);
				frameadb.dispose();
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		frameadb.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><b>WELCOME SIR !!<b></html>");
		lblNewLabel.setFont(new Font("Source Code Pro", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(299, 10, 291, 79);
		frameadb.getContentPane().add(lblNewLabel);
		
		JLabel lbl = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/adb.jpg")).getImage();	
		Image img1 = img.getScaledInstance(750, 750, Image.SCALE_DEFAULT);
		lbl.setIcon(new ImageIcon(img1));
		lbl.setBounds(50, 107, 750, 412);
		frameadb.getContentPane().add(lbl);
	}
}
