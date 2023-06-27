
package Airline_Reservation_System;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Front_Page {

	 JFrame frameFP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front_Page window = new Front_Page();
					window.frameFP.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Front_Page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameFP = new JFrame();
		frameFP.setBounds(100, 100, 953, 638);
		frameFP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFP.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin_Login al=new Admin_Login();
				al.frameAL.setVisible(true);
				frameFP.dispose();
				
			}
		});
		btnNewButton.setBounds(192, 276, 125, 42);
		frameFP.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("USER");
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Login ul=new User_Login();
				ul.frameUL.setVisible(true);
				frameFP.dispose();

			}
		});
		btnNewButton_1.setBounds(623, 276, 125, 42);
		frameFP.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(frameFP.EXIT_ON_CLOSE);
			}
		});
		btnNewButton_2.setBounds(804, 10, 125, 42);
		frameFP.getContentPane().add(btnNewButton_2);
		
		
		JLabel lblNewLabel = new JLabel("<html><b><u>AIRLINE RESERVATION SYSTEM</u></b></html>");
		lblNewLabel.setFont(new Font("NSimSun", Font.PLAIN, 40));
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(192, 106, 556, 80);
		frameFP.getContentPane().add(lblNewLabel);
		
		JLabel bgimg = new JLabel("New label");
		Image img=new ImageIcon(this.getClass().getResource("/bgimg.jpg")).getImage();	
		Image img1 = img.getScaledInstance(950, 950, Image.SCALE_DEFAULT);
		bgimg.setIcon(new ImageIcon(img1));
		bgimg.setBounds(0, 0, 939, 601);
		frameFP.getContentPane().add(bgimg);
		
		
		
	}
}
