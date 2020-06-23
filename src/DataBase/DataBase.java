package DataBase;

import java.io.UnsupportedEncodingException;
import java.sql.*;

public class DataBase {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/javaee?serverTimezone=UTC&&characterEncoding=utf8&useSSL=true";
    static final String USER = "root";
    static final String PASS = "123";

    public DataBase(){
        try {
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("connecting...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            if(!connection.isClosed())
                System.out.println("Succeeded connecting to the Database!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void Clocec(){
        try {
            if (connection != null){
                connection.close();
            }
            else if (preparedStatement !=null){
                preparedStatement.close();
            }
            else if (resultSet != null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean login(String name,String psw) throws UnsupportedEncodingException {

        System.out.println("\n\n=======================HANDLING LOGIN\n\n");
        String select = "SELECT * FROM uname_psw WHERE uname = ? AND psw= ? ";
        System.out.println(select);
        boolean bool = false;
        try {
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,psw);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                bool = true;
                System.out.println("\n\nUSER EXISTS\n\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bool;
    }

    public boolean adlogin(String name,String psw) throws UnsupportedEncodingException {

        String adselect = "SELECT * FROM uname_psw WHERE uname = ? AND psw= ? AND admin = 1";
        System.out.println(adselect);
        boolean admin = false;
        try {
            preparedStatement = connection.prepareStatement(adselect);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,psw);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                admin = true;
                System.out.println("\n\nUSER EXISTS\n\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL,USER,PASS);
    }

    public static ResultSet executeQuery(String SQL){
        try {
            Connection conn=getConnection();
            Statement stmt=conn.createStatement();
            return stmt.executeQuery(SQL);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static boolean executeUpdate(String SQL){
        try {
            Connection conn=getConnection();
            Statement stmt=conn.createStatement();
            int result=stmt.executeUpdate(SQL);
            if(result>0)
                return true;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("fail");
        }
        return false;
    }
}
