package DataBase;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.SerializedLambda;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            System.out.println("Sorry,can`t Connect!");
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
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
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bool;
    }

    public void UpdateDb(String db,String name,String password){
        try{
            this.connection = DriverManager.getConnection(JDBC_DRIVER+db,name,password);
        }catch (Exception e){
            System.out.println("Update fail"+e.getMessage());
        }
    }
}
