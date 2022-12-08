package connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    // this page is used for db connection

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }

    // this is my own data base 
    // you can put your's to continue with login and register
    public void connectToDatabase() throws SQLException {
        String server = "localhost";
        String port = "3306";
        String database = "my_db";
        String userName = "root";
        String password = "1234";
        connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, userName, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
