package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;

@Component
public class Schedul implements SchedulInterface {

    @Autowired
    private Client client;

    @Override
    @Scheduled(fixedRate = 10*60*1000)
    public void schedul(){
        try {
            System.out.println("Starting send request...");
            String response = client.target("https://int20h.herokuapp.com").request().get().readEntity(String.class);
            System.out.println("Response: " + response);
        } catch (Throwable e){
            System.out.println(e);
        }
    }
}
