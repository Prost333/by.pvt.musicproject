package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.dto.PerformersRes;
import by.pvt.musicproject.entity.Performers;

public class PerformersMapping {
    public PerformersRes toResponsr(Performers performers){
        PerformersRes performersRes=new PerformersRes();
        performersRes.setClosenes(performers.getClosenes());
        performersRes.setId(performers.getId());
        performersRes.setName(performers.getName());
        return performersRes;
    }
    public Performers toPerformersEntity(PerformersReq performersReq){
        Performers performers= new Performers();
        performers.setClosenes(performersReq.getClosenes());
        performers.setId(performersReq.getId());
        performers.setName(performersReq.getName());
        return performers;
    }
}
