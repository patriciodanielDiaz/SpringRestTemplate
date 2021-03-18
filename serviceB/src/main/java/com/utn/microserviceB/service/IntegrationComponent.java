package com.utn.microserviceB.service;

import com.utn.microserviceB.model.Ticket;
import com.utn.microserviceB.model.UuidDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Component
public class IntegrationComponent {

    private RestTemplate restTemplate;
    private static String url = "http://localhost:8080/api/serviceA/";

    @PostConstruct
    private void init(){
        restTemplate=new RestTemplateBuilder().build();
    }

    /*public ResponseEntity<List<Ticket>> getAllTicket(){

        ResponseEntity<List<Ticket>> res;
        try{
            res=restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Ticket>>() {});
        }
        catch (RestClientResponseException e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).header("The server did not respond ok").build();
        }
        return res;
    }*/

    public ResponseEntity<Ticket> getTicket(UuidDto uuid) {

        UuidDto u= restTemplate.postForObject(url,uuid,UuidDto.class);

        System.out.println(u);
        return ResponseEntity.ok(new Ticket());
    }

    //
    public ResponseEntity<List<Ticket>> getAllTicket(){

        //exchange() devuelve list
        ResponseEntity<List<Ticket>> res=restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Ticket>>() {});

        //getForObject () devuelve string
        //String rest = restTemplate.getForObject(url, String.class);

        //getForObject () devuelve objeto
        //Ticket result = restTemplate.getForObject(url, Ticket.class);

        //getForEntity () devuelve ResponseEntity
        //ResponseEntity<Ticket> resp = restTemplate.getForEntity(url, Ticket.class);



        return res;
    }

 }
