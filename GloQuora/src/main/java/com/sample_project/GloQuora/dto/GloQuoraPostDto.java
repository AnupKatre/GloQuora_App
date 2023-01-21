package com.sample_project.GloQuora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GloQuoraPostDto {
    String id;
    String title;
    Long userid;
    String body;
}
