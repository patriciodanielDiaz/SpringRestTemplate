package com.utn.microserviceA.repository;

import com.utn.microserviceA.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
//public interface TicketRepository extends JpaRepository<Ticket,Integer> {
//}

@Repository
public class TicketRepository {

    List<Ticket> listList;

    public TicketRepository() {

        this.listList = new ArrayList<>();
        for(int i=0;i<10;i++){
            listList.add(Ticket.createTicket());
        }
    }

    public List<Ticket> findAll(){
        return this.listList;
    }

    public Ticket getById(UUID uuid){

        Ticket tk =new Ticket();
        for (Ticket ticket: this.listList) {

            if(ticket.getUuid().equals(uuid)){
                tk=ticket;
            }
        }
        return tk;
    }
}