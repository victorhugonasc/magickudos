package org.example.kudos.controller;

import org.example.kudos.model.Kudo;
import org.example.kudos.repository.KudoRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class KudoControllerUnitTest {
    @Mock
    private KudoRepository kudoRepository;

    @InjectMocks
    KudoController kudoController;

    @Mock
    HttpServletResponse response;

    @Test
    public void testSaveKudo() {
        Kudo kudo = mock(Kudo.class);

        doNothing().when(kudoController.createKudo(any(),any()));
       // doNothing().when(kudoRepository.save(any(Kudo.class)));

        kudoController.createKudo(kudo,response);
        verify(kudoRepository.save(kudo));
    }
}
