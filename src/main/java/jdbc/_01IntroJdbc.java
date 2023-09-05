package jdbc;

import java.sql.*;

public class _01IntroJdbc {
    public static final String ALL_USERS_QUERY = "SELECT PersonID, LastName, FirstName, Address, City FROM Persons";

    public static String URL = "jdbc:mysql://localhost:3306/study";
    public static String ROOT = "root";
    public static String PASSWORD = "1595";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, ROOT, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ALL_USERS_QUERY);

            while (resultSet.next()){
                int id = resultSet.getInt("PersonID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");
                System.out.println("id: " + id + " " + new Person(firstName, lastName, address, city));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}