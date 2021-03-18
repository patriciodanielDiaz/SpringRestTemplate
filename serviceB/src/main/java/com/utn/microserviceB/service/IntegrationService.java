package com.utn.microserviceB.service;

import com.utn.microserviceB.model.Ticket;
import com.utn.microserviceB.model.UuidDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IntegrationService {

    IntegrationComponent integrationComponent;

    @Autowired
    public IntegrationService(IntegrationComponent integrationComponent) {
        this.integrationComponent = integrationComponent;
    }

    public ResponseEntity<List<Ticket>> getAllTicket(){
        return integrationComponent.getAllTicket();
    }

    public ResponseEntity<Ticket> getTicket(UuidDto uuid) {
        return integrationComponent.getTicket(uuid);
    }
}
