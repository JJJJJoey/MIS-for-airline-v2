package MSIforAirline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class NewCostumer {

    JFrame frame;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfPassport;
    private JTextField tfAddress;
    private JTextField tfPhoneNum;
    private JLabel lblNewLabel_1;
    private JLabel lblID;
    private JPanel panel_1;
    private JLabel lblNewLabel_3;
    private JTextField tfGender;
    private JButton btnBrowse;




    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewCostumer window = new NewCostumer();
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
    public NewCostumer() {
        initialize();
        autoID();
    }
    // Establishing the connection
    Connection con;
    PreparedStatement pst;
    String path=null;
    byte[] userimage=null;
    private JButton btnBack;

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 646, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(147, 112, 219));
        panel.setBounds(22, 112, 305, 237);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("First Name");
        lblNewLabel.setBounds(10, 10, 80, 19);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(10, 49, 80, 19);
        panel.add(lblLastName);
        lblLastName.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));

        JLabel lblPaasboardOrId = new JLabel("Passport or ID");
        lblPaasboardOrId.setBounds(10, 78, 123, 19);
        panel.add(lblPaasboardOrId);
        lblPaasboardOrId.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(10, 120, 123, 19);
        panel.add(lblAddress);
        lblAddress.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));

        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setBounds(10, 165, 123, 19);
        panel.add(lblPhoneNumber);
        lblPhoneNumber.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));

        tfFirstName = new JTextField();
        tfFirstName.setBounds(164, 8, 96, 19);
        panel.add(tfFirstName);
        tfFirstName.setColumns(10);

        tfLastName = new JTextField();
        tfLastName.setBounds(164, 47, 96, 19);
        panel.add(tfLastName);
        tfLastName.setColumns(10);

        tfPassport = new JTextField();
        tfPassport.setBounds(164, 76, 96, 19);
        panel.add(tfPassport);
        tfPassport.setColumns(10);

        tfAddress = new JTextField();
        tfAddress.setBounds(164, 118, 96, 19);
        panel.add(tfAddress);
        tfAddress.setColumns(10);

        tfPhoneNum = new JTextField();
        tfPhoneNum.setBounds(164, 163, 96, 19);
        panel.add(tfPhoneNum);
        tfPhoneNum.setColumns(10);

        lblNewLabel_1 = new JLabel("Customer ID");
        lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(56, 56, 114, 34);
        frame.getContentPane().add(lblNewLabel_1);

        lblID = new JLabel("Customer ID");
        lblID.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        lblID.setBounds(202, 56, 114, 34);
        frame.getContentPane().add(lblID);

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(147, 112, 219));
        panel_1.setBounds(361, 112, 229, 233);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        lblNewLabel_3 = new JLabel("date of birth ");
        lblNewLabel_3.setBounds(10, 10, 74, 13);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("gender");
        lblNewLabel_4.setBounds(10, 46, 45, 13);
        panel_1.add(lblNewLabel_4);

        tfGender = new JTextField();
        tfGender.setBounds(78, 43, 96, 19);
        panel_1.add(tfGender);
        tfGender.setColumns(10);

        //JDateChooser dateOfBirth = new JDateChooser();
        //dateOfBirth.setBounds(78, 10, 96, 19);
       // panel_1.add(dateOfBirth);

        JPanel panelPhoto = new JPanel();
        panelPhoto.setBounds(45, 92, 129, 115);
        panel_1.add(panelPhoto);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id= lblID.getText();
                String first_name= tfFirstName.getText();
                String last_name= tfLastName.getText();
                String passport_id= tfPassport.getText();
                String address= tfAddress.getText();
                String phone_number= tfPhoneNum.getText();

                DateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
                //String date_of_birth =df.format(dateOfBirth.getDate());

                String gender= tfGender.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql","root", "");

                    pst = con.prepareStatement("INSERT INTO customer_info(id,first_name,last_name,passport_id,address,phone_number,date_of_birth,gender)values(?,?,?,?,?,?,?,?)");

                    pst.setString(1,id);
                    pst.setString(2,first_name);
                    pst.setString(3,last_name);
                    pst.setString(4,passport_id);
                    pst.setString(5,address);
                    pst.setString(6,phone_number);
                    //pst.setString(7,date_of_birth);
                    pst.setString(8,gender);



                    JOptionPane.showMessageDialog(null,"registration done");
                    pst.executeUpdate();
                    System.out.println("New costumer registered!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }



            }
        });
        btnAdd.setBounds(134, 367, 85, 21);
        frame.getContentPane().add(btnAdd);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnCancel.setBounds(252, 367, 85, 21);
        frame.getContentPane().add(btnCancel);

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
    public void autoID() {
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamysql","root", "");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select MAX(id) from customer_info");
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