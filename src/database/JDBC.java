package database;

import constants.CommonConstants;

import java.sql.*;

public class JDBC {

    private static Connection connection;
    private static PreparedStatement insertUser, userCheck;


    public static void register(String accountNo, String name, String fatherName, String dob, String email, String address, String city, String state,
                                   String pincode, String gender, String marital, String religion, String category, String income, String education,
                                   String occupation, String panNum, String aadhaar, String senior, String existingAccount) {

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL, CommonConstants.db_username,CommonConstants.db_password);
            insertUser = connection.prepareStatement("INSERT INTO "+ CommonConstants.db_users_table+ "(Account_No, Name, Fathers_Name, DOB, Email, Address, City, State," +
                    " Pincode, Gender, Marital, Religion, Category, Income, Education, Occupation, Pan_NO, Aadhaar_NO, Senior, Existing_Account)" +
             "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            insertUser.setString(1,accountNo);
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
            insertUser.setString(12,religion);
            insertUser.setString(13,category);
            insertUser.setString(14,income);
            insertUser.setString(15,education);
            insertUser.setString(16,occupation);
            insertUser.setString(17,panNum);
            insertUser.setString(18,aadhaar);
            insertUser.setString(19,senior);
            insertUser.setString(20,existingAccount);

            insertUser.executeUpdate();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        finally {
            try{
                if(insertUser != null) insertUser.close();
                if(connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean checkIfUserExists(String name, String fatherName, String email, String pincode, String gender){

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
            String query = "SELECT * FROM users WHERE Name = ? AND Fathers_Name = ? AND Email = ? AND Pincode = ? AND Gender = ?";
            userCheck = connection.prepareStatement(query);
            userCheck.setString(1,name);
            userCheck.setString(2,fatherName);
            userCheck.setString(3,email);
            userCheck.setString(4,pincode);
            userCheck.setString(5,gender);

            ResultSet result = userCheck.executeQuery();

            //Check if the user exists in the resultset or not
            return result.isBeforeFirst();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
}
