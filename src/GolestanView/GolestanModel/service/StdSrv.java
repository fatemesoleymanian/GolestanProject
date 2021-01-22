package GolestanModel.service;

import GolestanModel.entity.StdEnti;
import GolestanModel.repository.StdRepo;

import java.util.List;

public class StdSrv {
    private StdSrv(){}
    private static final StdSrv stdSrv=new StdSrv();
    public static StdSrv getInstance(){
        return stdSrv;
    }
    public List<StdEnti> reportHalf()throws Exception{
        List<StdEnti> stdEntis;
        try(StdRepo stdRepo=new StdRepo()) {
            stdEntis=stdRepo.selectHalf();
        }
        return stdEntis;
    }
    public List<StdEnti> reportFull()throws Exception{
        List<StdEnti> stdEntis;
        try(StdRepo stdRepo=new StdRepo()) {
            stdEntis=stdRepo.selectFull();
        }
        return stdEntis;
    }
}
