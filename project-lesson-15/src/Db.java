import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db {
    private final static String URL = "jdbc:mysql://localhost/test";
    private final static String USER = "root";
    private final static String PASSWORD = "17041976father";
    private final static String COLUMN_FIRST_NAME = "firstName";

    public static void createUsersTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users(id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, firstName VARCHAR(25) NOT NULL, lastName VARCHAR(25) NOT NULL, address_id INT, FOREIGN KEY (address_id) REFERENCES addresses(id))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(connection, statement, null);
        }
    }
    public static void createAddressesTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS addresses(id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, street VARCHAR(50) NOT NULL, city VARCHAR(50) NOT NULL, state VARCHAR(50) NOT NULL, country VARCHAR(50) NOT NULL, zipCode VARCHAR(20) NOT NULL)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(connection, statement, null);
        }
    }

    public static void createUser(String firstName, String lastName, int addressId) {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO users(firstName, lastName, address_id) VALUES (?, ?, ?)");
        ) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, addressId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createUserOrUpdate(User user) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement;
            if (user.getId() == 0) {
                statement = connection.prepareStatement("INSERT INTO users(firstName, lastName, address_id) VALUES (?, ?, ?)");
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setInt(3, user.getAddress().getId());
            } else {
                statement = connection.prepareStatement("UPDATE users SET firstName=?, lastName=?, address_id=? WHERE id=?");
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setInt(3, user.getAddress().getId());
                statement.setInt(4, user.getId());
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString(COLUMN_FIRST_NAME);
                String lastName = resultSet.getString("lastName");
                int addressId = resultSet.getInt("address_id");
                Address address = getAddressById(addressId);
                users.add(new User(id, firstName, lastName, address));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static void deleteUser(int id) {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id=?");
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Address getAddressById(int addressId) {
        Address address = null;
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM addresses WHERE id=?");
        ) {
            statement.setInt(1, addressId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String country = resultSet.getString("country");
                String zipCode = resultSet.getString("zipCode");
                address = new Address(addressId, street, city, state, country, zipCode);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return address;
    }

    private static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int createAddress(Address address) {
        try (
                Connection connection = DriverManager.getConnection(Db.URL, Db.USER, Db.PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO addresses(street, city, state, country, zipCode) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, address.getStreet());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getState());
            statement.setString(4, address.getCountry());
            statement.setString(5, address.getZipCode());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
}