package com.alamin.quizapp.controller;

import com.alamin.quizapp.entity.QuestionWrapper;
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
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title) {
       return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
      return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<QuizResult> submitQuiz(@PathVariable Integer id, @RequestBody List<Response>responses) {
      return quizService.calculateQuiz(id,responses);
    }
}
