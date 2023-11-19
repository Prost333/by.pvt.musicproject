package user;

import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.DaoUser;
import by.pvt.musicproject.service.imp.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
@ExtendWith({MockitoExtension.class})
public class UserServiceGetAll {
    @InjectMocks
    private UserServiceImp userService;

    @Mock
    private DaoUser dao;

    @Test
    public void getAllUserTest() {
        List<User> expectedUsers = new ArrayList<>();
        when(dao.findAll()).thenReturn(expectedUsers);
        List<User> actualUsers = userService.getAllUser();
        assertEquals(expectedUsers, actualUsers);
        verify(dao, times(1)).findAll();
    }
}
