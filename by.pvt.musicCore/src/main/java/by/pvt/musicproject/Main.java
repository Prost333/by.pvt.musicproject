package by.pvt.musicproject;

import by.pvt.musicproject.entity.MyPlayList;
import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.music.RecordPlayer;
import by.pvt.musicproject.repository.ProducerRepository;
import by.pvt.musicproject.repository.UserRepository;
import by.pvt.musicproject.service.ProducerService;
import by.pvt.musicproject.service.UserService;
import by.pvt.musicproject.service.imp.ProducerServiceImp;
import by.pvt.musicproject.service.imp.UserServiceImp;

public class Main {
    public static void main(String[] args) {
//        RecordPlayer recordPlayer =new RecordPlayer();
//        String file = "The-Doors-Spanish-Caravan.wav";
//        recordPlayer.Play(file);
        UserService userService = new UserServiceImp(new UserRepository());
        ProducerService producerService = new ProducerServiceImp(new ProducerRepository());
        User user = new User();
        user.setName("dima");
        user.setLogin("dima");
        user.setSurname("bol");
        user.setMyPlayListId(new MyPlayList());
        user.setRole("us");
        user.setPassword("1");
        userService.add(user);
        Producer producer = new Producer();
        producer.setCompany("Record");
        producer.setSalary(10L);
        producer.setName("ad");
        producer.setLogin("ad");
        producer.setRole("ad");
        producer.setSurname("lo");
        producer.setPassword("2");
        producerService.add(producer);

        System.out.println(userService.getAllUser());
        System.out.println(producerService.getAllProducer());
    }


}