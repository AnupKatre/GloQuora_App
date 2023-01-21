package com.sample_project.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/getAllUserAndPost")
    public ResponseEntity showUserAndPost(){
        String allUser= "http://localhost:9001/User/getAll";
        String allPost= "http://localhost:9002/userspost/getAllPost";
        RestTemplate restTemplate = new RestTemplate();
        String users = restTemplate.getForObject(allUser, String.class);
        String posts = restTemplate.getForObject(allUser, String.class);
//        JSONObject json = new JSONObject(users+posts);
        return new ResponseEntity("User Data - \t"+users+"\n All Post -\t"+posts, HttpStatus.OK);
    }
}
