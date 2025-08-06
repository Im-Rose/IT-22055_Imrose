package com.example.banglaquiz.controller;

import com.example.banglaquiz.model.QuizScore;
import com.example.banglaquiz.repository.QuizScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizController {

    @Autowired
    private QuizScoreRepository quizScoreRepository;

    @GetMapping("/quiz")
    public String showQuizForm() {
        return "quiz";  // Thymeleaf template: quiz.html
    }

    @PostMapping("/submit")
    public String submitQuiz(
            @RequestParam String studentId,
            @RequestParam String q1,
            @RequestParam String q2,
            Model model) {

        int score = 0;

        // Chemistry question 1: পানির রাসায়নিক সূত্র কী?
        if ("H2O".equalsIgnoreCase(q1)) score += 55;

        // Chemistry question 2: অ্যাটমের কেন্দ্র অংশ কী নামে পরিচিত?
        if ("নিউক্লিয়াস".equalsIgnoreCase(q2)) score += 55;

        QuizScore quizScore = new QuizScore();
        quizScore.setStudentId(studentId);
        quizScore.setScore(score);
        quizScoreRepository.save(quizScore);

        model.addAttribute("score", score);
        return "result";  // Thymeleaf template: result.html
    }
}
