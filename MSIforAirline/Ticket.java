package MSIforAirline;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Ticket {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket window = new Ticket();
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
	public Ticket() {
		initialize();
	}
	Connection con;
	PreparedStatement pst;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Select from ");
		lblNewLabel.setBounds(74, 46, 79, 19);
		frame.getContentPane().add(lblNewLabel);

		JComboBox comboBoxFrom = new JComboBox();
		comboBoxFrom.setModel(new DefaultComboBoxModel(new String[] {"UK", "USA", "UAE", "Greece"}));
		comboBoxFrom.setBounds(163, 45, 136, 21);
		frame.getContentPane().add(comboBoxFrom);

		JLabel lblSelectTo = new JLabel("Select to");
		lblSelectTo.setBounds(74, 93, 79, 19);
		frame.getContentPane().add(lblSelectTo);

		JComboBox comboBoxTo = new JComboBox();
		comboBoxTo.setModel(new DefaultComboBoxModel(new String[] {"UK", "USA", "UAE", "Greece"}));
		comboBoxTo.setBounds(163, 92, 136, 21);
		frame.getContentPane().add(comboBoxTo);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"flight_id", "airline", "from_airport", "to_airport", "cost"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setBounds(24, 232, 387, 152);
		frame.getContentPane().add(table);

		JLabel lblNewLabel_1 = new JLabel("TicketNO");
		lblNewLabel_1.setBounds(337, 49, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBounds(443, 24, 258, 165);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Customer ID");
		lblNewLabel_2.setBounds(25, 20, 80, 13);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("First Name");
		lblNewLabel_2_1.setBounds(25, 57, 80, 13);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Last Name");
		lblNewLabel_2_1_1.setBounds(25, 99, 80, 13);
		panel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Passport");
		lblNewLabel_2_1_1_1.setBounds(25, 142, 80, 13);
		panel.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(183, 20, 65, 13);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(183, 57, 65, 13);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(183, 99, 65, 13);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(183, 142, 65, 13);
		panel.add(lblNewLabel_6);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(443, 207, 258, 165);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Flight NO");
		lblNewLabel_7.setBounds(20, 10, 71, 13);
		panel_1.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel("Flight Name");
		lblNewLabel_7_1.setBounds(20, 46, 71, 13);
		panel_1.add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_1_1 = new JLabel("Depart time");
		lblNewLabel_7_1_1.setBounds(20, 83, 71, 13);
		panel_1.add(lblNewLabel_7_1_1);

		JLabel lblNewLabel_7_1_1_1 = new JLabel("Class");
		lblNewLabel_7_1_1_1.setBounds(20, 119, 71, 13);
		panel_1.add(lblNewLabel_7_1_1_1);

		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("Price");
		lblNewLabel_7_1_1_1_1.setBounds(20, 142, 71, 13);
		panel_1.add(lblNewLabel_7_1_1_1_1);

		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(178, 10, 45, 13);
		panel_1.add(lblNewLabel_8);

		JLabel lblNewLabel_8_1 = new JLabel("New label");
		lblNewLabel_8_1.setBounds(178, 46, 45, 13);
		panel_1.add(lblNewLabel_8_1);

		JLabel lblNewLabel_8_2 = new JLabel("New label");
		lblNewLabel_8_2.setBounds(178, 83, 45, 13);
		panel_1.add(lblNewLabel_8_2);

		JLabel lblNewLabel_8_3 = new JLabel("New label");
		lblNewLabel_8_3.setBounds(178, 119, 45, 13);
		panel_1.add(lblNewLabel_8_3);

		JLabel lblNewLabel_8_4 = new JLabel("New label");
		lblNewLabel_8_4.setBounds(178, 142, 45, 13);
		panel_1.add(lblNewLabel_8_4);

		JButton btnNewButton = new JButton("Book");
		btnNewButton.setBounds(453, 386, 85, 21);
		frame.getContentPane().add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(592, 386, 85, 21);
		frame.getContentPane().add(btnCancel);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = comboBoxFrom.getSelectedItem().toString();
				String to = comboBoxTo.getSelectedItem().toString();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql","root", "");
					pst = con.prepareStatement("SELECT * FROM flights WHERE from_airport=? and to_airport=?");
					pst.setString(1,from);
					pst.setString(2,to);
					ResultSet rs = pst.executeQuery();

					java.sql.ResultSetMetaData rsm = rs.getMetaData();
					int c;
					c=rsm.getColumnCount();
					DefaultTableModel df = (DefaultTableModel)table.getModel();
					df.setRowCount(0);
					while(rs.next()) {
						Vector v2= new Vector();
						for(int i=1; i <= c; i++) {
							v2.add(rs.getString("flight_id"));
							v2.add(rs.getString("airline"));
							v2.add(rs.getString("from_airport"));
							v2.add(rs.getString("to_airport"));
							v2.add(rs.getString("date"));
							v2.add(rs.getString("cost"));
						}
						df.addRow(v2);
					}


				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSearch.setBounds(259, 147, 85, 21);
		frame.getContentPane().add(btnSearch);


	}
}
