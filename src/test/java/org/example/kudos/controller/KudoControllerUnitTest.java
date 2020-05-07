package org.example.kudos.controller;

import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.testng.annotations.Test;

import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
//@RunWith(PowerMockRunner.class)
public class KudoControllerUnitTest {
   /* @Mock
    private KudoRepository kudoRepository;

    @InjectMocks
    KudoController kudoController;

    HttpServletResponse response;

    @Test
    public void testSaveKudo() {
        Kudo kudo = mock(Kudo.class);
        kudoController.createKudo(kudo,response);
        verify(kudoRepository.save(kudo));
    }*/
}
