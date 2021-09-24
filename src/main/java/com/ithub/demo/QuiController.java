package com.ithub.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuiController {
    List<AbstractQuestion> questions = QuestionGetterFile.getQuestions();

    public QuiController() throws IOException {
    }

    @GetMapping(value = "/")
    public String Quiz(Model model) {
        model.addAttribute("questions", questions);

        return "index";
    }
    @PostMapping(value = "/result")
    public String ResultGiver(Model model ,@RequestBody String request) {
        
        String response = URLDecoder.decode(request);
        Map <Integer,String> results = new HashMap<>();
        
//        String[] answers = response.split("&");
//        for (String answer:answers) {
        for (String answer:response.split("&")) {
            String[] questionData = answer.split("=");
/* s
            Integer id =  Integer.parseInt(questionData[0]);
            String ans = questionData[1];
            results.put(id,ans);
*/
            results.put(Integer.parseInt(questionData[0]),questionData[1]);

        }
        int rightAnswers = 0;
        int wrongAnswers = 0;
        for (AbstractQuestion question:questions) {
            if(results.containsKey(question.getID())){
                if (question.getAnswers()[0].equals(results.get(question.getID()))){

                    rightAnswers++;
                }
                else{

                    wrongAnswers++;
                }
            }
        }
        model.addAttribute("right",rightAnswers);
        model.addAttribute("wrong",wrongAnswers);
        return "result";
    }
}
