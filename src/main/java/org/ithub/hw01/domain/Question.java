package org.ithub.hw01.domain;

/*
 * @created 14/06/2021 - 17:20
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */
public class Question {
    private Long id;
    private String question;
    private String answer;

    public Question() {
    }

    public Question(Long id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
