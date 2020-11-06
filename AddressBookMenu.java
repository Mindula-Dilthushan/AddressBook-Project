//Projec 02.6.16 
//Programmer Mindula Dilthushan 

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookMenu extends JPanel {
    private static JTable contactTable;
    private JScrollPane tablePanel;
    private JPanel MainPanel;
    private JPanel buttonPanel;
    private JButton createButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton exitButton;
    private JButton searchButton;
    private static int rowCount = 0;
    private static int selectRow;

    public AddressBookMenu() {

//===================Button=======================================

        searchButton = new JButton("Search");
        searchButton.setForeground(new Color(255,255,255));
        searchButton.setBackground(new Color (27, 156, 252));
        searchButton.setFont(new Font("Kristen ITC",1,12));

        createButton = new JButton("New Contact");
        createButton.setForeground(new Color(255,255,255));
        createButton.setBackground(new Color(38, 222, 129));
        createButton.setFont(new Font("Kristen ITC",3,12));


		updateButton = new JButton("UpdateContact");
        updateButton.setForeground(new Color(255,255,255));
        updateButton.setBackground(new Color(250, 130, 49));
        updateButton.setFont(new Font("Kristen ITC",3,12));

        deleteButton = new JButton("Delete");
        deleteButton.setForeground(new Color(255,255,255));
        deleteButton.setBackground(new Color(205, 132, 241));
        deleteButton.setFont(new Font("Kristen ITC",3,12));

        exitButton = new JButton("Exit");
        exitButton.setForeground(new Color(255,255,255));
        exitButton.setBackground(new Color(255, 0, 0));
        exitButton.setFont(new Font("Kristen ITC",3,12));


        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(searchButton);
        buttonPanel.add(createButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

//=======================================================================

        contactTable = new JTable(new AbstractTable());
        TableColumn column = null;

        for(int i = 0; i < 5; i++) {
            column = contactTable.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(100);
            } else if(i == 1) {
                column.setPreferredWidth(150);
            } else if(i == 4) {
                column.setPreferredWidth(100);
            } else {
                column.setPreferredWidth(50);
            }
        }

        JTableHeader tableHeader = contactTable.getTableHeader();
        contactTable.setRowHeight(20);
        
        //Color color=new Color(75, 75, 75);
        //contactTable.setBackground(color);
        
        tableHeader.setBackground(Color.BLACK);
        tableHeader.setForeground(Color.RED);
        Font headerFont = new Font("Viner Hand ITC",1,15);
        tableHeader.setFont(headerFont);

        tablePanel = new JScrollPane(contactTable);
        MainPanel = new JPanel(new BorderLayout());
        JScrollPane tablePanel = new JScrollPane( contactTable );
        contactTable.setOpaque( false );


        tablePanel.getViewport().setOpaque( false );
        MainPanel.add(tablePanel, BorderLayout.CENTER);

//=======================================================================

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               CreateNewContact cont= new CreateNewContact();
                cont.setVisible(true);
                cont.setLocationRelativeTo(null);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              UpdateContact updframe=  new UpdateContact(
                        contactTable.getValueAt(getSelectedRow(), 0).toString(),
                        contactTable.getValueAt(getSelectedRow(), 1).toString(),
                        contactTable.getValueAt(getSelectedRow(), 2).toString(),
                        contactTable.getValueAt(getSelectedRow(), 3).toString(),
                        contactTable.getValueAt(getSelectedRow(), 4).toString()
                );
                updframe.setVisible(true);
                updframe.setLocationRelativeTo(null);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                removeEntry();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                System.exit(0);
            }
        });

        MainPanel.add(buttonPanel, BorderLayout.NORTH);
        MainPanel.setPreferredSize(new Dimension(900, 400));

        add(MainPanel);
    }

   public static void addEntry(AddressBookDTO addressbookdto) {
       contactTable.setValueAt(addressbookdto.getfName(), rowCount, 0);
       contactTable.setValueAt(addressbookdto.getlName(), rowCount, 1);
       contactTable.setValueAt(addressbookdto.getAddress(), rowCount, 2);
       contactTable.setValueAt(addressbookdto.getcontact(), rowCount, 3);
       contactTable.setValueAt(addressbookdto.getEmail(), rowCount, 4);


       rowCount++;
    }

    public static void editEntry(AddressBookDTO addressbookdto) {
        contactTable.setValueAt(addressbookdto.getfName(), getSelectedRow(), 0);
        contactTable.setValueAt(addressbookdto.getlName(), getSelectedRow(), 1);
        contactTable.setValueAt(addressbookdto.getAddress(),getSelectedRow(), 2);
        contactTable.setValueAt(addressbookdto.getcontact(), getSelectedRow(), 3);
        contactTable.setValueAt(addressbookdto.getEmail(), getSelectedRow(), 4);

    }

    public void removeEntry() {
        for(int i = getSelectedRow(); i < rowCount; i++) {
            contactTable.setValueAt(contactTable.getValueAt(i + 1, 0), i, 0);
            contactTable.setValueAt(contactTable.getValueAt(i + 1, 1), i, 1);
            contactTable.setValueAt(contactTable.getValueAt(i + 1, 2), i, 2);
            contactTable.setValueAt(contactTable.getValueAt(i + 1, 3), i, 3);
            contactTable.setValueAt(contactTable.getValueAt(i + 1, 4), i, 4);
        }
        rowCount--;
    }

    public static int getSelectedRow() {
        contactTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel rowSel = contactTable.getSelectionModel();
        rowSel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;

                ListSelectionModel sel = (ListSelectionModel)e.getSource();
                if (!sel.isSelectionEmpty()) {
                    selectRow = sel.getMinSelectionIndex();
                }
            }
        });

        return selectRow;
    }

    class AbstractTable extends AbstractTableModel {
        private String[] columnNames = { "First Name","Last Name", "Address", "Contact", "Email"};
        private Object[][] data = new Object[20][6];

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {

            return data.length;
        }

        public String getColumnName(int col) {

            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {

            return data[row][col];
        }

        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }

    }

    public static void main(String args[]) {
        JFrame jFrame = new JFrame("Address Book");
        jFrame.setSize(1050,600);
        
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.getContentPane().add(new AddressBookMenu());
        jFrame.pack();
        jFrame.setVisible(true);
    }
} 
