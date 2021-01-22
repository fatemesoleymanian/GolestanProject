package GolestanModel.service;

import GolestanModel.entity.EmpEnti;
import GolestanModel.repository.EmpRepo;

public class EmpSrv {
    private EmpSrv(){}
    private static final EmpSrv empSrv=new EmpSrv();
    public static EmpSrv getInstance(){
        return empSrv;
    }
    public void breakCase(EmpEnti empEnti)throws Exception{
        try(EmpRepo empRepo=new EmpRepo()){
            empEnti.setReasonOfBreak(empEnti.getReasonOfBreak());
            empEnti.setBreakTime(empEnti.getBreakTime());
            empRepo.insertBreakTable(empEnti);
            empRepo.commit();
        }
    }
    public void loan(EmpEnti empEnti)throws Exception{
        try(EmpRepo empRepo=new EmpRepo()){
            empEnti.setLoanAmount(empEnti.getLoanAmount());
            empEnti.setPersonToGuarantee(empEnti.getPersonToGuarantee());
            empEnti.setLoanNumber(empEnti.getLoanNumber());
            empRepo.insertLoanTable(empEnti);
            empRepo.commit();
        }
    }
    public void docs(EmpEnti empEnti)throws Exception{
        try(EmpRepo empRepo=new EmpRepo()){
            empEnti.setDoctype(empEnti.getDoctype());
            empEnti.setDocnum(empEnti.getDocnum());
            empRepo.insertDoc(empEnti);
            empRepo.commit();
        }
    }
    public void save(EmpEnti empEnti)throws Exception{
        try(EmpRepo empRepo=new EmpRepo()){
            empEnti.setEmpName(empEnti.getEmpName());
            empEnti.setEmpNum(empEnti.getEmpNum());
            empEnti.setAddress(empEnti.getAddress());
            empEnti.setNationalCode(empEnti.getNationalCode());
            empEnti.setFatherName(empEnti.getFatherName());
            empEnti.setBirthDate(empEnti.getBirthDate());
            empEnti.setPhoneNumber(empEnti.getPhoneNumber());
            empEnti.setEmail(empEnti.getEmail());
            empEnti.setMilitary(empEnti.getMilitary());
            empEnti.setEducation(empEnti.getEducation());
            empEnti.setReligion(empEnti.getReligion());
            empEnti.setNativeLand(empEnti.getNativeLand());
            empEnti.setMaritialStatus(empEnti.getMaritialStatus());
            empRepo.insertEmpTable(empEnti);
            empRepo.commit();
        }
    }
}
