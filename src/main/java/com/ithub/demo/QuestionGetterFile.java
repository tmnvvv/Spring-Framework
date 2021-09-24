package com.ithub.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionGetterFile implements QuestionGetter {

    public static List<AbstractQuestion> getQuestions() throws IOException {

        File f = new File("src/main/resources/questions.csv");
        Scanner sc = new Scanner(f);

        List<AbstractQuestion> items = new ArrayList<>();
        String data= sc.nextLine();
        System.out.println(data);

        while(sc.hasNext()){
            String[] questionCSVRepresentation = sc.nextLine().split(";");
            String question = questionCSVRepresentation[0];
            String[] options = questionCSVRepresentation[1].split(",");
            String[] answers = questionCSVRepresentation[2].split(",");
            AbstractQuestion q = new Question(question,options,answers);

            items.add(q);
        }

        return items;
    }

}
