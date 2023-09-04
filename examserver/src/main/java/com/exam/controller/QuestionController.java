package com.exam.controller;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
//    by autowiring object of this implementation class wil be form
    private QuestionService service;

    @Autowired
    private QuizService quizService;

//    add
    @PostMapping("/")
    public ResponseEntity<Question>add(@RequestBody Question question){
        return ResponseEntity.ok(this.service.addQuestion(question));
    }

//    update
    @PutMapping("/")
    public  ResponseEntity<Question> update(@RequestBody Question question){
        return ResponseEntity.ok(this.service.updateQuestion(question));
    }

//    get all question of any quiz
    @GetMapping("/quiz{qid}")
    public ResponseEntity<?>getQuestionOfQuiz(@PathVariable("quiz") Long qid){
//        Quiz quiz = new Quiz();
//        quiz.setQid(qid);
//        Set<Question> questionsOfQuiz= this.service.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List list=new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
            list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/quiz/all{qid}")
    public ResponseEntity<?>getQuestionOfQuizAdmin(@PathVariable("quiz") Long qid){
        Quiz quiz = new Quiz();
        quiz.setQid(qid);
        Set<Question> questionsOfQuiz= this.service.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);


//        return ResponseEntity.ok(list);
    }

//    get single question
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId")Long quesId){
        return this.service.getQuestion(quesId);
    }

//    delete question
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId){
        this.service.deleteQuestion(quesId);
    }

}
