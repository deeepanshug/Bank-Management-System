package gui;

import constants.CommonConstants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends Frame{

    private long cardNum,pinNum;
    private String userName;

    public MiniStatement(long cardNum, long pinNum) {

        super("Mini Statement");
        setSize(500,600);
        this.cardNum = cardNum;
        this.pinNum = pinNum;
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addGuiComponent();
        getContentPane().setBackground(Color.WHITE);
    }

    private void addGuiComponent() {

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel,BoxLayout.Y_AXIS));

        //Bank Name Label
        JLabel bankNameLabel = new JLabel("HDFC");
        bankNameLabel.setFont(new Font("Raleway",Font.BOLD,18));
        bankNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankNameLabel, BorderLayout.NORTH);

        // Table model to hold data
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20,20,500,200);
        add(scrollPane, BorderLayout.SOUTH);


        String getNameQuery = "Select Name from users where Card_No = ?";
        String query = "Select Date,Type,Amount,Balance from bank_statements where Card_No = ?";

        try{
            Connection connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
            PreparedStatement fetchData = connection.prepareStatement(query);
            fetchData.setLong(1,cardNum);

            try (ResultSet result = fetchData.executeQuery()) {
                ResultSetMetaData metaData = result.getMetaData();
                int columnCount = metaData.getColumnCount();

                for(int i=1; i<=columnCount; i++) {
                    tableModel.addColumn(metaData.getColumnName(i));
                }

                while(result.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        rowData[i - 1] = result.getObject(i);
                    }
                    tableModel.addRow(rowData);
                }
            }
            fetchData = connection.prepareStatement(getNameQuery);
            fetchData.setLong(1,cardNum);
            ResultSet result = fetchData.executeQuery();

            while (result.next()) {
                userName = result.getString(1);
            }
            fetchData.close();
            connection.close();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        //Card Label
        JLabel cardLabel = new JLabel("Card Number : " + cardNum);
        cardLabel.setFont(new Font("Raleway",Font.BOLD,15));
        //User Name Label
        JLabel userNameLabel = new JLabel("Name : " + userName);
        userNameLabel.setFont(new Font("Raleway",Font.BOLD,15));

        labelPanel.add(userNameLabel);
        labelPanel.add(cardLabel);
        add(labelPanel,BorderLayout.CENTER);
    }
}
