package com.mayikt.jdbc.demo1;
import com.mysql.jdbc.Driver;

import java.sql.*;

public class JDBCdemo01
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        1.导入mysql驱动jar包;
//        2.注册驱动 javase 反射机制Class.forName()
        Class.forName("com.mysql.jdbc.Driver");
//        3.获取数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/meite?serverTimezone=UTC","root","123456");
//        4.获取执行者对象
        Statement statement=connection.createStatement();
//        5.执行sql语句并获取返回结果
        ResultSet resultSet = statement.executeQuery("select * from mayikt_users");
//        6.对结果进行处理
        while (resultSet.next()){



            System.out.println("id:"+resultSet.getInt("id")+","
                    +"name"+resultSet.getString("name")+','+
                    "pwd"+  resultSet.getString("pwd")
            );
        }
//        7.释放jdbc资源
connection.close();
        statement.close();
    }
}
