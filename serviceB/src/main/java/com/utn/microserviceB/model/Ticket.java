package com.utn.microserviceB.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ticket{

    UUID uuid;
    Integer discount;

    public static Ticket createTicket(){
        return new Ticket(UUID.randomUUID(),(int)(Math.random()*10+1));
    }
}