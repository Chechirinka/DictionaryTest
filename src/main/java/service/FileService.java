package service;


import configuration.DictionaryType;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class FileService {


    private String path;

    public FileService(String path) {
        this.path = path;
    }

    private static final String ADD_KEY = "added";
    private static final String SIMILARITY_TO_THE_PATTERN = "erorr";

    public void fileClear() {
        try {
            new FileWriter(path, false).close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public String write(String key, String value) {

        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(path, StandardCharsets.UTF_8, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(key + DictionaryType.getSymbol() + value + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (Exception e) {
            }
        }
        return ADD_KEY;
    }

    public List<String> read() {

        List<String> results = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                results.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;

    }
}

