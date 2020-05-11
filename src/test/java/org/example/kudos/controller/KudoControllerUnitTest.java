package org.example.kudos.controller;

import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KudoControllerUnitTest {

    @Autowired
    private KudoController kudoController;

    @MockBean
    private KudoRepository kudoRepository;

    @Mock
    HttpServletResponse response;

    @Test
    public void testSaveKudos() {
        Kudo kudoMock = mock(Kudo.class);
        Kudo kudo = new Kudo("id","sender","receiver","message","layout");
        when(kudoRepository.save(kudo)).thenReturn(kudoMock);

      //  verify(kudoMock,times(1));

    }

    @Test
    public void testGetKudos() {
        when(kudoRepository.findAll()).thenReturn(Stream.of(new Kudo("id","sender","receiver","message","layout")).collect(Collectors.toList()));
        assertEquals(1,kudoController.getKudos().size());
    }

    @Test
    public void testGetSingleKudo() {
        Kudo kudoMock = mock(Kudo.class);
        Kudo kudo = new Kudo("id","sender","receiver","message","layout");
        //kudoRepository.findById(id).isPresent()
        when(kudoRepository.findById("id").get()).thenReturn(kudoMock);

    }

    @Test
    public void testWhenGetSingleKudoReturnsNull() {
        //Kudo kudoMock = mock(Kudo.class);
        Kudo kudo = new Kudo("1L","sender","receiver","message","layout");
        kudoRepository.save(kudo);
        //when(kudoRepository.save(kudo)).thenReturn(kudoMock);
        when(kudoRepository.findById("1L").get()).thenReturn(kudo);

    }


    @Test
    public void testStoreKudos() {
        Kudo kudo = new Kudo("id","sender","receiver","message","layout");
        when(kudoRepository.save(kudo)).thenReturn(kudo);
        int index = 0;
       // when(kudoRepository.findAll().get()).thenReturn(Stream.of(new Kudo("id","sender","receiver","message","layout")).collect(Collectors.toList()));
        when(kudoRepository.findAll().get(index)).thenReturn(kudo);
        assertEquals(1,kudoController.getKudos().size());
    }


}
