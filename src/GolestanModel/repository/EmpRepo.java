package GolestanModel.repository;

import GolestanModel.entity.EmpEnti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpRepo implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public EmpRepo()throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","golestansystem","myjava123");
        connection.setAutoCommit(false);
    }
    public void insert(EmpEnti empEnti)throws Exception{
        preparedStatement=connection.prepareStatement("insert into emptable(phonenumber,email,address,nationalcode,fathername,birthdate,name,num) values (?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, empEnti.getPhoneNumber());
        preparedStatement.setString(2, empEnti.getEmail());
        preparedStatement.setString(3, empEnti.getAddress());
        preparedStatement.setString(4, empEnti.getNationalCode());
        preparedStatement.setString(5, empEnti.getFatherName());
        preparedStatement.setString(6, empEnti.getBirthDate());
        preparedStatement.setString(7, empEnti.getName());
        preparedStatement.setString(8, empEnti.getNum());
        preparedStatement.executeUpdate();
    }
    public void commit() throws Exception{
        connection.commit ();
    }
    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
