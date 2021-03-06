package MSIforAirline;


//import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AddFlight {

	JFrame frame;
	private JTextField tfAirline;
	private JTextField tfCost;
	private JLabel lblID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlight window = new AddFlight();
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
	public AddFlight() {
		initialize();
		autoID();
	}
	// Establishing the connection
	Connection con;
	PreparedStatement pst;
	String path=null;
	byte[] userimage=null;
	private JTextField tfFrom;
	private JTextField tfTo;

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 758, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(46, 30, 288, 337);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Airline");
		lblNewLabel_1.setBounds(27, 48, 65, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("From");
		lblNewLabel_2.setBounds(27, 88, 45, 13);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("to");
		lblNewLabel_3.setBounds(27, 130, 45, 13);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("date");
		lblNewLabel_4.setBounds(27, 182, 45, 13);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Cost");
		lblNewLabel_5.setBounds(27, 234, 45, 13);
		panel.add(lblNewLabel_5);

		tfCost = new JTextField();
		tfCost.setBounds(80, 231, 96, 19);
		panel.add(tfCost);
		tfCost.setColumns(10);

		//JDateChooser dateChooserFlight = new JDateChooser();
		//dateChooserFlight.setBounds(80, 182, 96, 19);
		//panel.add(dateChooserFlight);

		tfAirline = new JTextField();
		tfAirline.setBounds(80, 45, 96, 19);
		panel.add(tfAirline);
		tfAirline.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(137, 276, 85, 21);
		panel.add(btnCancel);


		tfFrom = new JTextField();
		tfFrom.setColumns(10);
		tfFrom.setBounds(80, 85, 96, 19);
		panel.add(tfFrom);

		tfTo = new JTextField();
		tfTo.setColumns(10);
		tfTo.setBounds(82, 127, 96, 19);
		panel.add(tfTo);

		JLabel lblNewLabel = new JLabel("Flight ID");
		lblNewLabel.setBounds(27, 22, 63, 13);
		panel.add(lblNewLabel);



		lblID = new JLabel("Flight ID");
		lblID.setBounds(137, 22, 45, 13);
		panel.add(lblID);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					String flight_id= lblID.getText();
					String airline = tfAirline.getText();
					//JComboBox tfFrom = null;
					String from = tfFrom.getText();
					//JComboBox tfTo = null;
					String to = tfTo.getText();
					DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
					//String date = df.format(dateChooserFlight.getDate());
					String cost = tfCost.getText();

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql","root", "");
						pst = con.prepareStatement("INSERT INTO flights(flight_id,airline,from_airport,to_airport,date,cost)values(?,?,?,?,?,?)");
						//pst = con.prepareStatement("INSERT INTO flights(flight_id,airline,from_airport,to_airport,date,cost)values(?,?,?,?,?,?)");
						pst.setString(1,flight_id);
						pst.setString(2,airline);
						pst.setString(3,from);
						pst.setString(4,to);
						//pst.setString(5,date);
						pst.setString(6,cost);


						//pst.setString(1,airline);
						//pst.setString(2,from);
						//pst.setString(3,to);
						//pst.setString(4,date);
						//pst.setString(5,cost);

						JOptionPane.showMessageDialog(null,"new flight added done");
						pst.executeUpdate();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

		});
		btnAdd.setBounds(27, 276, 85, 21);
		panel.add(btnAdd);

		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminWelcome aw = new AdminWelcome();
				aw.frame.setVisible(true);
			}
		});
		btnBack.setBounds(0, 0, 85, 21);
		frame.getContentPane().add(btnBack);






	}
	public void autoID() {
		   try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql","root", "");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select MAX(flight_id) from flights");
            rs.next();
            rs.getString("MAX(flight_id)");
            if(rs.getString("MAX(flight_id)") == null) {
            	lblID.setText("FL001");

            }else {
         	  long flight_id = Long.parseLong(rs.getString("MAX(flight_id)").substring(2,rs.getString("MAX(flight_id)").length()));
         	  flight_id++;
         	  lblID.setText("FL"+String.format("%03d",flight_id));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

	}
}
