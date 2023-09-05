package jdbc;

import java.sql.*;

public class _01IntroInsertJdbc {
    public static String URL = "jdbc:mysql://localhost:3306/study";
    public static String ROOT = "root";
    public static String PASSWORD = "1595";

    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Person("Kiril", "Tymoshenko", "Avenue 37", "Kyiv");

        try (Connection connection = DriverManager.getConnection(URL, ROOT, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(
                    String.format("INSERT INTO Persons(LastName,FirstName,Address,City) VALUES('%s','%s','%s','%s')",
                            person.getLastName(),
                            person.getFirstName(),
                            person.getAddress(),
                            person.getCity()
                    )
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

