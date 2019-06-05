import java.awt.*;
import java.sql.*;

public class Process {

    public Statement connect(String user, String password, Frame ui) {
        // 驱动程序名
        String driver = "org.mariadb.jdbc.Driver";
        // URL指向要访问的数据库名world
        String url = "jdbc:mariadb://localhost:3306/sqltestdb";

        Connection conn = null;
        Statement statement = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 连续数据库
            conn = DriverManager.getConnection(url, user, password);

            statement = conn.createStatement();

            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");

        } catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
        } catch(SQLException e) {
            if( user != null && password != null ) {
                new UI().notice("Please input username or password!", ui);
            }else {
                System.out.println("Something wrong with SQL sentence!");
            }
        }
        return statement;
    }
}
