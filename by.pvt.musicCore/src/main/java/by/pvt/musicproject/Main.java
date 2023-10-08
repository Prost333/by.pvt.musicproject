package by.pvt.musicproject;

import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.music.RecordPlayer;
import by.pvt.musicproject.repository.*;
import by.pvt.musicproject.service.*;
import by.pvt.musicproject.service.imp.*;

public class Main {
    public static void main(String[] args) {
        RecordPlayer recordPlayer =new RecordPlayer();
//        String file = "The-Doors-Spanish-Caravan.wav";
//        recordPlayer.Play(file);

        PerformerService performerService = new PerformerServiceImp(new PerformerRepository());
        UserService userService = new UserServiceImp(new UserRepository());
        ProducerService producerService = new ProducerServiceImp(new ProducerRepository());

        // добавление треку исполнителя
        TrackListService trackListService = new TrackListServiceImp(new TrackListRepository());
        TrackListRepository trackListRepository=new TrackListRepository();
//        System.out.println(trackListRepository.findTrackByPerformer(1L));
//        System.out.println(trackListRepository.findUserPlayList(1L));
//        Track track = trackListService.findTrackById(1L);
//        track.setPerformer(performerService.findPerformerById(1L));
//        trackListService.updateTrack(track);
        recordPlayer.Playlist(trackListService.getAllFile());



//        Track one=new Track();
//        one.setStyle("rock");
//        one.setFile("The-Doors-When-Music-is-Over.wav");
//        one.setLenght("8:30");
//        one.setTrack_name("When Music is Over");
//        one.setPerformer(performerService.findPerformerById(1L));
//        trackListService.add(one);
//        MyPlayList playList=new MyPlayList();
//        myPlayListService.add(playList);
//        myPlayListService.updateMyTrackList(List.of(3L),2L);
//        myPlayListService.addTrackToPlaylist(1L,2L);
//        getTrackId(2L);

//        System.out.println(trackListService.getTrackByStyle("rock"));
//        myPlayListService.findTrackByName("The-Doors-People-Are-Strange.wav",1L);


//        User user = new User();
//        user.setName("dima");
//        user.setLogin("dima");
//        user.setSurname("bol");
////        user.setMyPlayListId(playList);
//        user.setRole("us");
//        user.setPassword("1");
//        userService.add(user);
//        userService.addTrackToPlaylist(2L,1L);

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

//        Performer performer=new Performer();
//        performer.setName("The Doors");
//        performer.setClosenes("1");
//        performerService.add(performer);

    }


    public static void getTrackId(Long trackid) {
        TrackListRepository trackListRepository = new TrackListRepository();
        System.out.println(trackListRepository.findTrackById(trackid));
    }


}