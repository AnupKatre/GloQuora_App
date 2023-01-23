package com.sample_project.GloQuora.service;

import com.sample_project.GloQuora.dto.GloQuoraPostDto;
import com.sample_project.GloQuora.model.GloQuoraPost;
import com.sample_project.GloQuora.repository.GloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class GloServiceImpl implements GloService {

    @Autowired(required = true)
    private GloRepository repository;

    @Override
    public List<GloQuoraPost> showAll() {

        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<GloQuoraPost> getPostByUserId(Long id) {
        List<GloQuoraPost> result = new ArrayList<GloQuoraPost>();

        try {
            if(!repository.existsByUserId(id)){
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return repository.findByUserId(id);
    }

    @Override
    public String addPost(GloQuoraPostDto post) {
        try {
            GloQuoraPost u = new GloQuoraPost();
            u.setTitle(post.getTitle());
            u.setUserId(post.getUserid());
            u.setBody(post.getBody());

            repository.save(u);
            return "Post Added!!";
        } catch (Exception e) {
            return e.getMessage();

        }
    }

    @Override
    public String deletePost(String id) {
        try {
            repository.deleteById(id);
            return "Successfully deleted post with ID = " + id;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public GloQuoraPost updatePost(String id, GloQuoraPostDto inputPost) {

        Optional<GloQuoraPost> obj = repository.findById(id);
        if (obj.isPresent()) {
            GloQuoraPost post = obj.get();
            if ((inputPost.getTitle() != null)) {
                post.setTitle(inputPost.getTitle());
            }
            if ((inputPost.getBody() != null)) {
                post.setBody(inputPost.getBody());
            }
            if ((inputPost.getUserid() != null)) {
                post.setUserId(inputPost.getUserid());
            }

            return repository.save(post);

        } else {
            throw new NullPointerException();
        }

    }
}
