package GolestanModel.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TeacherRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public TeacherRepo()throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","golestansystem","myjava123");
        connection.setAutoCommit(false);
    }
}
