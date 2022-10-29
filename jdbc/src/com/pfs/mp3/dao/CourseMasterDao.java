package com.pfs.mp3.dao;

import com.pfs.mp3.entity.CourseMaster;


import java.sql.*;

public class CourseMasterDao {
    /**
     * This method is to get the DB connection.
     * ClassNotFoundException will be thrown when the application can't locate the class
     * com.mysql.cj.jdbc.Driver
     * SQLException will be thrown when there is any SQL error.
     * in this case, the exception will be thrown if the DB doesn't exist or invalid login credential
     * @return Connection
     * @throwns ClassNotFoundException\
     * @throwns SQLException
     */

    private Connection getConnection() throws ClassNotFoundException,
            SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");  //DriverManger class to acquire JDBC connection
        //DB Connection URL with Server, port, DB Name, SSL Connection type and Server time zone
        String dbUrl = "jdbc:mysql://localhost:3306/pfs?useSSL=false&serverTimezone=UTC";
        String dbUser = "root";             // MySOL DB User Name
        String dbPassword = "lwencong81";       // MySQL DB Password
        //Acquiring connection using dbUrl, User, and Password
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        return conn;
    }

    public int insert(CourseMaster c) throws ClassNotFoundException, SQLException{
        Connection conn = this.getConnection();
        int rowsInserted = -1;
        String sql ;
        // SQL script to insert record into the course table with the parameter
        // id - Is a auto increment field. It will be inserted automatically
        // Table Name and column name must match with DB definition
        sql = "INSERT INTO coursemaster (course_name, course_text)" +
                "VALUES (?, ?)";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        // No of ? must match with the column name
        // No of ? indicates the no of parameter's value to execute the SQL statement
        // Parameter index starts from 1.
        // First parameter is the course name of the course entity
        pstmt.setString( 1,c.getName());
        // Second parameter is the course text of the course entity
        pstmt.setString( 2,c.getText());

        // returns the number of records inserted
        rowsInserted = pstmt.executeUpdate();
        return rowsInserted;
    }
    public ResultSet fetch() throws ClassNotFoundException, SQLException{
        Connection conn = this.getConnection();

        String sql;
        sql = "SELECT * FROM CourseMaster";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    public int update(CourseMaster c, String id) throws ClassNotFoundException, SQLException {
        Connection conn = this.getConnection();

        String sql = "UPDATE CourseMaster SET Course_Name=?, Course_Text=? WHERE Course_Id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, c.getName());
        pstmt.setString(2, c.getText());
        pstmt.setString(3, id);

        int rowsUpdated = pstmt.executeUpdate();
        return rowsUpdated;
    }
    public int remove(String id) throws ClassNotFoundException, SQLException {
        Connection conn = this.getConnection();

        String sql = "DELETE FROM CourseMaster WHERE Course_Id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);

        int rowsDeleted = pstmt.executeUpdate();
        return rowsDeleted;

    }


//    public int update(CourseMaster c) throws ClassNotFoundException, SQLException{
//        Connection conn = this.getConnection();
//        int rowsInserted = -1;
//        String sql ;
//        // SQL script to insert record into the course table with the parameter
//        // id - Is a auto increment field. It will be inserted automatically
//        // Table Name and column name must match with DB definition
//        sql = "INSERT INTO coursemaster (course_name, course_text)" +
//                "VALUES (?, ?)";
//        PreparedStatement pstmt=conn.prepareStatement(sql);
//        // No of ? must match with the column name
//        // No of ? indicates the no of parameter's value to execute the SQL statement
//        // Parameter index starts from 1.
//        // First parameter is the course name of the course entity
//        pstmt.setString( 1,c.getName());
//        // Second parameter is the course text of the course entity
//        pstmt.setString( 2,c.getText());
//
//        // returns the number of records inserted
//        rowsInserted = pstmt.executeUpdate();
//        return rowsInserted;
//    }

//    public ResultSet fetch() throws ClassNotFoundException, SQLException {
//        Connection conn = this.getConnection();
//        String sql;
//        sql = "SELECT * FROM CourseMaster";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        ResultSet rs = pstmt.executeQuery();
//        return rs;
//
//        allowPublicKeyRetrieval=true
//    }

}

