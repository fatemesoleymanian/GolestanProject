package GolestanModel.repository;
import GolestanModel.entity.StdEnti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StdRepo implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public StdRepo()throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","golestansystem","myjava123");
        connection.setAutoCommit(false);
    }

    public List<StdEnti> selectHalf()throws Exception{
        preparedStatement= connection.prepareStatement("select * from halfreporttable");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<StdEnti> stdEntiList=new ArrayList<>();
        while (resultSet.next ()){
            StdEnti stdEnti=new StdEnti ();
            stdEnti.setStdNum (resultSet.getString ("num"));
            stdEnti.setStdName(resultSet.getString ("name"));
            stdEnti.setGender (resultSet.getString ("gender"));
            stdEnti.setFatherName (resultSet.getString ("father name"));
            stdEnti.setNationalId(resultSet.getString("national id"));
            stdEnti.setBirthDate(resultSet.getString("birth date"));
            stdEnti.setEntryTerm(resultSet.getString("Entry Term"));
            stdEntiList.add (stdEnti);
        }
        return stdEntiList;
    }
    public List<StdEnti> selectFull()throws Exception{
        preparedStatement= connection.prepareStatement("select * from fullreporttable");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List <StdEnti> stdEntiList=new ArrayList<>();
        while (resultSet.next ()){
            StdEnti stdEnti=new StdEnti ();
            stdEnti.setStdNum (resultSet.getString ("num"));
            stdEnti.setStdName(resultSet.getString ("name"));
            stdEnti.setGender (resultSet.getString ("gender"));
            stdEnti.setFatherName (resultSet.getString ("father name"));
            stdEnti.setNationalId(resultSet.getString("national id"));
            stdEnti.setBirthDate(resultSet.getString("birth date"));
            stdEnti.setEntryTerm(resultSet.getString("Entry Term"));
            stdEntiList.add (stdEnti);
        }
        return stdEntiList;
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
