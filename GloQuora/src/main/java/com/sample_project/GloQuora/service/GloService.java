package com.sample_project.GloQuora.service;

import com.sample_project.GloQuora.dto.GloQuoraPostDto;
import com.sample_project.GloQuora.model.GloQuoraPost;

import java.util.List;

public interface GloService {

    List<GloQuoraPost> showAll();

    GloQuoraPost getPostById(String id);

    String addPost(GloQuoraPostDto post);

    String deletePost(String id);

    GloQuoraPost updatePost(String id, GloQuoraPostDto post);
}
