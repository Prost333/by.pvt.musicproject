package user;

import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.UserMapper;
import by.pvt.musicproject.repository.DaoUser;
import by.pvt.musicproject.service.AmountService;
import by.pvt.musicproject.service.SubscriptionService;
import by.pvt.musicproject.service.imp.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class createSubscriptionByUserTest {
    @InjectMocks
    private UserServiceImp userService;

    @Mock
    private DaoUser dao;

    @Mock
    private SubscriptionService subscriptionService;

    @Mock
    private AmountService amountService;

    @Mock
    private UserMapper userMapper;

    @Test
    public void createSubscriptionByUser() {
        Long userId = 47L;
        int day = 30;
        User user = new User();
        Subscription subscription = new Subscription();
        UserResponse expectedResponse = new UserResponse();

        when(dao.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.toResponse(any(User.class))).thenReturn(expectedResponse);

        UserResponse actualResponse = userService.findUserById(userId);

        assertEquals(expectedResponse, actualResponse);

    }
}

