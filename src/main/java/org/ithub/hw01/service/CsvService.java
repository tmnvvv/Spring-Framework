package org.ithub.hw01.service;

import org.ithub.hw01.domain.Question;

import java.util.List;

/*
 * @created 14/06/2021 - 17:31
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */
public interface CsvService {
    List<Question> getQuestions();
}
