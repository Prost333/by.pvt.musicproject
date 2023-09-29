package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.MyPlayListReq;
import by.pvt.musicproject.dto.MyPlayListRes;
import by.pvt.musicproject.entity.MyPlayList;

public class PlayListMapping {

    public MyPlayListRes toResponse (MyPlayList myPlayList){
        MyPlayListRes myPlayListRes=new MyPlayListRes();
        myPlayListRes.setId(myPlayList.getId());
//        myPlayListRes.setTrackId(myPlayList.getTrackId());
//        myPlayListRes.setUserId(myPlayList.getUserId());
        return myPlayListRes;
    }

    public MyPlayList toPlayListEntity(MyPlayListReq myPlayListReq){
        MyPlayList myPlayList=new MyPlayList();
        myPlayList.setId(myPlayListReq.getId());
//        myPlayList.setTrackId(myPlayListReq.getTrackId());
//        myPlayList.setUserId(myPlayListReq.getUserId());
        return myPlayList;
    }
}
