package com.dandan.mapper.test;

import org.junit.Test;

import java.sql.*;

/**
 * Created by dandan On 八月 24 2019
 */
public class JdbcConnection<T> {

    private static final String driveName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/dandan_01";
    private static final String userName = "root";
    private static final String passwrd = "p@swrd123";

    public Connection connection = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    @Test
    public void connJDBCTest(){

        try {
            //1、注册驱动
            Class.forName(driveName);
            //2、创建连接
            connection = DriverManager.getConnection(url,userName,passwrd);
            //3、预定义
            String sql = "select * from t_user";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            if(resultSet != null){
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("user_name"));
                    System.out.println(resultSet.getString("password"));
                    System.out.println(resultSet.getString("mobile"));
                    System.out.println(resultSet.getInt("age"));
                    System.out.println(resultSet.getString("sex"));

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                close();
            } catch (SQLException e) {
                System.out.println("资源关闭失败");
            }
        }
    }


    public void close() throws SQLException{
        if (this.preparedStatement != null) {
            this.preparedStatement.close();
        }

        if(this.resultSet != null){
            this.resultSet.close();
        }

        //关闭连接
        if(this.connection != null){
            this.connection.close();
        }
    }

}
