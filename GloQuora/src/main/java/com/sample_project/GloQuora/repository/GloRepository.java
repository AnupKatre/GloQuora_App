package com.sample_project.GloQuora.repository;

import com.sample_project.GloQuora.model.GloQuoraPost;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface GloRepository extends MongoRepository<GloQuoraPost,String> {
}
