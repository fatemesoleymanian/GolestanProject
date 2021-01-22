package GolestanModel.repository;
import GolestanController.EntrancePage;
import GolestanController.StudentMenu;
import GolestanModel.entity.StdEnti;
import GolestanModel.service.EmpSrv;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StdRepo implements AutoCloseable {
    private final Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","golestansystem","myjava123");
    private PreparedStatement preparedStatement;
    public StdRepo()throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection.setAutoCommit(false);
    }
    public StdRepo(String s)throws Exception{ }
    public ObservableList<String> selectHalf()throws Exception{
        preparedStatement= connection.prepareStatement("select *from halfreporttable");
        ResultSet resultSet=preparedStatement.executeQuery();
        ObservableList<String> stdEntiList;
        stdEntiList=FXCollections.observableArrayList();
        while(resultSet.next()){
            StdEnti stdEnti=new StdEnti ();
            stdEnti.setStdNum (resultSet.getString ("stdnum"));
            stdEnti.setStdName(resultSet.getString ("stdname"));
            stdEnti.setGender (resultSet.getString ("gender"));
            stdEnti.setFatherName (resultSet.getString ("fathername"));
            stdEnti.setNationalId(resultSet.getString("nationalid"));
            stdEnti.setBirthDate(resultSet.getString("birthdate"));
            stdEnti.setEntryTerm(resultSet.getString("entryterm"));
            stdEntiList.add(stdEnti.getStdNum()+"\t"+ stdEnti.getStdName()+ "\t"+stdEnti.getEntryTerm());
        }
        return stdEntiList;
    }
    public ObservableList<String> payment()throws Exception{
        preparedStatement= connection.prepareStatement("update paymenttable set paystdnum=?");
        preparedStatement.setString(1,EntrancePage.userName);
        preparedStatement.executeUpdate();
        preparedStatement.setString(1,EntrancePage.userName);
        preparedStatement= connection.prepareStatement("select paymentid,paymentterm,bankname,paymentamount,paystdnum from paymenttable");
        ResultSet resultSet=preparedStatement.executeQuery();
        ObservableList<String> paymentInfoList=FXCollections.observableArrayList();
        while(resultSet.next()){
            String s1=resultSet.getString("paymentid");
            String s2=resultSet.getString("paymentterm");
            String s3=resultSet.getString("bankname");
            String s4=resultSet.getString("paymentamount");
            String s5=resultSet.getString("paystdnum");
            paymentInfoList.add(s1+"\t\t"+s2+"\t\t"+s3+"\t\t"+s4+"\t\t"+s5);
        }
        return paymentInfoList;
    }
    public ObservableList<String> selectFull()throws Exception{
        preparedStatement= connection.prepareStatement("select * from fullreporttable");
        ResultSet resultSet=preparedStatement.executeQuery ();
        ObservableList<String> stdEntiList;
        stdEntiList = FXCollections.observableArrayList();

        while (resultSet.next ()){
            StdEnti stdEnti=new StdEnti ();
            stdEnti.setStdNum (resultSet.getString ("stdnum"));
            stdEnti.setStdName(resultSet.getString ("stdname"));
            stdEnti.setGender (resultSet.getString ("gender"));
            stdEnti.setFatherName (resultSet.getString ("fathername"));
            stdEnti.setNationalId(resultSet.getString("nationalid"));
            stdEnti.setBirthDate(resultSet.getString("birthdate"));
            stdEnti.setEntryTerm(resultSet.getString("entryterm"));
            stdEnti.setAverage(resultSet.getString("average"));
            stdEnti.setPassedUnits(resultSet.getString("passedunits"));
            stdEntiList.add(stdEnti.getStdNum()+"\t"+ stdEnti.getStdName()+ "\t"+stdEnti.getEntryTerm()+"\t"+ stdEnti.getAverage()+"\t"+stdEnti.getPassedUnits());
        }
        return stdEntiList;
    }

    public ObservableList<String> selectFullInfo()throws Exception{
        preparedStatement= connection.prepareStatement("select * from fullreporttable");
        ResultSet resultSet=preparedStatement.executeQuery ();
        ObservableList<String> stdEntiList;
        stdEntiList = FXCollections.observableArrayList();

        while (resultSet.next ()){
            StdEnti stdEnti=new StdEnti ();
            stdEnti.setStdNum (resultSet.getString ("stdnum"));
            stdEnti.setStdName(resultSet.getString ("stdname"));
            stdEnti.setGender (resultSet.getString ("gender"));
            stdEnti.setFatherName (resultSet.getString ("fathername"));
            stdEnti.setNationalId(resultSet.getString("nationalid"));
            stdEnti.setBirthDate(resultSet.getString("birthdate"));
            stdEnti.setEntryTerm(resultSet.getString("entryterm"));
            stdEnti.setAverage(resultSet.getString("average"));
            stdEnti.setPassedUnits(resultSet.getString("passedunits"));
            stdEntiList.add(stdEnti.getStdNum()+"\t"+ stdEnti.getStdName()+"\t"+ stdEnti.getNationalId()+"\t"+stdEnti.getFatherName()+"\t"+stdEnti.getEntryTerm()+"\t"+ stdEnti.getAverage()+"\t"+stdEnti.getPassedUnits());
        }
        return stdEntiList;
    }
    public void insertReason(StdEnti stdEnti)throws Exception{
        preparedStatement= connection.prepareStatement("insert into deletetable(deletereason,year,stdid)values(?,?,?)");
        preparedStatement.setString(1,stdEnti.getDeleteReason());
        preparedStatement.setString(2, stdEnti.getYear());
        preparedStatement.setString(3,stdEnti.getStdID());
        preparedStatement.executeUpdate();
    }
    public void insertIntoFirstPageTable(StdEnti stdEnti)throws Exception{
        preparedStatement= connection.prepareStatement("insert into firstpagetable(username,password) values (?,?)");
        preparedStatement.setString(1,stdEnti.getUsername());
        preparedStatement.setString(2,stdEnti.getPassword());
        preparedStatement.executeUpdate();
    }
    public void updatePassword(StdEnti stdEnti)throws Exception{
        preparedStatement= connection.prepareStatement("update firstpagetable set password=?");
        preparedStatement.setString(1,stdEnti.getPassword());
        preparedStatement.executeUpdate();
    }
    public List<String> findPass()throws Exception{
        StudentMenu studentMenu=new StudentMenu();
        preparedStatement= connection.prepareStatement("select password from firstpagetable");
        ResultSet resultSet=preparedStatement.executeQuery();
        List<String> passList=new ArrayList<>();
        while (resultSet.next()){
            passList.add(resultSet.getString("password"));
        }
        return passList;

    }
    public void insertBankTable(StdEnti stdEnti)throws Exception{
        preparedStatement= connection.prepareStatement("insert into banktable(paymentAmount,cardNumber,cardSecondPass,cvv2,expireDay,expireYear)values(?,?,?,?,?,?)");
        preparedStatement.setString(1,stdEnti.getPaymentAmount());
        preparedStatement.setString(2,stdEnti.getCardNumber());
        preparedStatement.setString(3, stdEnti.getCardSecondPass());
        preparedStatement.setString(4,stdEnti.getCvv2());
        preparedStatement.setString(5, stdEnti.getExpireDay());
        preparedStatement.setString(6, stdEnti.getExpireYear());
        preparedStatement.executeUpdate();
    }
    public ObservableList<String> selectEngTable()throws Exception{
        preparedStatement= connection.prepareStatement("select * from engineeringtable");
        ResultSet resultSet=preparedStatement.executeQuery();
        ObservableList<String> engList=FXCollections.observableArrayList();
        while(resultSet.next()){
            String s1=resultSet.getString("unitname");
            String s2=resultSet.getString("unitcode");
            String s3= resultSet.getString("unitnum");
            engList.add(s1+"\t"+s2+"\t"+s3);
        }
        return engList;
    }
    public ObservableList<String> selectArtTable()throws Exception{
        preparedStatement= connection.prepareStatement("select * from arttable");
        ResultSet resultSet=preparedStatement.executeQuery();
        ObservableList<String> engList=FXCollections.observableArrayList();
        while(resultSet.next()){
            String s1=resultSet.getString("unitname");
            String s2=resultSet.getString("unitcode");
            String s3= resultSet.getString("unitnum");
            engList.add(s1+"\t"+s2+"\t"+s3);
        }
        return engList;
    }
    public ObservableList<String> selectHumTable()throws Exception{
        preparedStatement= connection.prepareStatement("select * from humanitiestable");
        ResultSet resultSet=preparedStatement.executeQuery();
        ObservableList<String> engList=FXCollections.observableArrayList();
        while(resultSet.next()){
            String s1=resultSet.getString("unitname");
            String s2=resultSet.getString("unitcode");
            String s3= resultSet.getString("unitnum");
            engList.add(s1+"\t"+s2+"\t"+s3);
        }
        return engList;
    }
    public void insertUnitResult(StdEnti stdEnti)throws Exception{
        preparedStatement= connection.prepareStatement("insert into unitresult(stdnum,unitcode)values(?,?)");
        preparedStatement.setString(1,stdEnti.getStdNum());
        preparedStatement.setString(2,stdEnti.getUnitCode());
        preparedStatement.executeUpdate();
    }

    public ObservableList<String> weeklySchedule()throws Exception{
        preparedStatement= connection.prepareStatement("select کوم فیلدا میشه؟ from  ");
        ObservableList<String> weekly=FXCollections.observableArrayList();
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            String s1=resultSet.getString("unitone");
            String s2=resultSet.getString("unittwo");
            String s3=resultSet.getString("unittree");
            String s4=resultSet.getString("unitfour");
            //4ta base

            weekly.add(s1+"****"+s2+"****"+s3+"****"+s4+"****");
        }
        return weekly;
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
