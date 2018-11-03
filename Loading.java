package FinalLab;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class Loading {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading window = new Loading();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loading() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoading = new JLabel("LOADING");
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblLoading.setBounds(64, 169, 290, 81);
		frame.getContentPane().add(lblLoading);
		
		JPanel smallPane = new JPanel();
		smallPane.setBounds(64, 11, 296, 160);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("loading.gif").getImage().getScaledInstance(smallPane.getWidth(), smallPane.getHeight(), Image.SCALE_DEFAULT)); 

		
		JLabel imageLabel = new JLabel(" ");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setIcon(imageIcon);
		imageLabel.setBounds(10, 11, 276, 138);
		smallPane.add(imageLabel);
		
		frame.getContentPane().add(smallPane);
		smallPane.setLayout(null);
		
		
	}
}
