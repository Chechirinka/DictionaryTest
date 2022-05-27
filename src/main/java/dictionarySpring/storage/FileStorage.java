package dictionarySpring.storage;

import dictionarySpring.configuration.DictionaryType;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;


public class FileStorage implements DictionaryStorage {


    private static final String ADD_KEY = "added";

    public void fileClear(String path) {
        try {
            new FileWriter(path, false).close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
 private  File getDictionaryFile(String path) throws IOException {
     return new ClassPathResource(path).getFile();
 }

    public String write(String key, String value, String path) {

        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(getDictionaryFile(path), UTF_8, true);
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

    public List<String> operationRead(String path) {

        List<String> results = new ArrayList<String>();
        try {

            BufferedReader reader =  new BufferedReader(new InputStreamReader(new FileInputStream(getDictionaryFile(path)), UTF_8));
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

    @Override
    public List<String> read(DictionaryType selectedDictionary) {
        return operationRead(selectedDictionary.getDictionaryPath());
    }

    @Override
    public String add(String key, String value, DictionaryType selectedDictionary) {
        return write(key, value, selectedDictionary.getDictionaryPath());
    }

    @Override
    public void remove(String key, DictionaryType selectedDictionary) {

        List<String> readLines = operationRead(selectedDictionary.getDictionaryPath());
        for (int i = 0; i < readLines.size(); i++) {
            if (key.equals(readLines.get(i).split(DictionaryType.getSymbol())[0])) {
                readLines.remove(i);
                break;
            }
        }
        fileClear(selectedDictionary.getDictionaryPath());
        for (String readLine : readLines) {
            String[] keyAndValue = readLine.split(DictionaryType.getSymbol());
            write(keyAndValue[0], keyAndValue[1], selectedDictionary.getDictionaryPath());
        }
    }

    public String search(String key, DictionaryType selectedDictionary) {
        List<String> searchLines = operationRead(selectedDictionary.getDictionaryPath());
        for (int i = 0; i < searchLines.size(); i++) {
            if (key.equals(searchLines.get(i).split(DictionaryType.getSymbol())[0])) {
                return searchLines.get(i);
            }
        }
        return null;
    }
}