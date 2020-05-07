package org.example.kudos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kudos.model.User;
import org.example.kudos.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
//@RunWith(PowerMockRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    UserController userController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testCreateUser() throws Exception {
        //String name, String user,String id, String email, String password
        User userMock = new User("testName", "testUser", "9a99999a99aa999999999a9a", "test@test", "this is a test");
        mockMvc.perform( MockMvcRequestBuilders.post("/kudos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetUsers() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        assertThat(!response.getContentAsString().isEmpty());
    }

    @Test
    public void testDeleteUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users"))
                .andExpect(status().isOk());
    }

}
