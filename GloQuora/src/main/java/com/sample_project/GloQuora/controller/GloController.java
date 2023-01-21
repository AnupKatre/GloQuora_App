package com.sample_project.GloQuora.controller;


import com.sample_project.GloQuora.dto.GloQuoraPostDto;
import com.sample_project.GloQuora.model.GloQuoraPost;
import com.sample_project.GloQuora.service.GloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userspost")
public class GloController {

    @Autowired
    GloService service;

    @GetMapping("/getAllPost")
    public ResponseEntity<List<GloQuoraPost>> getAllGloQuora_Post() {
        return new ResponseEntity<List<GloQuoraPost>>(service.showAll(), HttpStatus.OK);
    }

    @GetMapping("/getPost/{id}")
    public ResponseEntity<GloQuoraPost> getGloQuora_PostById(@PathVariable("id") String id) {
        return new ResponseEntity<GloQuoraPost>(service.getPostById(id), HttpStatus.OK);
    }

    @PostMapping("/addPost")
    public ResponseEntity<String> addPost(@RequestBody GloQuoraPostDto post) {
        return new ResponseEntity(service.addPost(post), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") String id) {
        return new ResponseEntity<String>(service.deletePost(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/updatePost/{id}")
    public ResponseEntity<GloQuoraPost> updatePost(@PathVariable("id") String id,
                                        @RequestBody GloQuoraPostDto post) {
        return new ResponseEntity<GloQuoraPost>(service.updatePost(id, post), HttpStatus.ACCEPTED);

    }
}
