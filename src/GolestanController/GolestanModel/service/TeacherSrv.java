package GolestanModel.service;

import GolestanModel.entity.TeacherEnti;
import GolestanModel.repository.TeacherRepo;

import java.lang.annotation.Target;

public class TeacherSrv {
    private TeacherSrv(){}
    private static final TeacherSrv teacherSrv=new TeacherSrv();
    public static TeacherSrv getInstance(){
        return teacherSrv;
    }
    public void scoreRegister(TeacherEnti teacherEnti)throws Exception{
        try(TeacherRepo teacherRepo=new TeacherRepo()){
            teacherEnti.setStdName(teacherEnti.getStdName());
            teacherEnti.setStdNum(teacherEnti.getStdNum());
            teacherEnti.setSubjectCode(teacherEnti.getSubjectCode());
            teacherEnti.setScore(teacherEnti.getScore());
            teacherRepo.insertScoreRegisterTable(teacherEnti);
            teacherRepo.commit();
        }
    }
    public void deleteScoreRegister(TeacherEnti teacherEnti)throws Exception{
        try(TeacherRepo teacherRepo=new TeacherRepo()){
            teacherEnti.setStdName(teacherEnti.getStdName());
            teacherEnti.setStdNum(teacherEnti.getStdNum());
            teacherEnti.setDeleteTime(teacherEnti.getDeleteTime());
            teacherEnti.setDeleteReason(teacherEnti.getDeleteReason());
            teacherRepo.deleteFromScoreRegisterTable(teacherEnti);
            teacherRepo.commit();
        }
    }
}
