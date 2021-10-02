package org.ithub.hw01.service.Impl;

import org.ithub.hw01.domain.Question;
import org.ithub.hw01.service.CsvService;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @created 14/06/2021 - 17:31
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */
public class CsvServiceImpl implements CsvService {

    private final String CSV_FILE_NAME;
    private final List<Question> QUESTIONS = new ArrayList<>();

    public CsvServiceImpl(String fileName) {
        this.CSV_FILE_NAME = fileName;
    }

    @Override
    public List<Question> getQuestions() {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream inputStream = loader.getResourceAsStream(CSV_FILE_NAME);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line = null;
            long idx = 0;
            while (null         != (line = reader.readLine())) {
                String [] lines = line.split(":");
                this.QUESTIONS.add(new Question(idx++,lines[0],lines[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(QUESTIONS);
    }
}
