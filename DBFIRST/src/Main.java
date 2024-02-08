import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection(
                 "jdbc:mysql://localhost/test",
                 "root",
                 "17041976father"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
