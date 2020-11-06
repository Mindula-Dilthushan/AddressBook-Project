import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewContact extends JFrame {
    private JLabel createFirstName;
    private JLabel createLastName;
    private JLabel createAddress;
    private JLabel createContact;
    private JLabel createEmail;
    private JTextField createFirstNameText;
    private JTextField createLastNameText;
    private JTextField createAddressText;
    private JTextField createContactText;
    private JTextField createEmailText;
    private JButton saveButton;
    private JButton exitButton;

    private JPanel createMainpanel1;
    private JPanel createMainpanel2;
    private JPanel createMainpanel3;
    private JPanel createMainpanel4;
    private JPanel createMainpanel5;

    public CreateNewContact(){
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setResizable(true);

        createFirstName= new JLabel("First Name: ");
        createFirstName.setFont(new Font("Tempus Sans ITC",1,14));

        
        createLastName = new JLabel("Last Name: ");
        createLastName.setFont(new Font("Tempus Sans ITC",1,14));

        createAddress = new JLabel("Address: ");
        createAddress.setFont(new Font("Tempus Sans ITC",1,14));

        createContact = new JLabel("Contact : ");
        createContact.setFont(new Font("Tempus Sans ITC",1,14));

        createEmail = new JLabel("Email : ");
        createEmail.setFont(new Font("Tempus Sans ITC",1,14));


        createFirstNameText = new JTextField(15);
        createFirstNameText.setBackground(new Color(85, 239, 196));
        createFirstNameText.setFont(new Font("Comic Sans MS",1,15));


        createLastNameText = new JTextField(15);
        createLastNameText.setBackground(new Color( 129, 236, 236));
        createLastNameText.setFont(new Font("Comic Sans MS",1,15));

        createAddressText = new JTextField(30);
        createAddressText.setBackground(new Color( 247, 215, 148));
        createAddressText.setFont(new Font("Comic Sans MS",1,15));

        createContactText = new JTextField(10);
        createContactText.setBackground(new Color( 243, 166, 131));
        createContactText.setFont(new Font("Comic Sans MS",1,15));

        createEmailText = new JTextField(18);
        createEmailText.setBackground(new Color( 229, 80, 57));
        createEmailText.setFont(new Font("Comic Sans MS",1,15));


        saveButton = new JButton("Save");
        saveButton.setForeground(new Color(255,255,255));
        saveButton.setBackground(new Color(30, 144, 255));
        saveButton.setFont(new Font("Kristen ITC",3,12));


        exitButton = new JButton("Exit");
        exitButton.setForeground(new Color(255,255,255));
        exitButton.setBackground(new Color(255, 0, 0));
        exitButton.setFont(new Font("Kristen ITC",3,12));

        createMainpanel1 = new JPanel(new GridLayout(5, 1, 1, 6));


        createMainpanel1.add(createFirstName);

        createMainpanel1.add(createLastName);
        createMainpanel1.add(createAddress);
        createMainpanel1.add(createContact);
        createMainpanel1.add(createEmail);

        createMainpanel2 = new JPanel(new GridLayout(5, 1));

        createMainpanel2.add(createFirstNameText);
        createMainpanel2.setFont(new Font("Comic Sans MS",1,15));
        createMainpanel2.add(createLastNameText);
        createMainpanel2.add(createAddressText);
        createMainpanel2.add(createContactText);
        createMainpanel2.add(createEmailText);

        createMainpanel3 = new JPanel(new FlowLayout());
        
        createMainpanel3.add(createMainpanel1);
        createMainpanel3.add(createMainpanel2);

        createMainpanel4 = new JPanel(new FlowLayout());

        createMainpanel4.add(saveButton);
        createMainpanel4.add(exitButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                if(createFirstNameText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");
                }else if(createLastNameText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");
                }else if(createAddressText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");

                }else if(createContactText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");

                }else if(createEmailText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please complete all mandatory fields*");

                }else{
                    AddressBookMenu.addEntry(new AddressBookDTO(createFirstNameText.getText(),createLastNameText.getText(), createAddressText.getText(), createContactText.getText(), createEmailText.getText()));
                }

                }

        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                setVisible(true);
                dispose();
            }
        });


        createMainpanel5 = new JPanel(new BorderLayout());

        createMainpanel5.add(createMainpanel3, BorderLayout.CENTER);
        createMainpanel5.add(createMainpanel4, BorderLayout.SOUTH);

        getContentPane().add(createMainpanel5);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Create New Contact");
		jFrame.setLocationRelativeTo(null);
        new CreateNewContact().setVisible(true);
    }
}
