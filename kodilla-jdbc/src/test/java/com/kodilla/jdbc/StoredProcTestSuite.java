package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        // When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        //Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER=NULL";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        // When
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER IS NOT NULL";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        //Then
        int howMany = 0;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertFalse(howMany == 0);
        rs.close();
        statement.close();
    }
}
