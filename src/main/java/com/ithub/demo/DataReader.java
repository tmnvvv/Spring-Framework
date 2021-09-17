package com.ithub.demo;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataReader {
    public static List<String[]> extractCSVData(File csvFile) throws IOException, CsvException {
        List<String[]> data;
        CSVParser parser =
                new CSVParserBuilder()
                        .withSeparator(';')
                        .build();
        CSVReader reader =
                new CSVReaderBuilder(
                        new FileReader(csvFile))
                        .withCSVParser(parser)
                        .withSkipLines(1)
                        .build();
        data = reader.readAll();
        return data;
    }
}
