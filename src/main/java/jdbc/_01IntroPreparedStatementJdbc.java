package jdbc;

import java.sql.*;

public class _01IntroPreparedStatementJdbc {
    public static String URL = "jdbc:mysql://localhost:3306/study";
    public static String ROOT = "root";
    public static String PASSWORD = "1595";

    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Person("Oleh", "Mischenko", "Main 353", "Lviv");

        try (Connection connection = DriverManager.getConnection(URL, ROOT, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Persons(LastName,FirstName,Address,City) VALUES(?,?,?,?)")) {
            statement.setString(1, person.getLastName());
            statement.setString(2, person.getFirstName());
            statement.setString(3, person.getAddress());
            statement.setString(4, person.getCity());

            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


