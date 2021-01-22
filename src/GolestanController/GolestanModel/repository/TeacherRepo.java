package GolestanModel.repository;

import GolestanController.TeacherMenu;
import GolestanModel.entity.StdEnti;
import GolestanModel.entity.TeacherEnti;
import GolestanModel.service.TeacherSrv;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherRepo implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;
    public TeacherRepo()throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","golestansystem","myjava123");
        connection.setAutoCommit(false);
    }
    public void insertScoreRegisterTable(TeacherEnti teacherEnti)throws Exception{
        preparedStatement= connection.prepareStatement("insert into scoreregistertable(stdname,stdnum,subjectcode,score)values (?,?,?,?)");
        preparedStatement.setString(1,teacherEnti.getStdName());
        preparedStatement.setString(2,teacherEnti.getStdNum());
        preparedStatement.setString(3,teacherEnti.getSubjectCode());
        preparedStatement.setString(4, teacherEnti.getScore());
        preparedStatement.executeUpdate();
    }
    public void deleteFromScoreRegisterTable(TeacherEnti teacherEnti)throws Exception{
        preparedStatement= connection.prepareStatement("delete from scoreRegistertable where stdnum=?");
        preparedStatement.setString(1,teacherEnti.getStdNum());
        preparedStatement.executeUpdate();
        preparedStatement=connection.prepareStatement("insert into Deletedstd(stdname,stdnum,deletetime,deletereason)values(?,?,?,?)");
        preparedStatement.setString(1,teacherEnti.getStdName());
        preparedStatement.setString(2, teacherEnti.getStdNum());
        preparedStatement.setString(3,teacherEnti.getDeleteTime());
        preparedStatement.setString(4, teacherEnti.getDeleteReason());
        preparedStatement.executeUpdate();
    }
    public ObservableList<String> selectStd()throws Exception{
        preparedStatement=connection.prepareStatement("select stdnum,stdname,gender,fathername,nationalid,birthdate,entryterm,average,passedunits from fullreporttable");
        ResultSet resultSet=preparedStatement.executeQuery();
        ObservableList<String> observableList= FXCollections.observableArrayList();
        while(resultSet.next()){
            String s1,s2,s3,s4,s5,s6,s7,s8,s9;
            s1=resultSet.getString("stdnum");
            s2=resultSet.getString("stdname");
            s3=resultSet.getString("gender");
            s4=resultSet.getString("fathername");
            s5=resultSet.getString("nationalid");
            s6=resultSet.getString("birthdate");
            s7=resultSet.getString("entryterm");
            s8=resultSet.getString("average");
            s9=resultSet.getString("passedunits");
            observableList.add(s1+"**"+s2+"**"+s3+"**"+s4+"**"+s5+"**"+s6+"**"+s7+"**"+s8+"**"+s9);
        }
        return observableList;
    }

    // TODO: 1/2/2021  bia injaaa
    public ObservableList<String> selectTeacherUnits()throws Exception{
        preparedStatement=connection.prepareStatement("select اسم فیلدارو نمیدونم:( from fullreporttable");
        ResultSet resultSet=preparedStatement.executeQuery();
        ObservableList<String> observableList= FXCollections.observableArrayList();
        while(resultSet.next()){
            String s1,s2,s3,s4,s5,s6,s7,s8,s9;
            s1=resultSet.getString("unitone");
            s2=resultSet.getString("unittwo");
            s3=resultSet.getString("unittree");
            s4=resultSet.getString("unitfour");
            s5=resultSet.getString("unitfive");
                        observableList.add(s1+"**"+s2+"**"+s3+"**"+s4+"**"+s5);
        }
        return observableList;
    }
    public void commit()throws Exception{
        connection.commit();
    }
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
