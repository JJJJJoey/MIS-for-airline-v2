package MSIforAirline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class CustomerScreen {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerScreen window = new CustomerScreen();
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
	public CustomerScreen() {
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
		
		JButton btnBookTicket = new JButton("Book a ticket");
		btnBookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Booking bk = new Booking();
				frame.dispose();
				bk.frame.setVisible(true);
			}
		});
		btnBookTicket.setBounds(134, 98, 146, 21);
		frame.getContentPane().add(btnBookTicket);
		
		JButton btnCancelATicket = new JButton("cancel a ticket");
		btnCancelATicket.setBounds(134, 129, 146, 21);
		frame.getContentPane().add(btnCancelATicket);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(134, 53, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCustomerName = new JLabel("customer name");
		lblCustomerName.setBounds(207, 53, 73, 13);
		frame.getContentPane().add(lblCustomerName);
	}
}
