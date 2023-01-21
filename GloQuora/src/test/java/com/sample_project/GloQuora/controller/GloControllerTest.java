package com.sample_project.GloQuora.controller;

import com.sample_project.GloQuora.dto.GloQuoraPostDto;
import com.sample_project.GloQuora.model.GloQuoraPost;
import com.sample_project.GloQuora.service.GloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GloController.class)
class GloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GloService mockService;

    @Test
    void testGetAllGloQuora_Post() throws Exception {
        // Setup
        // Configure GloService.showAll(...).
        final List<GloQuoraPost> gloQuoraPosts = List.of(new GloQuoraPost("id", "title", 0L, "body"));
        when(mockService.showAll()).thenReturn(gloQuoraPosts);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/GloQuora/getAllPost")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetAllGloQuora_Post_GloServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockService.showAll()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/GloQuora/getAllPost")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetGloQuora_PostById() throws Exception {
        // Setup
        // Configure GloService.getPostById(...).
        final GloQuoraPost gloQuoraPost = new GloQuoraPost("id", "title", 0L, "body");
        when(mockService.getPostById("id")).thenReturn(gloQuoraPost);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/GloQuora/getPost/{id}", "id")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testAddPost() throws Exception {
        // Setup
        when(mockService.addPost(new GloQuoraPostDto("id", "title", 0L, "body"))).thenReturn("body");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/GloQuora/addPost")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDeletePost() throws Exception {
        // Setup
        when(mockService.deletePost("id")).thenReturn("body");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/GloQuora/deletePost/{id}", "id")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testUpdatePost() throws Exception {
        // Setup
        // Configure GloService.updatePost(...).
        final GloQuoraPost gloQuoraPost = new GloQuoraPost("id", "title", 0L, "body");
        when(mockService.updatePost("id", new GloQuoraPostDto("id", "title", 0L, "body"))).thenReturn(gloQuoraPost);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/GloQuora/updatePost/{id}", "id")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
