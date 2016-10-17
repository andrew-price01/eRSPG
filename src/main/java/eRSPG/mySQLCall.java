package eRSPG;

import java.sql.*;

/**
 * Created by oburgoyne on 10/13/2016.
 */
public class mySQLCall {

    public static void main(String[] args) throws SQLException {

        Connection connect = null;

        try {

            //Register the JDBC driver
            //Class.forName("com.mysql.jdbc.Driver");

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.printf("Driver is loaded");

            //Establish the connection to the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/erspg", "root", "password");
            System.out.println("Connection established.");

            //Executing SQL Statements
            Statement query = connect.createStatement();
            ResultSet rs = query.executeQuery("select * from USER");

            System.out.println("UserID\temail\tuserfirstname\tuserlastname");
            while(rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
            }

            String sqlInsert = "insert into user (email, firstname, lastname) values ('blah@blah.com', 'Orion', 'Burgoyne')";
            query.execute(sqlInsert);
            while(rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
            }

            sqlInsert = "insert into user (email, firstname, lastname) values ( ?, ?)";
            PreparedStatement ps = connect.prepareStatement(sqlInsert);
            query.execute(sqlInsert);
            ps.setString(1, "John");
            ps.setString(2, "Smith");
            ps.execute();
            ps.clearParameters();

            rs = query.executeQuery("select * from USER");

            while(rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
            }

        } catch(SQLException error) {
            System.err.println("Couldn't connect to database.");
        }
    }


}
