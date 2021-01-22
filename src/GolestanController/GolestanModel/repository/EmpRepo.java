package GolestanModel.repository;

import GolestanModel.entity.EmpEnti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpRepo implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public EmpRepo()throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","golestansystem","myjava123");
        connection.setAutoCommit(false);
    }
    public ObservableList<String> showAllDocs()throws Exception{
        preparedStatement= connection.prepareStatement("select * from docstable");
        ObservableList<String> docsList=FXCollections.observableArrayList();
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            String s1=resultSet.getString("doctype");
            String s2=resultSet.getString("docnum");
            docsList.add(s1+"\t***\t"+s2);
        }
        return docsList;
    }
    public void insertEmpTable(EmpEnti empEnti)throws Exception{
        preparedStatement=connection.prepareStatement("insert into emptable(empname,empnum,address,nationalcode,fathername,birthdate,phonenumber,email,military,education,religion,nativeland,maritialstatus)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, empEnti.getEmpName());
        preparedStatement.setString(2, empEnti.getEmpNum());
        preparedStatement.setString(3, empEnti.getAddress());
        preparedStatement.setString(4, empEnti.getNationalCode());
        preparedStatement.setString(5, empEnti.getFatherName());
        preparedStatement.setString(6, empEnti.getBirthDate());
        preparedStatement.setString(7, empEnti.getPhoneNumber());
        preparedStatement.setString(8, empEnti.getEmail());
        preparedStatement.setString(9, empEnti.getMilitary());
        preparedStatement.setString(10, empEnti.getEducation());
        preparedStatement.setString(11, empEnti.getReligion());
        preparedStatement.setString(12, empEnti.getNativeLand());
        preparedStatement.setString(13, empEnti.getMaritialStatus());
        preparedStatement.executeUpdate();
    }
    public void insertBreakTable(EmpEnti empEnti)throws Exception{
        preparedStatement=connection.prepareStatement("insert into breaktable(reasonofbreak,breaktime)values(?,?)");
        preparedStatement.setString(1,empEnti.getReasonOfBreak());
        preparedStatement.setString(2, empEnti.getBreakTime());
        preparedStatement.executeUpdate();
    }
    public void insertLoanTable(EmpEnti empEnti)throws Exception{
        preparedStatement=connection.prepareStatement("insert into loantable(loanamount,persontoguarantee,loannumber)values(?,?,?)");
        preparedStatement.setString(1, empEnti.getLoanAmount());
        preparedStatement.setString(2,empEnti.getPersonToGuarantee());
        preparedStatement.setString(3, empEnti.getLoanNumber());
        preparedStatement.executeUpdate();
    }
    public void insertDoc(EmpEnti empEnti)throws Exception{
        preparedStatement= connection.prepareStatement("insert into docstable(doctype,docnum)values(?,?)");
        preparedStatement.setString(1, empEnti.getDoctype());
        preparedStatement.setString(2, empEnti.getDocnum());
        preparedStatement.executeUpdate();
    }
    public ObservableList<String> selectLastState()throws Exception{
        preparedStatement= connection.prepareStatement("select * from emplaststate");
        ResultSet resultSet=preparedStatement.executeQuery();
        ObservableList<String> lastStateList= FXCollections.observableArrayList();
        while(resultSet.next()){
            String s1=resultSet.getString("empnum");
            String s2=resultSet.getString("empstate");
            lastStateList.add(s1+"\t***\t"+s2);
        }
        return lastStateList;
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
