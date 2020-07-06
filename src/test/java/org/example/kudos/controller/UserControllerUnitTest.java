package org.example.kudos.controller;

import org.example.kudos.model.User;
import org.example.kudos.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerUnitTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @Mock
    HttpServletResponse response;

    private final String NAME = "Name";
    private final String ID = "5ebaf6f31d4d0370446a39f6";
    private final String EMAIL = "email@email";
    private final String PASSWORD = "pass123word";
    private final ArrayList<String> TAGS = new ArrayList();
    private final int RESPONSE_CODE_CREATED = 201;
    private final int RESPONSE_CODE_BAD_REQUEST = 400;

    @Test
    public void testCreateUserIsSuccessful() {

        User user = new User(NAME,ID,EMAIL,PASSWORD,TAGS);

        when(userRepository.save(user)).thenReturn(mock(User.class));

        userController.createUser(user,response);

        verify(response, times(1)).setStatus(eq(RESPONSE_CODE_CREATED));
        verify(userRepository,times(1)).save(eq(user));
    }

    @Test
    public void testCreateUserWithMissingParams() {

        User user = new User("","","","",TAGS);

        when(userRepository.save(user)).thenReturn(mock(User.class));

        userController.createUser(user,response);

        verify(response, times(1)).setStatus(eq(RESPONSE_CODE_BAD_REQUEST));
        verify(userRepository,never()).save(eq(user));
    }

    @Test
    public void testGetUsers() {
        when(userRepository.findAll()).thenReturn(Stream.of(new User(NAME,ID,EMAIL,PASSWORD,TAGS)).collect(Collectors.toList()));
        assertEquals(1,userController.getUsers().size());
    }

    @Test
    public void testGetSingleUser() {
        userController.getSingleUser(ID,response);
        verify(userRepository,times(1)).findById(ID);
    }

    @Test
    public void testGettingNonExistingUser() {
        String FAKE_ID = "fake_id";
        userController.getSingleUser(FAKE_ID,response);
        verify(userRepository,never()).findById(ID);
    }

    @Test
    public void testDeleteKudos() {
        userController.deleteAllUsers();
        verify(userRepository,times(1)).deleteAll();
    }

    @Test
    public void testdeleteSingleUser() {
        userController.deleteSingleUser(ID,response);
        verify(userRepository,times(1)).findById(ID);//deleteById
    }

    @Test
    public void testDeleteNonExistingKudo() {
        String FAKE_ID = "fake_id";
        userController.deleteSingleUser(FAKE_ID,response);
        verify(userRepository,never()).findById(ID);//deleteById
    }

}
