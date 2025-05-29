package com.alamin.quizapp.service;

import com.alamin.quizapp.repository.QuestionRepository;
import com.alamin.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestion() {
       try {
           return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
       } catch (Exception e) {
          e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findAllByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
         questionRepository.save(question);
         return new ResponseEntity<>("Question added", HttpStatus.CREATED);
    }
}
