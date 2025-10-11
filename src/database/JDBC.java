package database;

import constants.CommonConstants;
import gui.TransactionsPage;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.*;

public class JDBC {

    private static Connection connection;
    private static PreparedStatement insertUser, updateStatement,fetchData, userCheck, fetchBalance;


    public static void registerFormOneDetails(long accountNo, String name, String fatherName, String dob, String email, String address, String city, String state,
                                   String pincode, String gender, String marital) {

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL, CommonConstants.db_username,CommonConstants.db_password);
            insertUser = connection.prepareStatement("INSERT INTO "+ CommonConstants.db_users_table+ "(Account_No, Name, Fathers_Name, DOB, Email, Address, City, State," +
                    " Pincode, Gender, Marital)" +
             "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            insertUser.setLong(1,accountNo);
            insertUser.setString(2,name);
            insertUser.setString(3,fatherName);
            insertUser.setString(4,dob);
            insertUser.setString(5,email);
            insertUser.setString(6,address);
            insertUser.setString(7,city);
            insertUser.setString(8,state);
            insertUser.setString(9,pincode);
            insertUser.setString(10,gender);
            insertUser.setString(11,marital);

            insertUser.executeUpdate();
            insertUser.close();
            connection.close();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public static void registerFormTwoDetails(String religion, String category, String income, String education,
                                              String occupation, String panNum, String aadhaar, String senior, String existingAccount,long accountNo) {

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL, CommonConstants.db_username,CommonConstants.db_password);
            String query = "UPDATE "+CommonConstants.db_users_table+" SET Religion = ?, Category = ?, Income = ?, " +
                    "Education = ?, Occupation = ?, Pan_NO = ?, Aadhaar_NO = ?, Senior = ?, Existing_Account = ? WHERE Account_No = ?";
            insertUser = connection.prepareStatement(query);

            insertUser.setString(1,religion);
            insertUser.setString(2,category);
            insertUser.setString(3,income);
            insertUser.setString(4,education);
            insertUser.setString(5,occupation);
            insertUser.setString(6,panNum);
            insertUser.setString(7,aadhaar);
            insertUser.setString(8,senior);
            insertUser.setString(9,existingAccount);
            insertUser.setLong(10,accountNo);

            insertUser.executeUpdate();
            insertUser.close();
            connection.close();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public static void registerFormThreeDetails(String accountType, long cardNum, long pinNum, String requiredServices, long accountNo) {

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
            String query = "UPDATE "+CommonConstants.db_users_table+" SET Account_Type = ?, Card_No = ?, Pin_No = ?, " +
                    "Required_Services = ? WHERE Account_No = ?";
            updateStatement = connection.prepareStatement(query);

            updateStatement.setString(1,accountType);
            updateStatement.setLong(2,cardNum);
            updateStatement.setLong(3,pinNum);
            updateStatement.setString(4,requiredServices);
            updateStatement.setLong(5, accountNo);

            updateStatement.executeUpdate();
            updateStatement.close();
            connection.close();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public static boolean checkIfUserExists(String name, String fatherName, String email, String pincode, String gender){

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
            String query = "SELECT * FROM users WHERE Name = ? AND Fathers_Name = ? AND Email = ? AND Pincode = ? AND Gender = ?";
            PreparedStatement userCheck = connection.prepareStatement(query);
            userCheck.setString(1,name);
            userCheck.setString(2,fatherName);
            userCheck.setString(3,email);
            userCheck.setString(4,pincode);
            userCheck.setString(5,gender);

            ResultSet result = userCheck.executeQuery();

//            userCheck.close();
//            connection.close();
            //Check if the user exists in the resultset or not
            return result.isBeforeFirst();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    public static boolean validateLogin(long cardNum, long pinNum) {

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
            String query = "SELECT * FROM " + CommonConstants.db_users_table+" WHERE Card_No = ? AND Pin_No = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,cardNum);
            statement.setLong(2,pinNum);

            ResultSet result = statement.executeQuery();
            if(result.next()) return true;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        return false;
    }

    public static long currBalance(long cardNum) {

        long ans = 0;
        try {
            connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
            String fetchCurrBalanceQuery = "Select Balance from bank_statements where Card_No = ?";

            fetchBalance = connection.prepareStatement(fetchCurrBalanceQuery);
            fetchBalance.setLong(1,cardNum);

            ResultSet result = fetchBalance.executeQuery();
            while(result.next()) {
                ans = result.getLong(1);
            }
            fetchBalance.close();
            connection.close();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return ans;
    }

    public static void depositAmount(long amount, String currentTime, long cardNum, String type) {

        long balance = 0;

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);

            String checkIfUserExistInBankStatements = "SELECT * FROM users WHERE Card_No = ?";
            String dataInsertionQuery = "Insert into bank_statements (Card_No, Date, Type, Amount, Balance)Values(?,?,?,?,?)";

            userCheck = connection.prepareStatement(checkIfUserExistInBankStatements);
            userCheck.setLong(1,cardNum);

            ResultSet result = userCheck.executeQuery();
            boolean ans = result.isBeforeFirst();       //Check if the user exists in the resultset or not


            if(!ans) {
                insertUser = connection.prepareStatement(dataInsertionQuery);
                insertUser.setLong(1,cardNum);
                insertUser.setString(2,currentTime);
                insertUser.setString(3,type);
                insertUser.setLong(4,amount);
                insertUser.setLong(5,amount);
                insertUser.executeUpdate();

            }
            else {
                balance = 0;
                String fetchBalanceQuery = "Select Balance from bank_statements where Card_No = ?";

                fetchBalance = connection.prepareStatement(fetchBalanceQuery);
                fetchBalance.setLong(1,cardNum);

                ResultSet resultBalance = fetchBalance.executeQuery();
                while(resultBalance.next()) {
                    balance = resultBalance.getLong(1);
                }

                long newBalance = balance + amount;
                fetchBalance.close();
                insertUser = connection.prepareStatement(dataInsertionQuery);
                insertUser.setLong(1,cardNum);
                insertUser.setString(2,currentTime);
                insertUser.setString(3,type);
                insertUser.setLong(4,amount);
                insertUser.setLong(5,newBalance);

                insertUser.executeUpdate();
            }
            userCheck.close();
            insertUser.close();
            connection.close();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public static void withdrawAmount(long amount, String currentTime, long cardNum, String type, long currBalance) {

        if(currBalance >= amount) {

            long newBalance = currBalance - amount;
            try {
                connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
                String queryToInsertTransaction = "Insert into bank_statements (Card_No, Date, Type, Amount, Balance)Values(?,?,?,?, ?)";

                insertUser = connection.prepareStatement(queryToInsertTransaction);
                insertUser.setLong(1,cardNum);
                insertUser.setString(2,currentTime);
                insertUser.setString(3,type);
                insertUser.setLong(4,amount);
                insertUser.setLong(5,newBalance);

                insertUser.executeUpdate();
                insertUser.close();
                connection.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Not Enough Balance");
        }
    }

    public static void pinChange(long cardNum, long newPin){

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
            String query = "Update users set Pin_No = ? where Card_No = ?";

            updateStatement = connection.prepareStatement(query);
            updateStatement.setLong(1,newPin);
            updateStatement.setLong(2,cardNum);

            updateStatement.executeUpdate();
            updateStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
