package com.alamin.quizapp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response
{
    private Integer id;
    private String response;
    private String check;
    private String correctAnswer;



}
