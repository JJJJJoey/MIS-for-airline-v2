package MSIforAirline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminLogin {

	public JFrame frame;
	private JTextField user;
	private JPasswordField pass;
	private JButton register;
	private JButton btnBack;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public AdminLogin() {
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
		
		user = new JTextField();
		user.setBounds(197, 39, 96, 19);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql","root","");
					Statement stmt = con.createStatement();
					String sql="Select * from admin_creds where username='"+user.getText()+"'and password='"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						JOptionPane.showMessageDialog(null,"Login Sucessful");
						AdminWelcome aw = new AdminWelcome();
						frame.dispose();
						aw.frame.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null,"Wrong Credentials, try again");
					}
					con.close();	
							
					
				}catch(Exception e1 ) {
					System.out.println(e1);
				}
				
			}
		});
		login.setBounds(174, 113, 85, 21);
		frame.getContentPane().add(login);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(113, 42, 57, 13);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(113, 87, 57, 13);
		frame.getContentPane().add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(197, 84, 96, 19);
		frame.getContentPane().add(pass);
		
		register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked");
				frame.dispose();
				RegisterPage nr = new RegisterPage();
				nr.frame.setVisible(true);
					
			}
		});
		register.setBounds(174, 158, 85, 21);
		frame.getContentPane().add(register);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WelcomePage wp = new WelcomePage();
				wp.frame.setVisible(true);
					
			}
			
		});
		btnBack.setBounds(0, 0, 85, 21);
		frame.getContentPane().add(btnBack);
	}
	
}
