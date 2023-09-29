package by.pvt.musicproject;

import by.pvt.musicproject.entity.MyPlayList;
import by.pvt.musicproject.entity.TrackList;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.MyPlayListRepository;
import by.pvt.musicproject.repository.ProducerRepository;
import by.pvt.musicproject.repository.UserRepository;
import by.pvt.musicproject.repository.TrackListRepository;
import by.pvt.musicproject.service.MyPlayListService;
import by.pvt.musicproject.service.ProducerService;
import by.pvt.musicproject.service.TrackListService;
import by.pvt.musicproject.service.UserService;
import by.pvt.musicproject.service.imp.MyPlayListServiceImp;
import by.pvt.musicproject.service.imp.ProducerServiceImp;
import by.pvt.musicproject.service.imp.TrackListServiceImp;
import by.pvt.musicproject.service.imp.UserServiceImp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        RecordPlayer recordPlayer =new RecordPlayer();
//        String file = "The-Doors-Spanish-Caravan.wav";
//        recordPlayer.Play(file);



        UserService userService = new UserServiceImp(new UserRepository());
        ProducerService producerService = new ProducerServiceImp(new ProducerRepository());
        MyPlayListService myPlayListService= new MyPlayListServiceImp(new MyPlayListRepository());
        TrackListService trackListService=new TrackListServiceImp(new TrackListRepository());
//        TrackList one=new TrackList();
//        one.setStyle("rock");
//        one.setFile("The-Doors-Alabama-Song.wav");
//        one.setLenght("9:30");
//        one.setTrack_name("People-Are-Strange");
//        trackListService.add(one);
//        MyPlayList playList=new MyPlayList();
//        myPlayListService.add(playList);
//        myPlayListService.updateMyTrackList(List.of(3L),2L);
//        myPlayListService.addTrackToPlaylist(1L,2L);
//        getTrackId(2L);

//        System.out.println(trackListService.getTrackByStyle("rock"));
        myPlayListService.findTrackByName("The-Doors-People-Are-Strange.wav",1L);


//        User user = new User();
//        user.setName("dima");
//        user.setLogin("dima");
//        user.setSurname("bol");
//        user.setMyPlayListId(playList);
//        user.setRole("us");
//        user.setPassword("1");
//        userService.add(user);

//        Producer producer = new Producer();
//        producer.setCompany("Record");
//        producer.setMyPlayListId(playList);
//        producer.setSalary(10L);
//        producer.setName("ad");
//        producer.setLogin("ad");
//        producer.setRole("ad");
//        producer.setSurname("lo");
//        producer.setPassword("2");
//        producerService.add(producer);

//        System.out.println(userService.getAllUser());
//        System.out.println(producerService.getAllProducer());
    }


    public static void getTrackId(Long trackid){
        TrackListRepository trackListRepository = new TrackListRepository();
        System.out.println(trackListRepository.findTrackById(trackid));
    }



}