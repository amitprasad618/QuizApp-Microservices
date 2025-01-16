package com.amit.questionService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.questionService.service.QuestionService;
import com.amit.questionService.model.Question;
import com.amit.questionService.model.QuestionWrapper;
import com.amit.questionService.model.QuestionsResponse;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestion")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestions();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Question> getAllQuestion1(@PathVariable("id") int ID) {
        return questionService.getdatabyId(ID);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getAllQuestion1(@PathVariable("category") String category) {
        return questionService.getdatabyCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("id") int ID) {
        return questionService.deleteQuestion(ID);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQues) {
        return questionService.getQuestionsForQuiz(categoryName, numQues);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Integer> quesId) {
        return questionService.getQuestionById(quesId);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<QuestionsResponse> responses) {
        return questionService.getScore(responses);
    }
}
