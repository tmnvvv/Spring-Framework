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
    
    private final List<Question> QUESTIONS = new ArrayList<>();

    public CsvServiceImpl(String fileName) {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream inputStream = loader.getResourceAsStream(fileName);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line = null;
            long idx = 0;
            while (null != (line = reader.readLine())) {
                String [] lines = line.split(":");
                this.QUESTIONS.add(new Question(idx++,lines[0],lines[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Question> getQuestions() {
        return Collections.unmodifiableList(QUESTIONS);
    }
}
