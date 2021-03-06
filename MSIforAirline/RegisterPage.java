package MSIforAirline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RegisterPage{

	public JFrame frame;
	private JTextField newName;
	private JTextField newPass;
	private JLabel lblID;
	
	Connection con;
	PreparedStatement pst;
	String path=null;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage window = new RegisterPage();
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
	public RegisterPage() {
		initialize();
		autoID();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("register");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 28));
		lblNewLabel.setBounds(207, 10, 151, 80);
		frame.getContentPane().add(lblNewLabel);
		
		newName = new JTextField();
		newName.setBounds(165, 120, 96, 19);
		frame.getContentPane().add(newName);
		newName.setColumns(10);
		
		newPass = new JTextField();
		newPass.setColumns(10);
		newPass.setBounds(165, 166, 96, 19);
		frame.getContentPane().add(newPass);
		
		JLabel lblNewLabel_1 = new JLabel("New Name");
		lblNewLabel_1.setBounds(45, 123, 77, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password");
		lblNewLabel_1_1.setBounds(45, 169, 77, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton registerButton = new JButton("register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String id= lblID.getText();
				 String username = newName.getText();
				 String password = newPass.getText();
                try {
                    
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql","root", "");
                    
					pst = con.prepareStatement("INSERT INTO credentials(id,username,password)values(?,?,?)");
					//pst = con.prepareStatement("INSERT INTO flights(flight_id,airline,from_airport,to_airport,date,cost)values(?,?,?,?,?,?)");
					pst.setString(1,id);
					pst.setString(2,username);
					pst.setString(3,password);

                    //PreparedStatement st = (PreparedStatement)con.prepareStatement("INSERT INTO credentials  (`idcredentials`,`username`, `password`)  VALUES ('?,"+newName.getText()+"', '"+newPass.getText()+"' )");

                    //st.setString(1, newName);
                    //st.setString(2, newPass);
                    pst.executeUpdate();
                    System.out.println("New costumer registered!");           
                   
                    

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                frame.dispose();
				NewCostumer nc = new NewCostumer();
				nc.frame.setVisible(true);

            }
			
			
		});
		registerButton.setBounds(165, 210, 85, 21);
		frame.getContentPane().add(registerButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WelcomePage wp = new WelcomePage();
				wp.frame.setVisible(true);
			}
		});
		btnBack.setBounds(0, 0, 85, 21);
		frame.getContentPane().add(btnBack);
		
		lblID = new JLabel("New label");
		lblID.setBounds(65, 69, 96, 21);
		frame.getContentPane().add(lblID);
	}
	public void autoID() {
		   try {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql","root", "");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select MAX(id) from credentials");
            rs.next();
            rs.getString("MAX(id)");
            if(rs.getString("MAX(id)") == null) {
            	lblID.setText("CS001");
         	   
            }else {
         	   long id = Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
         	   id++;
         	  lblID.setText("CS"+String.format("%03d",id));
            }
            

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
	}
}
