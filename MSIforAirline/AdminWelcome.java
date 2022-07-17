package MSIforAirline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminWelcome {

    JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminWelcome window = new AdminWelcome();
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
    public AdminWelcome() {
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

        JButton btnAddFlight = new JButton("Add new Flight");
        btnAddFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFlight af = new AddFlight();
                frame.dispose();
                af.frame.setVisible(true);


            }
        });
        btnAddFlight.setBounds(65, 61, 175, 29);
        frame.getContentPane().add(btnAddFlight);

        JButton btnBack = new JButton("back");
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