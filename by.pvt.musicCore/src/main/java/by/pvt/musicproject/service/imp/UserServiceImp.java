package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.exception.EntityNotFoundException;
import by.pvt.musicproject.mapper.UserMapper;
import by.pvt.musicproject.repository.DaoUser;
import by.pvt.musicproject.service.SubscriptionService;
import by.pvt.musicproject.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.*;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private DaoUser dao;

    @Autowired
    private SubscriptionService subscriptionService;

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);


    public UserResponse add(UserRequest userRequest) {
        User user = userMapper.toEntity(userRequest);
        user.setSubscription(subscriptionService.defaultSubscription());
        dao.save(user);
        return userMapper.userToUserResponse(user);

    }


    public User findEntitybyId(Long id) {
        User user = dao.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
        return user;
    }

    public UserResponse findUserById(Long id) {
        User user =dao.findById(id).orElseThrow(()-> new EntityNotFoundException("user not found"));
        return userMapper.userToUserResponse(user);
    }

    public void deleteUser(Long id) {
        dao.deleteById(id);
    }

    public List<User> getAllUser() {
        return dao.findAll();
    }

    public void addTrackToUser(Long userId, Track track) {
        User user = dao.findById(userId).orElse(null);
        if (user.getSubscription().getEndData().isAfter(now())) {
            if (user != null && !user.getTrack().contains(track)) {
                user.getTrack().add(track);
                dao.save(user);
            }
        } else {
            System.out.println("adding music is possible after connecting the subscription");
        }
    }

    public User createSubscriptionByUser(Long userId, int day) {
        User user = findEntitybyId(userId);
        Subscription subscription = subscriptionService.findSubscriptionById(user.getSubscription().getId());
        int payForDay = 5;
        subscription.setUserId(user.getId());
        subscription.setUser(user);
        subscription.setSubsPrice(new BigDecimal(payForDay * day));
        subscription.setStartData(now());
        subscription.setEndData(now().plus(day, ChronoUnit.DAYS));
        user.setSubscription(subscription);
        return dao.save(user);
    }

    public List<String> getAllTrackByUser(Long id) {
        User user = dao.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
        Subscription subscription = subscriptionService.findSubscriptionById(user.getSubscription().getId());
        if (subscription.getEndData().isAfter(now())) {
            List<Track> tracks = user.getTrack();
            List<String> file = tracks.stream().map(Track::getFile).collect(Collectors.toList());
            return file;
        } else {
            subscriptionService.calculateTimeDifference(user.getSubscription().getEndData());
            return Collections.singletonList("none");
        }

    }

    public void deleteTracks(Long userId, Long trackId) {
        User user = dao.findById(userId).orElseThrow(() -> new EntityNotFoundException("user not found"));
        List<Track> tracksToRemove = user.getTrack().stream()
                .filter(track -> Objects.equals(track.getId(), trackId))
                .toList();
        user.getTrack().removeAll(tracksToRemove);
        dao.save(user);

    }

    @Override
    public List<UserResponse> getAllUserRes() {
        List<UserResponse> userResponses = dao.findAll().stream().map(user -> userMapper.userToUserResponse(user)).toList();
        return userResponses;
    }


}
