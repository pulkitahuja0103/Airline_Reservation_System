package Airline_Reservation_System;

import javax.swing.JFrame;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;

//**************
import java.awt.*;

import javax.swing.*;

public class Download_ticket {

	 JFrame framedt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Download_ticket window = new Download_ticket();
					window.framedt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Download_ticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framedt = new JFrame();
		framedt.getContentPane().setBackground(new Color(224, 255, 255));
		framedt.setBounds(100, 100, 967, 654);
		framedt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framedt.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("DOWNLOAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		            Thread.sleep(1000);
		        } catch (InterruptedException e3) {
		            e3.printStackTrace();
		        }

		        // Capture screenshot
		        try {
		            Robot robot = new Robot();
		            BufferedImage screenshot = robot.createScreenCapture(framedt.getBounds());

		            // Save the screenshot to an image file
		            File output = new File("TICKET.png");
		            ImageIO.write(screenshot, "png", output);

		            System.out.println("Screenshot saved successfully.");
		        } catch (Exception e4) {
		            e4.printStackTrace();
		        }
		        
		        framedt.dispose();

				
			}
		});
		btnNewButton.setBounds(823, 561, 120, 32);
		framedt.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("<html><b><u>Guest Name</u></b></html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(178, 147, 184, 38);
		framedt.getContentPane().add(lblNewLabel);
		
		
		JLabel lfn = new JLabel("New label");
		lfn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lfn.setBounds(178, 196, 86, 32);
		framedt.getContentPane().add(lfn);
		lfn.setText(ticket.tf_first_name.getText());
		
		JLabel lln = new JLabel("New label");
		lln.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lln.setBounds(276, 196, 86, 32);
		framedt.getContentPane().add(lln);
		lln.setText(ticket.tf_last_name.getText());
		
		JLabel lblbookingDate = new JLabel("<html><b><u>Departure Date/Time :</u></b></html>");
		lblbookingDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblbookingDate.setBounds(624, 271, 182, 53);
		framedt.getContentPane().add(lblbookingDate);
		
		
		JLabel ldate = new JLabel((String) null);
		ldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ldate.setBounds(624, 334, 86, 32);
		framedt.getContentPane().add(ldate);
		ldate.setText(ticket.tf_date.getText());
		
		JLabel ldtime = new JLabel((String) null);
		ldtime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ldtime.setBounds(720, 334, 86, 32);
		framedt.getContentPane().add(ldtime);
		ldtime.setText(ticket.tf_dept_time.getText());
		
		JLabel lblflightDetails = new JLabel("<html><b><u>Flight Details : </u></b></html>");
		lblflightDetails.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblflightDetails.setBounds(178, 269, 229, 55);
		framedt.getContentPane().add(lblflightDetails);
		
		JLabel l1 = new JLabel("<html><b>From :</b></html>");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l1.setBounds(178, 314, 184, 38);
		framedt.getContentPane().add(l1);
		
		JLabel lfrom = new JLabel((String) null);
		lfrom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lfrom.setBounds(178, 350, 86, 32);
		framedt.getContentPane().add(lfrom);
		lfrom.setText(ticket.Source);
		
		JLabel lto = new JLabel((String) null);
		lto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lto.setBounds(178, 442, 86, 32);
		framedt.getContentPane().add(lto);
		lto.setText(ticket.Departure);
		
		JLabel l2 = new JLabel("<html><b>To :</b></html>");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l2.setBounds(178, 394, 184, 38);
		framedt.getContentPane().add(l2);
		
		JLabel l4 = new JLabel("<html><b>Seat Class :</b></html>");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l4.setBounds(178, 489, 120, 38);
		framedt.getContentPane().add(l4);
		
		JLabel lclass = new JLabel((String) null);
		lclass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lclass.setBounds(178, 537, 86, 32);
		framedt.getContentPane().add(lclass);
		lclass.setText(ticket.Set_class);
		
		JLabel l5 = new JLabel("<html><b>Flight Name :</b></html>");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l5.setBounds(356, 394, 165, 38);
		framedt.getContentPane().add(l5);
		
		JLabel lflightname = new JLabel((String) null);
		lflightname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lflightname.setBounds(356, 442, 86, 32);
		framedt.getContentPane().add(lflightname);
		lflightname.setText(ticket.tf_flight_name.getText());
		
		JLabel l6 = new JLabel("<html><b>Number of seats:</b></html>");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l6.setBounds(356, 489, 197, 38);
		framedt.getContentPane().add(l6);
		
		JLabel lseats = new JLabel((String) null);
		lseats.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lseats.setBounds(356, 537, 86, 32);
		framedt.getContentPane().add(lseats);
		lseats.setText(ticket.number_of_seats);
		
		JLabel l8 = new JLabel("<html><b>Passport ID :</b></html>");
		l8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l8.setBounds(609, 161, 197, 38);
		framedt.getContentPane().add(l8);
		
		JLabel lpid = new JLabel((String) null);
		lpid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lpid.setBounds(609, 209, 86, 32);
		framedt.getContentPane().add(lpid);
		lpid.setText(ticket.tf_c_pid.getText());
		
		JLabel l_totalfair = new JLabel("New label");
		l_totalfair.setBounds(665, 454, 120, 32);
		framedt.getContentPane().add(l_totalfair);
		l_totalfair.setText(ticket.total_price);
		
		JLabel lbltotal = new JLabel("<html><b>Net Fair :</b></html>");
		lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltotal.setBounds(663, 406, 165, 38);
		framedt.getContentPane().add(lbltotal);
		
		
	}
}
