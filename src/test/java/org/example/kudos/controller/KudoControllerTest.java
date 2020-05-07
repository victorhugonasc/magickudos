package org.example.kudos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
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
public class KudoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private KudoRepository kudoRepository;

    @Test
    public void testCreateKudo() throws Exception {
        final String ID = "9a99999a99aa999999999a9a";
        final String SENDER = "testSender";
        final String RECEIVER = "testReceiver";
        final String MESSAGE = "ola, teste";
        final String LAYOUT = "isso eh um teste";

        //String id, String sender, String receiver, String message, String layout
        Kudo kudoMock = new Kudo(ID,SENDER,RECEIVER,MESSAGE,LAYOUT);

        mockMvc.perform( MockMvcRequestBuilders.post("/kudos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(kudoMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sender", Is.is(SENDER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.receiver", Is.is(RECEIVER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is(MESSAGE)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.layout", Is.is(LAYOUT)))
                .andExpect(status().isCreated());

    }

    @Test
    public void testCreateKudoShouldFailWhenSenderIsEmpty() throws Exception {
        final String ID = "9a99999a99aa999999999a9a";
        final String SENDER = "";
        final String RECEIVER = "testReceiver";
        final String MESSAGE = "ola, teste";
        final String LAYOUT = "isso eh um teste";

        //String id, String sender, String receiver, String message, String layout
        Kudo kudoMock = new Kudo(ID,SENDER,RECEIVER,MESSAGE,LAYOUT);

        mockMvc.perform( MockMvcRequestBuilders.post("/kudos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(kudoMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sender", Is.is(SENDER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.receiver", Is.is(RECEIVER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is(MESSAGE)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.layout", Is.is(LAYOUT)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateKudoShouldFailWhenReceiverIsEmpty() throws Exception {
        final String ID = "9a99999a99aa999999999a9a";
        final String SENDER = "testSender";
        final String RECEIVER = "";
        final String MESSAGE = "ola, teste";
        final String LAYOUT = "isso eh um teste";

        //String id, String sender, String receiver, String message, String layout
        Kudo kudoMock = new Kudo(ID,SENDER,RECEIVER,MESSAGE,LAYOUT);

        mockMvc.perform( MockMvcRequestBuilders.post("/kudos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(kudoMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sender", Is.is(SENDER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.receiver", Is.is(RECEIVER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is(MESSAGE)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.layout", Is.is(LAYOUT)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateKudoShouldFailWhenMessageIsEmpty() throws Exception {
        final String ID = "9a99999a99aa999999999a9a";
        final String SENDER = "testSender";
        final String RECEIVER = "testReceiver";
        final String MESSAGE = "";
        final String LAYOUT = "isso eh um teste";

        //String id, String sender, String receiver, String message, String layout
        Kudo kudoMock = new Kudo(ID,SENDER,RECEIVER,MESSAGE,LAYOUT);

        mockMvc.perform( MockMvcRequestBuilders.post("/kudos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(kudoMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sender", Is.is(SENDER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.receiver", Is.is(RECEIVER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is(MESSAGE)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.layout", Is.is(LAYOUT)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateKudoShouldFailWhenLayoutIsEmpty() throws Exception {
        final String ID = "9a99999a99aa999999999a9a";
        final String SENDER = "testSender";
        final String RECEIVER = "testReceiver";
        final String MESSAGE = "testMessage";
        final String LAYOUT = "";

        //String id, String sender, String receiver, String message, String layout
        Kudo kudoMock = new Kudo(ID,SENDER,RECEIVER,MESSAGE,LAYOUT);

        mockMvc.perform( MockMvcRequestBuilders.post("/kudos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(kudoMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sender", Is.is(SENDER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.receiver", Is.is(RECEIVER)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is(MESSAGE)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.layout", Is.is(LAYOUT)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetKudos() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/kudos"))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        assertThat(!response.getContentAsString().isEmpty());
    }

    @Test
    public void testStoreKudos() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.put("/kudos"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteKudos() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/kudos"))
                .andExpect(status().isOk());
    }


}