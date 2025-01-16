package com.amit.quizService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amit.quizService.dao.QuizDao;
import com.amit.quizService.feign.QuizInterface;
import com.amit.quizService.model.QuestionWrapper;
import com.amit.quizService.model.QuestionsResponse;
import com.amit.quizService.model.Quiz;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String categoryName, Integer numQues, String title) {

        //call the generate url - RestTemplate http://localhost:8080/question/generate Eureka and feign will fix this Pblm
        List<Integer> questions = quizInterface.getQuestionsForQuiz(categoryName, numQues).getBody();
        
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);

        return new ResponseEntity<>("Sucessfully Created Quiz", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
        Quiz quiz = quizdao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestions();

        ResponseEntity<List<QuestionWrapper>> questionForUser = quizInterface.getQuestionById(questionIds);

        return questionForUser;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<QuestionsResponse> responses) {
        
        ResponseEntity<Integer> result = quizInterface.getScore(responses);

        return result;
    }
}
