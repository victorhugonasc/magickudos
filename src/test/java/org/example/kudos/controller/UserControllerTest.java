/*package org.example.kudos.controller;

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

import java.util.ArrayList;

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
        final String ID = "9a99999a99aa999999999a9a";
        final String TEAM = "customersApp";
        final String EMAIL = "test@test";
        final String PASSWORD = "testPassword";
        final ArrayList<String> TAGS = new ArrayList();

        //String name, String user, String id, String email, String password
        User userMock = new User(NAME,ID,TEAM,EMAIL,PASSWORD,TAGS);

        mockMvc.perform( MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(NAME)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is(EMAIL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(PASSWORD)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tags", Is.is(TAGS)))
                .andExpect(status().isCreated());

    }

    @Test
    public void testCreateUserShouldFailWhenNameIsEmpty() throws Exception {
        final String NAME = "";
        final String ID = "9a99999a99aa999999999a9a";
        final String TEAM = "customersApp";
        final String EMAIL = "test@test";
        final String PASSWORD = "testPassword";
        final ArrayList<String> TAGS = new ArrayList();

        //String name, String user, String id, String email, String password
        User userMock = new User(NAME,ID,TEAM,EMAIL,PASSWORD,TAGS);

        mockMvc.perform( MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(NAME)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is(EMAIL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(PASSWORD)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tags", Is.is(TAGS)))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testCreateUserShouldFailWhenEmailIsEmpty() throws Exception {
        final String NAME = "testName";
        final String ID = "9a99999a99aa999999999a9a";
        final String TEAM = "customersApp";
        final String EMAIL = "";
        final String PASSWORD = "testPassword";
        final ArrayList<String> TAGS = new ArrayList();

        //String name, String user, String id, String email, String password
        User userMock = new User(NAME,ID,TEAM,EMAIL,PASSWORD,TAGS);

        mockMvc.perform( MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(NAME)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is(EMAIL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(PASSWORD)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tags", Is.is(TAGS)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateUserShouldFailWhenPasswordIsEmpty() throws Exception {
        final String NAME = "testName";
        final String ID = "9a99999a99aa999999999a9a";
        final String TEAM = "customersApp";
        final String EMAIL = "test@test";
        final String PASSWORD = "";
        final ArrayList<String> TAGS = new ArrayList();

        //String name, String user, String id, String email, String password
        User userMock = new User(NAME,ID,TEAM,EMAIL,PASSWORD,TAGS);

        mockMvc.perform( MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(NAME)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is(EMAIL)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(PASSWORD)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tags", Is.is(TAGS)))
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
    public void testGetUsersWithParams() throws Exception {
        String ID = "9a99999a99aa999999999a9a";
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}",ID))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        assertThat(!response.getContentAsString().isEmpty());
    }

    @Test
    public void testDeleteUsers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/users"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUsersWithParams() throws Exception {
        String ID = "9a99999a99aa999999999a9a";
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/users").param("id",ID))
                .andExpect(status().isOk());
    }


}*/