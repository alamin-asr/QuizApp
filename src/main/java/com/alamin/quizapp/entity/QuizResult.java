package com.alamin.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class QuizResult {
    private List<Response> User_Responses;
    private int Totall_Right_Answer;


}