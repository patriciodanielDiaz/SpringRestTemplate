package com.utn.microserviceA.controller;

import com.utn.microserviceA.model.Ticket;
import com.utn.microserviceA.model.UuidDto;
import com.utn.microserviceA.service.TicketService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/serviceA")
public class TicketController {

    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @ApiOperation(value= "get all ticket ")
    @ApiResponses(value={
            @ApiResponse(code =200, message = "successful ticket"),

    })
    @GetMapping("/")
    public ResponseEntity<List<Ticket>> getTickets(){

        ResponseEntity responseEntity=ResponseEntity.ok(ticketService.getTicket());
        return responseEntity;
    }


    @ApiOperation(value= "get ticket by id")
    @ApiResponses(value={
            @ApiResponse(code =200, message = "successful ticket"),
            @ApiResponse(code =400, message = "incomplete data"),
            @ApiResponse(code =401, message = "ticket not exists")
    })
    @PostMapping("/")
    public ResponseEntity<Ticket> getById(@RequestBody UuidDto uuid){

        //System.out.println(uuid.getUuid());
        UUID id =UUID.fromString(uuid.getUuid());
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

}
