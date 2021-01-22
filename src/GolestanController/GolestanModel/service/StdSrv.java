package GolestanModel.service;

import GolestanController.EntrancePage;
import GolestanModel.entity.StdEnti;
import GolestanModel.repository.StdRepo;

import java.util.List;

public class StdSrv {
    private StdSrv(){}
    private static final StdSrv stdSrv=new StdSrv();
    public static StdSrv getInstance(){
        return stdSrv;
    }
    public void reason(StdEnti stdEnti)throws Exception{
        try(StdRepo stdRepo=new StdRepo()){
            stdEnti.setDeleteReason(stdEnti.getDeleteReason());
            stdEnti.setYear(stdEnti.getYear());
            stdEnti.setStdID(stdEnti.getStdID());
            stdRepo.insertReason(stdEnti);
            stdRepo.commit();
        }
    }
    public void firstPage(StdEnti stdEnti)throws Exception{
        try(StdRepo stdRepo=new StdRepo()){
            stdEnti.setUsername(stdEnti.getUsername());
            stdEnti.setPassword(stdEnti.getPassword());
            stdRepo.insertIntoFirstPageTable(stdEnti);
            stdRepo.commit();
        }
    }
    public void update(StdEnti stdEnti)throws Exception{
        try(StdRepo stdRepo=new StdRepo()){
            stdEnti.setPassword(stdEnti.getPassword());
            stdRepo.updatePassword(stdEnti);
            stdRepo.commit();
        }
    }
    public void saveBank(StdEnti stdEnti)throws Exception{
        try(StdRepo stdRepo=new StdRepo()){
            stdEnti.setPaymentAmount(stdEnti.getPaymentAmount());
            stdEnti.setCardNumber(stdEnti.getCardNumber());
            stdEnti.setCardSecondPass(stdEnti.getCardSecondPass());
            stdEnti.setCvv2(stdEnti.getCvv2());
            stdEnti.setExpireDay(stdEnti.getExpireDay());
            stdEnti.setExpireYear(stdEnti.getExpireYear());
            stdRepo.insertBankTable(stdEnti);
            stdRepo.commit();
        }
    }
    public void unitResult(StdEnti stdEnti)throws Exception{
        try(StdRepo stdRepo=new StdRepo()){
            stdEnti.setStdNum(stdEnti.getStdNum());
            stdEnti.setUnitCode(stdEnti.getUnitCode());
            stdRepo.insertUnitResult(stdEnti);
            stdRepo.commit();
        }
    }
}
