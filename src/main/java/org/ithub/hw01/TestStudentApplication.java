package org.ithub.hw01;

import org.ithub.hw01.service.QuestionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * @created 14/06/2021 - 17:17
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */
public class TestStudentApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cnt = new ClassPathXmlApplicationContext("spring/app-context.xml");
        QuestionService questionService = cnt.getBean("questionService", QuestionService.class);
        questionService.run();
        cnt.close();
    }
}
