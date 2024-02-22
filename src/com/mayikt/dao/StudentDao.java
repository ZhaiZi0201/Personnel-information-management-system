package com.mayikt.dao;

import com.mayikt.entity.StudentEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//com.mayikt.dao----数据库访问层----db打交道
public class StudentDao {
    /**
     * 学生对象数据库访问层
     */

    /**
     * 查询所有的学生信息
     *
     * @return
     */
    //查找所有学生信息
    public ArrayList<StudentEntity> allStudent() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //A.java连接mysql数据库查询所有数据
            //1.导入mysql驱动jar包;
            //2. 注册驱动 javase 反射机制Class.forName()
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3. 获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/meite?serverTimezone=UTC","root","123456");
            //4. 获取执行者对象
            statement = connection.createStatement();
            //5. 执行sql语句并获取返回结果
            resultSet = statement.executeQuery("select  * from mayikt_student");
            ArrayList<StudentEntity> studentEntities = new ArrayList<>();
            //6. 对结果进行处理
            while (resultSet.next()) { // 如果false结束该循环
                // 获取该行数据的第一列 id
                Long id = resultSet.getLong("id");
                // 获取该行数据的第二列 name
                String name = resultSet.getString("name");
                // 获取该行数据的第三列 age
                Integer age = resultSet.getInt("age");
                // 获取该行数据的第四列 address
                String address = resultSet.getString("address");
                // 将db中查询到数据封装成java学生对象
                StudentEntity studentEntity = new StudentEntity(id, name, age, address);
                // 将该对象存入到集合中
                studentEntities.add(studentEntity);
            }
            return studentEntities;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //  7. 释放jdbc资源
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
    /**
     * 根据学生id 查询学生信息 学生的id
     *
     */
    public StudentEntity getByIdStudent(Long stuId) {
        /**
         * 判断用户是否传递学生id的值
         */
        if (stuId == null) {
            return null;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //A.java连接mysql数据库查询所有数据
            //1.导入mysql驱动jar包;
            //2. 注册驱动 javase 反射机制Class.forName()
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3. 获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/meite?serverTimezone=UTC","root","123456");
            //4. 获取执行者对象
            statement = connection.createStatement();
            //5. 执行sql语句并获取返回结果 自己拼接 查询sql语句
            resultSet = statement.executeQuery("select  * from mayikt_student where id=" + stuId);
            boolean result = resultSet.next(); // 查询不到数据 false
            // 判断如果查询不到数据 则不会取值
            if (result==false) {
                return null;
            }
            //6. 对结果进行处理
            // 获取该行数据的第一列 id
            Long id = resultSet.getLong("id");
            // 获取该行数据的第二列 name
            String name = resultSet.getString("name");
            // 获取该行数据的第三列 age
            Integer age = resultSet.getInt("age");
            // 获取该行数据的第四列 address
            String address = resultSet.getString("address");
            // 将db中查询到数据封装成java学生对象
            StudentEntity studentEntity = new StudentEntity(id, name, age, address);
            return studentEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //  7. 释放jdbc资源
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

    /**
     * 插入我们的学生
     *
     * @param stu
     * @return
     */
    public int insertStudent(StudentEntity stu) {
        Connection connection = null;
        Statement statement = null;
        try {
            //A.java连接mysql数据库查询所有数据
            //1.导入mysql驱动jar包;
            //2. 注册驱动 javase 反射机制Class.forName()
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3. 获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/meite?serverTimezone=UTC","root","123456");
            //4. 获取执行者对象
            statement = connection.createStatement();
            //5. 执行sql语句并获取返回结果 executeUpdate执行 insert sql语句
            String insertStudentSql = "INSERT INTO mayikt_student values(null,'" + stu.getName() + "'," + stu.getAge() + ",'" + stu.getAddress() + "')";
            System.out.println("insertStudentSql:" + insertStudentSql);
            // log输出
            int result = statement.executeUpdate(insertStudentSql);
            // 执行该sql语句 影响行数
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            //  7. 释放jdbc资源
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 修改学生的信息
     *
     * @param stu
     * @return
     */
    public int updateStudent(StudentEntity stu) {
        Connection connection = null;
        Statement statement = null;
        try {
            //A.java连接mysql数据库查询所有数据
            //1.导入mysql驱动jar包;
            //2. 注册驱动 javase 反射机制Class.forName()
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3. 获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/meite?serverTimezone=UTC","root","123456");
            //4. 获取执行者对象
            statement = connection.createStatement();
            //5. 执行sql语句并获取返回结果 executeUpdate执行 update sql语句
            String updateStudentSql = "update mayikt_student  set name='" + stu.getName() + "' ,age=" + stu.getAge() + "," +
                    "address='" + stu.getAddress() + "' where id=" + stu.getId() + "";
            // log输出
            System.out.println("updateStudentSql:" + updateStudentSql);
            int result = statement.executeUpdate(updateStudentSql);
            // 执行该sql语句 影响行数
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            //  7. 释放jdbc资源
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //
    /**
     * 根据主键id删除学生信息
     *
     */
    public int delStudent(Long id) {
        // 判断id是否为null
        if (id == null) {
            return 0;
        }
        Connection connection = null;
        Statement statement = null;
        try {
            //A.java连接mysql数据库查询所有数据
            //1.导入mysql驱动jar包;
            //2. 注册驱动 javase 反射机制Class.forName()
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3. 获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/meite?serverTimezone=UTC","root","123456");
            //4. 获取执行者对象
            statement = connection.createStatement();
            //5. 执行sql语句并获取返回结果 executeUpdate执行 delete sql语句
            String delSQL = "delete from  mayikt_student where id=" + id;
            System.out.println("delSql:" + delSQL);
            // log输出
            int result = statement.executeUpdate(delSQL);
            // 执行该sql语句 影响行数
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            //  7. 释放jdbc资源
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
