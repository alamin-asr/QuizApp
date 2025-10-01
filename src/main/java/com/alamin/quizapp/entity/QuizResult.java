package com.alamin.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class QuizResult {
    private List<Response> User_Responses;
    private int Total_Right_Answer;


}