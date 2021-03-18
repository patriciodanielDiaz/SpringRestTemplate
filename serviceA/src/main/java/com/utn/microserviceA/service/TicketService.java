package com.utn.microserviceA.service;

import com.utn.microserviceA.model.Ticket;
import com.utn.microserviceA.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository=ticketRepository;
    }

    public List<Ticket> getTicket(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(UUID uuid) { return  ticketRepository.getById(uuid); }
}
