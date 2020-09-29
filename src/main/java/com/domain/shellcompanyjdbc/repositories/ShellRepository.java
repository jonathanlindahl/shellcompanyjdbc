package com.domain.shellcompanyjdbc.repositories;

import com.domain.shellcompanyjdbc.database.Connector;
import com.domain.shellcompanyjdbc.models.Shell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShellRepository
{
    public ShellRepository() {}
    
    private Shell makeShell(ResultSet rs) throws SQLException
    {
        return new Shell(
                rs.getLong("id"),
                rs.getString("manufacturer"),
                rs.getString("model"),
                rs.getString("name"),
                rs.getInt("price"));
    }
    
    public List<Shell> getShells()
    {
        List<Shell> shells = new ArrayList<>();
        try (
                Connection connection = Connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM shells");
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet != null && resultSet.next())
                shells.add(makeShell(resultSet));
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return shells;
    }
    
    public List<Shell> getByModel(String model)
    {
        List<Shell> shells = new ArrayList<>();
        try (
                Connection connection = Connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        String.format(
                                "SELECT * FROM shells WHERE model = '%s'",
                                model));
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet != null && resultSet.next())
                shells.add(makeShell(resultSet));
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return shells;
    }

    public Shell addShell(Shell shell)
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "INSERT INTO shells VALUES (%d, '%s', '%s', '%s', %d)",
                    shell.getId(),
                    shell.getManufacturer(),
                    shell.getModel(),
                    shell.getName(),
                    shell.getPrice());
            statement.executeUpdate(sql);
            System.out.println("Added: " + shell.toString());
        } catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                }
        }
        return shell;
    }
}
