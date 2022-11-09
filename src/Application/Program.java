package Application;

import Entities.DbIntegrityException;

import java.sql.*;

public class Program {

    public static void main(String[] args) {

        try {
            Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase", "root", "eduardop$filho");
            PreparedStatement pst = conn.prepareStatement("DELETE FROM department "
                    + " WHERE (Id = ?)");

            pst.setInt(1, 5);

            int rowsAffected = pst.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);

        }
        catch (RuntimeException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
