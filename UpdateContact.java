import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateContact extends JFrame {
    private JLabel upfirstname;
    private JLabel uplastname;
    private JLabel upaddress;
    private JLabel upcontact;
    private JLabel upemail;
    private JTextField upfirstnameText;
    private JTextField uplastnameText;
    private JTextField upaddressText;
    private JTextField upcontactText;
    private JTextField upemailText;
    private JButton updateButton;
    private JButton searchButton;
    private JButton exitButton;
    private JPanel mainPanel1;
    private JPanel mainPanel2;
    private JPanel mainPanel3;
    private JPanel mainPanel4;
    private JPanel mainPanel5;

    public UpdateContact(String fname,String lname, String address, String telNo, String email){

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setResizable(true);

        upfirstname = new JLabel("First Name: ");
        upfirstname.setFont(new Font("Tempus Sans ITC",1,14));
        uplastname = new JLabel("Last Name: ");
        uplastname.setFont(new Font("Tempus Sans ITC",1,14));
        upaddress = new JLabel("Address: ");
        upaddress.setFont(new Font("Tempus Sans ITC",1,14));
        upcontact = new JLabel("Contact : ");
        upcontact.setFont(new Font("Tempus Sans ITC",1,14));
        upemail = new JLabel("Email : ");
        upemail.setFont(new Font("Tempus Sans ITC",1,14));

        upfirstnameText = new JTextField(15);
        upfirstnameText.setFont(new Font("Comic Sans MS",1,15));
        upfirstnameText.setBackground(new Color(245, 127, 23));


        uplastnameText = new JTextField(15);
        uplastnameText.setBackground(new Color(120, 224, 143));
        uplastnameText.setFont(new Font("Comic Sans MS",1,15));

        upaddressText = new JTextField(30);
        upaddressText.setBackground(new Color(29, 209, 161));
        upaddressText.setFont(new Font("Comic Sans MS",1,15));

        upcontactText = new JTextField(10);
        upcontactText.setBackground(new Color(10, 189, 227));
        upcontactText.setFont(new Font("Comic Sans MS",1,15));

        upemailText = new JTextField(15);
        upemailText.setFont(new Font("Comic Sans MS",1,15));
        upemailText.setBackground(new Color(254, 202, 87));

        upfirstnameText.setText(fname);
        uplastnameText.setText(lname);
        upaddressText.setText(address);
        upcontactText.setText(telNo);
        upemailText.setText(email);

        updateButton = new JButton("Update");
        updateButton.setForeground(new Color(255,255,255));
        updateButton.setBackground(new Color(72, 84, 96));
        updateButton.setFont(new Font("Kristen ITC",3,12));


        exitButton = new JButton("Exit");
        exitButton.setForeground(new Color(255,255,255));
        exitButton.setBackground(new Color(255, 0, 0));
        exitButton.setFont(new Font("Kristen ITC",3,12));

//===========================================================================
        mainPanel1 = new JPanel(new GridLayout(5, 1, 1, 5));

        mainPanel1.add(upfirstname);
        mainPanel1.add(uplastname);
        mainPanel1.add(upaddress);
        mainPanel1.add(upcontact);
        mainPanel1.add(upemail);

        mainPanel2 = new JPanel(new GridLayout(5, 1));

        mainPanel2.add(upfirstnameText);
        mainPanel2.add(uplastnameText);
        mainPanel2.add(upaddressText);
        mainPanel2.add(upcontactText);
        mainPanel2.add(upemailText);

        mainPanel3 = new JPanel(new FlowLayout());

        mainPanel3.add(mainPanel1);
        mainPanel3.add(mainPanel2);

        mainPanel4 = new JPanel(new FlowLayout());

        mainPanel4.add(updateButton);
        mainPanel4.add(exitButton);

//================================================================================

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(upfirstnameText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");
                }else if(uplastnameText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");
                }else if(upaddressText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");

                }else if(upcontactText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");

                }else if(upemailText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");

                }else{
                    AddressBookMenu.editEntry(new AddressBookDTO(upfirstnameText.getText(), uplastnameText.getText(), upaddressText.getText(), upcontactText.getText(), upemailText.getText()));
                }

            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        mainPanel5 = new JPanel(new BorderLayout());

        mainPanel5.add(mainPanel3, BorderLayout.CENTER);
        mainPanel5.add(mainPanel4, BorderLayout.SOUTH);

        getContentPane().add(mainPanel5);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
		JFrame jFrame = new JFrame();
		
		jFrame.setLocationRelativeTo(null);
		jFrame.setTitle("Update Contact");
        new UpdateContact("", "", "", "","").setVisible(true);
    }
}
