package com.ithub.demo;

import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingForm(Model model) throws IOException, CsvException {
        List<String[]> data = DataReader.extractCSVData(new File("src/main/resources/questions.csv"));
        List<Question> questions = new ArrayList<>();
        for (String[] datum : data) {
            questions.add(new Question(datum[0], datum[1].split(","), datum[2]));
        }
        model.addAttribute("questions", questions);
        return "index";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String resultPage() {
        return "result";
    }
}