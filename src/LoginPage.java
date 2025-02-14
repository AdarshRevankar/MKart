import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import javax.xml.bind.JAXBException;

class LoginPage extends JPanel {
    // Page1
    private JLabel jLabel, jLabel2, jLabel3;
    private JTextField unameTf;
    private JPasswordField pswdTf;
    private JButton loginButton;

    private LoginPage() {
        //construct components
        jLabel = new JLabel("MITE Kart");
        unameTf = new JTextField(5);
        jLabel2 = new JLabel("Username");
        jLabel3 = new JLabel("Password");
        pswdTf = new JPasswordField(5);
        loginButton = new JButton("Login");

        //adjust size and set layout
        setPreferredSize(new Dimension(353, 288));
        setLayout(null);

        //add components
        add(jLabel);
        add(unameTf);
        add(jLabel2);
        add(jLabel3);
        add(pswdTf);
        add(loginButton);

        //set component bounds (only needed by Absolute Positioning)
        jLabel.setBounds(130, 35, 60, 30);
        unameTf.setBounds(145, 90, 120, 25);
        jLabel2.setBounds(45, 90, 65, 25);
        jLabel3.setBounds(45, 140, 70, 25);
        pswdTf.setBounds(145, 135, 120, 25);
        loginButton.setBounds(120, 200, 100, 25);

        final Customer[] currentCustomer = {null};
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get Credentials
                String userName = unameTf.getText();
                String password = String.valueOf(pswdTf.getPassword());
                try {
                    currentCustomer[0] = authCustomer(userName.split("@")[0], userName, password);
                } catch (IOException | ClassNotFoundException | JAXBException ex) {
                    ex.printStackTrace();
                }
                try {
                    NextPage(currentCustomer[0]);
                } catch (FileNotFoundException | JAXBException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void NextPage(Customer cust) throws FileNotFoundException, JAXBException, ClassNotFoundException {
        System.out.println(cust);
        this.setVisible(false);
        ProductPage.showPage2(cust);
    }

    static void start() {
        JFrame frame = new JFrame("M-Kart Rental Makes Easy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new LoginPage());
        frame.pack();
        frame.setVisible(true);
    }

    private static Customer authCustomer(String name, String username, String password) throws IOException, JAXBException, ClassNotFoundException {
        Customers currentCustomers = (Customers) XMLJavaReadWriters.readFromXML("Customers", System.getProperty("user.dir") + "/src/xml/customers.xml");
        for (Customer existingCust : currentCustomers.getCustomerList()) {
            // Check uname & password
            if (existingCust.getUname().equals(username) &&
                    existingCust.getPassword().equals(password))
                return existingCust;
        }

        // Since user name not found, append user to the current Customer list
        Customer registeredCustomer = new Customer(name, username, password);
        currentCustomers.getCustomerList().add(registeredCustomer);
        XMLJavaReadWriters.writeToXML("Customers", System.getProperty("user.dir") + "/src/xml/customers.xml", currentCustomers);
        return registeredCustomer;
    }
}
