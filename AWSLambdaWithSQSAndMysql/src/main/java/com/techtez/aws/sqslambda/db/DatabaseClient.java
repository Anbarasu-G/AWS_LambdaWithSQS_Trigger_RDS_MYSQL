package com.techtez.aws.sqslambda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import com.techtez.aws.sqslambda.model.College;

public class DatabaseClient {

    private static final Logger logger = Logger.getLogger(DatabaseClient.class.getName());

    private static final String URL = "jdbc:mysql://npg.cin6yya8adle.us-east-1.rds.amazonaws.com:3306/Anbarasu_db";
    private static final String USER = "admin";
    private static final String PASSWORD = "npgdb2520";

    
    public static void insertCollege(College college) {
        
    	String query = "INSERT INTO colleges (college_name, available_courses, place) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, college.getCollegeName());
            stmt.setString(2, String.join(",", college.getAvailableCourses()));
            stmt.setString(3, college.getPlace());

            stmt.executeUpdate();
            logger.info("Inserted college: " + college.getCollegeName());

        } catch (Exception e) {
            logger.severe("DB insert error: " + e.getMessage());
        }
    }
}
