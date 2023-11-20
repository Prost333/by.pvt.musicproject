package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.aop.verification.CheckSubscription;
import by.pvt.musicproject.dto.*;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.exception.EntityNotFoundException;
import by.pvt.musicproject.mapper.SubscriptionMapper;
import by.pvt.musicproject.mapper.TrackMapper;
import by.pvt.musicproject.mapper.UserMapper;
import by.pvt.musicproject.repository.DaoUser;
import by.pvt.musicproject.service.AmountService;
import by.pvt.musicproject.service.SubscriptionService;
import by.pvt.musicproject.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.*;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final DaoUser dao;

    private final SubscriptionService subscriptionService;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;
    private final TrackMapper trackMapper;
    private final SubscriptionMapper subscriptionMapper;
    private final HttpServletRequest httpServletRequest;
    public final AmountService amountService;


    public UserResponse login(UserRequest userRequest) throws ServletException {
        try {
            if (userRequest.getLogin() == null || userRequest.getLogin().isEmpty() ||
                    userRequest.getPassword() == null || userRequest.getPassword().isEmpty()) {
                throw new IllegalArgumentException("Login and password must not be empty");
            }
            httpServletRequest.login(userRequest.getLogin(), userRequest.getPassword());
            User user = dao.findByLogin(userRequest.getLogin());
            return userMapper.toResponse(user);
        } catch (ServletException e) {
            throw new RuntimeException("Login failed", e);
        }
    }

    public void logout() throws ServletException {
        httpServletRequest.logout();
    }


    @Transactional
    public UserResponse add(UserRequest userRequest) throws Exception {
        User user = userMapper.toEntity(userRequest);
        user.setRole("user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
        user.setSubscription(subscriptionService.defaultSubscription(user));
        dao.save(user);
        return userMapper.toResponse(user);
    }


    public User findEntitybyId(Long id) {
        User user = dao.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = dao.findByLogin(username);
        return user;
    }

    public UserResponse findUserById(Long id) {
        User user = dao.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
        return userMapper.toResponse(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = findEntitybyId(id);
        Subscription subscription = subscriptionService.findSubscriptionById(user.getSubscription().getId());
        subscriptionService.deleteSubscription(subscription);
        dao.deleteById(id);
    }

    public List<User> getAllUser() {
        return dao.findAll();
    }



    public SubscriptionRes createSubscriptionByUser(Long userId, int day) {
        User user = findEntitybyId(userId);
        Subscription subscription = subscriptionService.findSubscriptionById(user.getSubscription().getId());
        subscription.setUserId(user.getId());
        subscription.setUser(user);
        BigDecimal a = BigDecimal.valueOf(amountService.getAmount() * day);
        subscription.setSubsPrice(a);
        subscription.setStartData(now());
        subscription.setEndData(now().plus(day, ChronoUnit.DAYS));
        user.setSubscription(subscription);
        dao.save(user);
        return subscriptionMapper.toResponse(subscription);
    }

    @CheckSubscription
    public List<TrackRes> getAllTrackByUser(Long id) {
        User user = dao.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
        List<Track> tracks = user.getTrack();
        return tracks.stream().map(trackMapper::toResponse).collect(Collectors.toList());

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
        List<UserResponse> userResponses = dao.findAll().stream().map(userMapper::toResponse).toList();
        return userResponses;
    }


}
