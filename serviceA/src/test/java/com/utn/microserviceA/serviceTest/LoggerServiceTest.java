package com.utn.microserviceA.serviceTest;

import com.utn.microserviceA.model.Ticket;
import com.utn.microserviceA.repository.TicketRepository;
import com.utn.microserviceA.service.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoggerServiceTest {

    @Mock
    TicketRepository loggerRepository;
    TicketService ticketService;

    @Before
    public void setUp(){
        initMocks(this);
        this.ticketService =new TicketService(loggerRepository);
    }

    @Test
    public void getLoggerTest(){

        List<Ticket> loggers=new ArrayList<>();
        when(loggerRepository.findAll()).thenReturn(loggers);
        List<Ticket> actual= ticketService.getTicket();

        assertEquals(loggers,actual);
        verify(loggerRepository,times(1)).findAll();
    }
}
