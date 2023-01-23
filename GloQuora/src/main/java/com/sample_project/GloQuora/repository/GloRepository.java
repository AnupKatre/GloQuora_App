package com.sample_project.GloQuora.repository;

import com.sample_project.GloQuora.model.GloQuoraPost;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface GloRepository extends MongoRepository<GloQuoraPost,String> {
    public List<GloQuoraPost> findByUserId(Long userId);

    public Boolean existsByUserId(Long id);
}
