package org.example.kudos.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static javafx.beans.binding.Bindings.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@RunWith(PowerMockRunner.class)
@WebMvcTest(controllers = KudoController.class)
public class KudoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private KudoRepository kudoRepository;

    @InjectMocks
    KudoController kudoController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(kudoController).build();
    }

    @Test
    public void testCreateKudo() throws Exception {
        //String id, String sender, String receiver, String message, String layout
        Kudo kudoMock = new Kudo("9a99999a99aa999999999a9a", "victorTest", "testVictor", "ola, teste", "isso eh um teste");
        mockMvc.perform( MockMvcRequestBuilders.post("/kudos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(kudoMock))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetKudos() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/kudos"))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        assertThat(!response.getContentAsString().isEmpty());
    }

    @Test
    public void testStoreKudos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/kudos"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteKudos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/kudos"))
                .andExpect(status().isOk());
    }


}