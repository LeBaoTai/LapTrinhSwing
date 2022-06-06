package DAL;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccess {
    private String __dbName;
    private String __dbHostName;
    private String __dbPort;
    private String __dbUsername;
    private String __dbPassword;

    private Connection __conn;
    // tao ket noi voi db
    public DatabaseAccess () {
        checkDriver();
        config();
        setConn();
    }

    public void checkDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Tim thay driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void config() {
        this.__dbHostName = "localhost";
        this.__dbName = "quanlysinhvien";
        this.__dbPassword = "";
        this.__dbUsername = "root";
        this.__dbPort = "3306";
    }

    public void setConn() {
//        final String url = "jdbc:mysql://localhost:3306/quanlysinhvien";
        try {
            String connURL = String.format("jdbc:mysql://%s:%s/%s",
                    __dbHostName, __dbPort, __dbName);
            __conn = DriverManager.getConnection(connURL, __dbUsername, __dbPassword);
            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return __conn;
    }
}
