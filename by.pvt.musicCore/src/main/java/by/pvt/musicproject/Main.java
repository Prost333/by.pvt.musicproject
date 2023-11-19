package by.pvt.musicproject;

//import by.pvt.musicproject.configuration.HibernateConfiguration;
import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.*;
import by.pvt.musicproject.music.RecordPlayer;
import by.pvt.musicproject.repository.*;
import by.pvt.musicproject.service.*;
import by.pvt.musicproject.service.imp.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {

//        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(SpringConfig.class);
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
//        TrackListServiceImp trackListServiceImp = applicationContext.getBean(TrackListServiceImp.class);
//        TrackListService trackListService =applicationContext.getBean("trackListService",TrackListServiceImp.class);
//        System.out.println(trackListService.getAllList());
//        RecordPlayer recordPlayer =new RecordPlayer();
//        String file = "The-Doors-Spanish-Caravan.wav";
//        recordPlayer.play(file);
//        RatingService ratingService= (RatingService) applicationContext.getBean( RatingServiceImp.class);
//        Rating rating=new Rating();
//        rating.setMark(9L);
//        ratingService.add(rating);
//        System.out.println(ratingService.findRatingById(1L));
//        var albumService = applicationContext.getBean(AlbumServiceImp.class);
//        var performerService = applicationContext.getBean(PerformerServiceImp.class);
//        var subscriptionService = applicationContext.getBean(SubscriptionServiceImp.class);
//        UserService userService = applicationContext.getBean(UserServiceImp.class);
////        System.out.println(trackListServiceImp.findAllByFile());
//        userService.deleteTracks(2L, 3L);
//        System.out.println(userService.getAllTrackByUser(2L));

//        UserResponse user=userService.findUserById(1L);
//        userService.getAllTrackByUser(1L);
//
//        Performer performer = new Performer();
//        performer.setName("The Doors");
//        performer.setClosenes("rock");
//        performerService.add(performer);
//        Album album = new Album();
//        album.setName("L.A. Woman");
//        album.setStyle("Rock");
//        album.setPerformer(performerService.findPerformerById(1L));
//        albumService.add(album);
//        System.out.println(albumService.findByName("L.A. Woman"));
//        albumService.addTrackToAlbum(1L, trackListServiceImp.findTrackById(1L));


//        userService.findUserById(7L);
//        UserRequest userRequest=new UserRequest();
//        userRequest.setName("August");
//        userRequest.setLogin("123");
//        userRequest.setRole("user");
//        userRequest.setSurname("Braun");
//        userRequest.setPassword("123");
//        userService.add(userRequest);
//        userService.addTrackToUser(userService.findUserById(2L).getId(), trackListServiceImp.findTrackById(3L));
//        RecordPlayer recordPlayer =new RecordPlayer();
//        recordPlayer.Playlist(userService.getAllTrackByUser(2L));


//        TrackListService trackListService=applicationContext.getBean("trackListService", TrackListServiceImp.class);
//        System.out.println(trackListService.findTrackById(1L));

//        PerformerService performerService = new PerformerServiceImp(new PerformerRepository());
//        UserService userService = applicationContext.getBean("userService", UserServiceImp.class);
//        User user=userService.findUserById(1L);
//        System.out.println(user);
//        ProducerService producerService = new ProducerServiceImp(new ProducerRepository());

        // добавление треку исполнителя
//        TrackListService trackListService = new TrackListServiceImp(new TrackListRepository());
//        TrackListRepository trackListRepository=new TrackListRepository();
//        System.out.println(trackListRepository.findTrackByPerformer(1L));
//        System.out.println(trackListRepository.findUserPlayList(1L));
//        Track track = trackListService.findTrackById(1L);
//        track.setPerformer(performerService.findPerformerById(1L));
//        trackListService.updateTrack(track);
//        recordPlayer.Playlist(trackListService.getAllFile());
//        System.out.println(trackListServiceImp.findByPerformer(performerService.findPerformerById(1L)));

//        Track one=new Track();
//        one.setStyle("rock");
//        one.setFile("The-Doors-When-the-Music_s-Over.wav");
//        one.setLenght("9:30");
//        one.setName("When the Music is Over");
//        one.setPerformer(performerService.findPerformerById(1L));
//        one.setAlbums(albumService.findAlbumById(2L));
//        trackListServiceImp.add(one);
//
//        System.out.println(trackListServiceImp.findByAlbums(albumService.findAlbumById(2L)));
//        System.out.println(trackListServiceImp.getAllList());


//        System.out.println(trackListService.getTrackByStyle("rock"));
//        myPlayListService.findTrackByName("The-Doors-People-Are-Strange.wav",1L);


//userService.addTrackToUser(1L,trackListServiceImp.findTrackById(2L));
//        User user = new User();
//        user.setName("Alina");
//        user.setLogin("Alina");
//        user.setSurname("bor");
//        user.setRole("us");
//        user.setPassword("11");
//        userService.add(user);
//        System.out.println(userService.findUserById(2L));

//ProducerServiceImp producerServiceImp = applicationContext.getBean(ProducerServiceImp.class);
//        Producer producer = new Producer();
//        producer.setCompany("JavaBand");
//        producer.setSalary(123L);
//        producer.setName("sedf");
//        producer.setLogin("weg");
//        producer.setRole("admin");
//        producer.setSurname("wretg");
//        producer.setPassword("34");
//        userService.add(producer);
//        producerServiceImp.add(producer);
//        System.out.println(producerServiceImp.getAllProducer());
//        System.out.println(userService.getAllUser());

//        System.out.println(userService.getAllUser());
//        System.out.println(producerService.getAllProducer());

//        Performer performer=new Performer();
//        performer.setName("The Doors");
//        performer.setClosenes("1");
//        performerService.add(performer);

    }


//    public static void getTrackId(Long trackid) {
//        TrackListRepository trackListRepository = new TrackListRepository();
//        System.out.println(trackListRepository.findTrackById(trackid));
//    }


}