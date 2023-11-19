package user;

import by.pvt.musicproject.dto.UserRequest;
import by.pvt.musicproject.dto.UserResponse;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.UserMapper;
import by.pvt.musicproject.repository.DaoUser;
import by.pvt.musicproject.service.SubscriptionService;
import by.pvt.musicproject.service.imp.UserServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class UserServiceImpTest {

    @Mock
    private DaoUser dao;

    @Mock
    private SubscriptionService subscriptionService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserMapper userMapper;

    @Mock
    private HttpServletRequest httpServletRequest;

    @InjectMocks
    private UserServiceImp userService;

    @Test
    public void testAddUser() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setLogin("testLogin");
        userRequest.setPassword("testPassword");

        User user = new User();
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());

        UserResponse userResponse = new UserResponse();
        userResponse.setLogin(user.getLogin());

        when(userMapper.toEntity(userRequest)).thenReturn(user);
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");
        when(subscriptionService.defaultSubscription(user)).thenReturn(new Subscription());
        when(userMapper.toResponse(user)).thenReturn(userResponse);

        UserResponse result = userService.add(userRequest);

        assertEquals(userResponse.getLogin(), result.getLogin());
        verify(dao, times(2)).save(user);
    }


}
