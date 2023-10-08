package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.dto.PerformersRes;
import by.pvt.musicproject.entity.Performer;

public class PerformersMapping {
    public PerformersRes toResponsr(Performer performer){
        PerformersRes performersRes=new PerformersRes();
        performersRes.setClosenes(performer.getClosenes());
        performersRes.setId(performer.getId());
        performersRes.setName(performer.getName());
        return performersRes;
    }
    public Performer toPerformersEntity(PerformersReq performersReq){
        Performer performer = new Performer();
        performer.setClosenes(performersReq.getClosenes());
        performer.setId(performersReq.getId());
        performer.setName(performersReq.getName());
        return performer;
    }
}
