package com.utn.microserviceB.controller;

import com.utn.microserviceB.model.Ticket;
import com.utn.microserviceB.model.UuidDto;
import com.utn.microserviceB.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/serviceB")
public class TicketController {

    IntegrationService integrationService;

    @Autowired
    public TicketController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Ticket>> getAllTicket(){
        return integrationService.getAllTicket();
    }

    @PostMapping("/")
    public ResponseEntity<Ticket> getTicket(@RequestBody UuidDto uuid){

        //UUID id= UUID.fromString(uuid.getUuid());
        return integrationService.getTicket(uuid);
    }

}
