package com.amit.questionService.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuestionsResponse {
    private Integer id;
    private String response;
}
