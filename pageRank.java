package pagerank_url;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pageRank {

	private JFrame frmPageRankChecker;
	private static JTextField textField1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageRank window = new pageRank();
					window.frmPageRankChecker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				
	}

	/**
	 * Create the application.
	 */
	public pageRank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPageRankChecker = new JFrame();
		frmPageRankChecker.setTitle("Page Rank Checker");
		frmPageRankChecker.setBounds(100, 100, 328, 212);
		frmPageRankChecker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPageRankChecker.getContentPane().setLayout(null);
                frmPageRankChecker.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 312, 174);
		frmPageRankChecker.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("Enter the Link :");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		//label1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label1.setBounds(10, 53, 89, 20);
		panel.add(label1);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField1.setBounds(96, 53, 189, 20);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JButton button1 = new JButton("Check");
		button1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GoogleSeoHelper obj = new GoogleSeoHelper();
				textField.setText(String.valueOf(obj.getPR(textField1.getText())));
				//label3.setText(String.valueOf(obj.getPR(textField1.getText())));
			}
		});
		button1.setBounds(140, 84, 89, 23);
		panel.add(button1);
		
		JLabel label2 = new JLabel("The Page Rank value is :");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label2.setBounds(10, 128, 135, 20);
		panel.add(label2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setBounds(140, 128, 60, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTheValueOf = new JLabel("-----The Value of Page Rank ranges from 1 - 10-----\r\n");
		lblTheValueOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTheValueOf.setBounds(10, 11, 292, 14);
		panel.add(lblTheValueOf);
		
		
	}
}
