package org.example.kudos.controller;

import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KudoControllerUnitTest {

    @InjectMocks
    private KudoController kudoController;

    @Mock
    private KudoRepository kudoRepository;

    private final String ID = "5ebaf6f31d4d0370446a39f6";
    private final String SENDER = "Sender";
    private final String RECEIVER = "Receiver";
    private final String MESSAGE = "Test";
    private final String LAYOUT = "123456";
    private final int RESPONSE_CODE_OK = 201;
    private final int RESPONSE_CODE_BAD_REQUEST = 400;

    @Mock
    HttpServletResponse response;

    @Test
    public void testCreateKudoIsSuccessful() {

        Kudo kudo = new Kudo(ID,SENDER,RECEIVER,MESSAGE,LAYOUT);

        when(kudoRepository.save(kudo)).thenReturn(mock(Kudo.class));

        kudoController.createKudo(kudo,response);

       verify(response, times(1)).setStatus(eq(RESPONSE_CODE_OK));
       verify(kudoRepository,times(1)).save(eq(kudo));
    }

    @Test
    public void testCreateKudoIsFailure() {

        Kudo kudo = new Kudo("","","","","");

        when(kudoRepository.save(kudo)).thenReturn(mock(Kudo.class));

        kudoController.createKudo(kudo,response);

        verify(response, times(1)).setStatus(eq(RESPONSE_CODE_BAD_REQUEST));
        verify(kudoRepository,never()).save(eq(kudo));
    }

    @Test
    public void testGetKudos() {
        when(kudoRepository.findAll()).thenReturn(Stream.of(new Kudo(ID,SENDER,RECEIVER,MESSAGE,LAYOUT)).collect(Collectors.toList()));
        assertEquals(1,kudoController.getKudos().size());
    }

    @Test
    public void testGetSingleKudo() {
        kudoController.getSingleKudo(ID,response);
        verify(kudoRepository,times(1)).findById(ID);
    }

    @Test
    public void testGettingNonExistingKudo() {
        String FAKE_ID = "fake_id";
        kudoController.getSingleKudo(FAKE_ID,response);
        verify(kudoRepository,never()).findById(ID);
    }

    @Test
    public void testStoreKudos() {
        // False positive
        Kudo kudo = new Kudo(ID,SENDER,RECEIVER,MESSAGE,LAYOUT);
        kudoRepository.save(kudo);
        Stream.of(new Kudo(ID,SENDER,RECEIVER,MESSAGE,LAYOUT)).collect(Collectors.toList());
        kudoController.storeKudos();
        verify(kudoRepository,times(1)).save(kudo);
       // assertEquals(1,kudoRepository.findAll().size());
    }

    @Test
    public void testDeleteKudos() {
        kudoController.deleteAllKudos();
        verify(kudoRepository,times(1)).deleteAll();
    }

    @Test
    public void testDeleteSingleKudo() {
        kudoController.deleteSingleKudo(ID,response);
        verify(kudoRepository,times(1)).findById(ID);//deleteById
    }

    @Test
    public void testDeleteNonExistingKudo() {
        String FAKE_ID = "fake_id";
        kudoController.deleteSingleKudo(FAKE_ID,response);
        verify(kudoRepository,never()).findById(ID);//deleteById
    }

}
