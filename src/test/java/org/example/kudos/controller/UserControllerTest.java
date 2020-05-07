package org.example.kudos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kudos.model.User;
import org.example.kudos.repository.UserRepository;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
        private UserRepository userRepository;

    @Test
    public void testCreateUser() throws Exception {
        final String NAME = "testName";
        final String USER = "testUser";
        final String ID = "9a99999a99aa999999999a9a";
        final String EMAIL = "test@test";
        final String PASSWORD = "testPassword";

        //String name, String user, String id, String email, String password
        User userMock = new User(NAME,USER,ID,EMAIL,PASSWORD);

        mockMvc.perform( MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(NAME)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user", Is.is(USER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is(EMAIL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(PASSWORD)))
                .andExpect(status().isCreated());

    }

    @Test
    public void testCreateUserShouldFailWhenNameIsEmpty() throws Exception {
        final String NAME = "";
        final String USER = "testUser";
        final String ID = "9a99999a99aa999999999a9a";
        final String EMAIL = "test@test";
        final String PASSWORD = "testPassword";

        //String name, String user, String id, String email, String password
        User userMock = new User(NAME,USER,ID,EMAIL,PASSWORD);

        mockMvc.perform( MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(NAME)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user", Is.is(USER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is(EMAIL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(PASSWORD)))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testCreateUserShouldFailWhenUserIsEmpty() throws Exception {
        final String NAME = "testName";
        final String USER = "";
        final String ID = "9a99999a99aa999999999a9a";
        final String EMAIL = "test@test";
        final String PASSWORD = "testPassword";

        //String name, String user, String id, String email, String password
        User userMock = new User(NAME,USER,ID,EMAIL,PASSWORD);

        mockMvc.perform( MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(NAME)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user", Is.is(USER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is(EMAIL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(PASSWORD)))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testCreateUserShouldFailWhenEmailIsEmpty() throws Exception {
        final String NAME = "testName";
        final String USER = "testUser";
        final String ID = "9a99999a99aa999999999a9a";
        final String EMAIL = "";
        final String PASSWORD = "testPassword";

        //String name, String user, String id, String email, String password
        User userMock = new User(NAME,USER,ID,EMAIL,PASSWORD);

        mockMvc.perform( MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(NAME)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user", Is.is(USER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is(EMAIL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(PASSWORD)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateUserShouldFailWhenPasswordIsEmpty() throws Exception {
        final String NAME = "testName";
        final String USER = "testUser";
        final String ID = "9a99999a99aa999999999a9a";
        final String EMAIL = "test@test";
        final String PASSWORD = "";

        //String name, String user, String id, String email, String password
        User userMock = new User(NAME,USER,ID,EMAIL,PASSWORD);

        mockMvc.perform( MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(NAME)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user", Is.is(USER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is(EMAIL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(PASSWORD)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetUsers() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        assertThat(!response.getContentAsString().isEmpty());
    }

    @Test
    public void testDeleteUsers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/users"))
                .andExpect(status().isOk());
    }


}