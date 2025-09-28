package database;

import constants.CommonConstants;

import java.sql.*;

public class JDBC {

    private Connection connection;
    private Statement statement;

    public JDBC() {

        try{
            connection = DriverManager.getConnection(CommonConstants.db_URL,CommonConstants.db_username,CommonConstants.db_password);
//            statement = PreparedStatement
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
