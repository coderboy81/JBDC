package com.pfs.mp3.dao;

import com.pfs.mp3.entity.CourseMaster;

import java.sql.SQLException;

public class CourseMasterTest {
    public static void main(String[] args) {
        //Instantiate CourseMasterDao
        CourseMasterDao dao = new CourseMasterDao();

        try {
            // Instantiate CourseMaster
            CourseMaster cm = new CourseMaster();
            // Set the values for the properties
            cm.setName("Front-End Web Development");
            cm.setText("HTML, CSS, JavaScript");
            // Call insert method to store the values in DB
            int rowsInserted = dao.insert(cm);
            if (rowsInserted == 1)
                System.out.println("CourseMaster inserted successfully");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }




    }
}

