package storage;

import DictionaryException.RemoveException;
import DictionaryException.SearchException;
import configuration.DictionaryType;
import model.DictionaryLine;
import service.DictionaryLineCodec;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static storage.MapStorage.KEY_DOES_NOT_EXIST;
import static storage.MapStorage.NO_KEY;

/**
 * Класс отвечающий за хранение словаря в файловой системе
 */
public class FileStorage implements DictionaryStorage {

    public String path;

    public void fileClear() {
        try {
            new FileWriter(path, false).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, который отвечает за доступ к файлу
     * @param key - ключ
     * @param value - значение
     * @param path - принимает путь
     */
    public void write(String key, String value, String path) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(path, UTF_8, true));
        try (writer) {
            DictionaryLine dictionaryLine = new DictionaryLine(key, value);
            writer.write(dictionaryLine + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, который отвечает за доступ к файлу
     * @param path - принимает путь
     * @return - возвращает список <ключ,значение>
     */
    public List<DictionaryLine> operationRead(String path) {

        List<DictionaryLine> results = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                results.add(DictionaryLineCodec.encode(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Метод, который отвечает за чтение данных из файла
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <ключ, значение>
     */
    @Override
    public List<DictionaryLine> read(DictionaryType selectedDictionary) {
        return operationRead(selectedDictionary.getDictionaryPath());
    }

    /**
     * Метод, который отвечает за добавление данных в файл
     * @param key - ключ
     * @param value - значение
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <ключ, значение>
     */
    @Override
    public void add(String key, String value, DictionaryType selectedDictionary) {
        try {
            write(key, value, selectedDictionary.getDictionaryPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /***
     * Метод, который отвечает за удаление данных из файла
     * @param key - ключ
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <ключ, значение>
     */
    @Override
    public void remove(String key, DictionaryType selectedDictionary) throws RemoveException {
        boolean isRemoved = false;
        List<DictionaryLine> readLines = operationRead(selectedDictionary.getDictionaryPath());
        for (DictionaryLine dictionaryLine : readLines) {
            if (dictionaryLine.getKey().equals(key)) {
                isRemoved = readLines.remove(dictionaryLine);
                continue;
            }
        }
        if (!isRemoved){
            throw new RemoveException(KEY_DOES_NOT_EXIST);
        }
        fileClear();
        for (DictionaryLine readLine : readLines) {
            try {
                write(readLine.getKey(), readLine.getValue(), selectedDictionary.getDictionaryPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

    /**
     * Метод, который отвечает за поиск данных в файле
     * @param key - ключ
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <ключ, значение>
     */
    @Override
    public DictionaryLine search(String key, DictionaryType selectedDictionary) throws SearchException {
        List<DictionaryLine> searchLines = operationRead(selectedDictionary.getDictionaryPath());
        for (DictionaryLine searchLine : searchLines) {
            if (key.equals(searchLine.getKey())) {
                return searchLine;
            }
        }throw new SearchException(NO_KEY);
    }
}