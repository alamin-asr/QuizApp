package com.alamin.quizapp.controller;

import com.alamin.quizapp.entity.QuestionWapper;
import com.alamin.quizapp.entity.Response;
import com.alamin.quizapp.entity.QuizResult;
import com.alamin.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizeService;

    @PostMapping("creat")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title) {
       return quizeService.creatQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWapper>> getQuizQuestions(@PathVariable Integer id) {
      return quizeService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<QuizResult> submitQuiz(@PathVariable Integer id, @RequestBody List<Response>responses) {
      return quizeService.calculateQuiz(id,responses);
    }
}
