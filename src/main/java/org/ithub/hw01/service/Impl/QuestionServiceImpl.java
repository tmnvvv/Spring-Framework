package org.ithub.hw01.service.Impl;

import org.ithub.hw01.domain.Question;
import org.ithub.hw01.service.CsvService;
import org.ithub.hw01.service.QuestionService;

import java.util.List;
import java.util.Scanner;

/*
 * @created 14/06/2021 - 17:21
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */
public class QuestionServiceImpl implements QuestionService {
    private final CsvService csvService;

    public QuestionServiceImpl(CsvService csvService) {
        this.csvService = csvService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("0. Выход");
            System.out.println("1. Вывести список вопросов");
            System.out.println("2. Начать тестирование");
            System.out.print("> ");
            int value = scanner.nextInt();
            switch (value) {
                case 0: {
                    flag = false;
                    break;
                }
                case 1: {
                    showQuestions();
                    break;
                }
                case 2: {
                    testRunner();
                    break;
                }
            }
        } while (flag);

    }

    public void showQuestions () {
        List<Question> questions = this.csvService.getQuestions();
        System.out.println("Список вопросов:");
        questions.stream().forEach(question -> System.out.format("%d.%-60s\n", question.getId(), question.getQuestion()));
        System.out.println("\n");
    }

    public void testRunner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя: ");
        String userName = scanner.nextLine();
        System.out.println(userName + ",приготовьтесь ответить на несколько вопросов!");
        System.out.println("Если готовы, нажмите \"Enter\"");
        scanner.nextLine();

        int idx = 0;
        List<Question> questions = this.csvService.getQuestions();
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            System.out.print("answer -> ");
            String userAnswer = scanner.nextLine().trim();
            String answer = question.getAnswer().trim();
            if(userAnswer.equalsIgnoreCase(answer)) {
                idx++;
            }
        }

        System.out.format("%s, вы ответили правильно на %d из %d\n", userName, idx, questions.size());


    }

}
