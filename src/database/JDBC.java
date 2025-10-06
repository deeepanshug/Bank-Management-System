package database;

import constants.CommonConstants;

import java.sql.*;

public class JDBC {

    private static Connection connection;
    private static PreparedStatement insertUser, updateStatement;


    public static void registerFormOneDetails(String accountNo, String name, String fatherName, String dob, String email, String address, String city, String state,
                                   String pincode, String gender, String marital) {

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL, CommonConstants.db_username,CommonConstants.db_password);
            insertUser = connection.prepareStatement("INSERT INTO "+ CommonConstants.db_users_table+ "(Account_No, Name, Fathers_Name, DOB, Email, Address, City, State," +
                    " Pincode, Gender, Marital)" +
             "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
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

            insertUser.executeUpdate();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
//        finally {
//            try{
//                if(insertUser != null) insertUser.close();
//                if(connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void registerFormTwoDetails(String religion, String category, String income, String education,
                                              String occupation, String panNum, String aadhaar, String senior, String existingAccount,String accountNo) {

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
            insertUser.setString(10,accountNo);

            insertUser.executeUpdate();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
//        finally {
//            try{
//                if(insertUser != null) insertUser.close();
//                if(connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void registerFormThreeDetails(String accountType, String cardNum, String pinNum, String requiredServices, String accountNo) {

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
            String query = "UPDATE "+CommonConstants.db_users_table+" SET Account_Type = ?, Card_No = ?, Pin_No = ?, " +
                    "Required_Services = ? WHERE Account_No = ?";
            updateStatement = connection.prepareStatement(query);

            updateStatement.setString(1,accountType);
            updateStatement.setString(2,cardNum);
            updateStatement.setString(3,pinNum);
            updateStatement.setString(4,requiredServices);
            updateStatement.setString(5, accountNo);

            updateStatement.executeUpdate();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
//        finally{
//            try{
//                if(updateStatement != null) updateStatement.close();
//                if(connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
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
}
