package MSIforAirline;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

//import MSIforAirline.LoginPage;
//import MSIforAirline.RegisterPage;
//import testLogin3.Ticket;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
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
	public WelcomePage() {
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

		JButton btnNewButton = new JButton("admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminWelcome aw = new AdminWelcome();
				frame.dispose();
				aw.frame.setVisible(true);

			}
		});
		btnNewButton.setBounds(351, 10, 75, 21);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel.setBounds(175, 76, 75, 21);
		frame.getContentPane().add(lblNewLabel);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				frame.dispose();
				lp.frame.setVisible(true);

			}
		});
		btnLogin.setBounds(56, 145, 85, 21);
		frame.getContentPane().add(btnLogin);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked");
				frame.dispose();
				RegisterPage nr = new RegisterPage();
				nr.frame.setVisible(true);

			}
		});
		btnRegister.setBounds(280, 145, 85, 21);
		frame.getContentPane().add(btnRegister);
	}
}
