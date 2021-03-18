package com.utn.microserviceA.controllerTest;

import com.utn.microserviceA.controller.TicketController;
import com.utn.microserviceA.model.Ticket;
import com.utn.microserviceA.service.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class TicketControllerTest {

    @Mock
    TicketService ticketService;
    TicketController ticketController;

    @Before
    public void setUp(){
        initMocks(this);
        this.ticketController =new TicketController(ticketService);
    }

    @Test
    public void getLoggerTest(){

        List<Ticket> tickets=new ArrayList<>();
        ResponseEntity expect=ResponseEntity.ok(tickets);
        when(ticketService.getTicket()).thenReturn(tickets);

        ResponseEntity actual= ticketController.getTickets();

        assertEquals(expect,actual);
        verify(ticketService,times(1)).getTicket();
    }
}
