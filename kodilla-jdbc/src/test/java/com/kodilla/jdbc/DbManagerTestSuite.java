package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException{
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while (rs.next()){
            System.out.println(rs.getInt("ID") + "," +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5,counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT i.FIRSTNAME, i.LASTNAME, COUNT(u.DESCRIPTION) AS POSTCOUNT FROM ISSUES u " +
                "JOIN USERS i on i.ID = u.USER_ID_ASSIGNEDTO " +
                "GROUP BY i.FIRSTNAME, i.LASTNAME " +
                "HAVING POSTCOUNT > 1;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()){
            System.out.println(rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME") +
                    ": " + rs.getInt("POSTCOUNT"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(4,counter);
    }
}
