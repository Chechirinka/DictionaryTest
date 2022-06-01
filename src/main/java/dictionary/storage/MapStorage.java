package dictionary.storage;

import dictionary.DictionaryException.RemoveException;
import dictionary.configuration.DictionaryType;
import dictionary.model.DictionaryLine;

import java.util.*;

/**
 * Класс отвечающий за хранение словаря в оперативной памяти
 */
public class MapStorage implements DictionaryStorage {

    public static final String NO_KEY = "No key found!";
    public static final String KEY_DOES_NOT_EXIST = "This key does not exist!";

    public List<DictionaryLine> dictionaryLines = new LinkedList<>();

    /**
     * Метод, который отвечает за чтение данных из мапы
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <Ключ, Значение>
     */
    @Override
    public List<DictionaryLine> read(DictionaryType selectedDictionary) {

        return dictionaryLines;
    }

    /**
     * Метод, который отвечает за добавление данных в мапу
     * @param key - ключ
     * @param value - значение
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <Ключ, Значение>
     */
    @Override
    public void add(String key, String value, DictionaryType selectedDictionary) {
       dictionaryLines.add(new DictionaryLine(key, value) );
    }

    /**
     * Метод, который отвечает за удаление данных из мапы
     * @param key - ключ
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <Ключ, Значение>
     */
    @Override
    public void remove(String key, DictionaryType selectedDictionary) throws RemoveException {
        for (DictionaryLine dictionaryLine : dictionaryLines) {
            if (dictionaryLine.getKey().equals(key)) {
                dictionaryLines.remove(dictionaryLine);
                return;
            }
        }throw new RemoveException(KEY_DOES_NOT_EXIST);
    }

    /**
     * Метод, который отвечает за поиск данных в мапе
     * @param key - ключ
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <Ключ, Значение>
     */
    @Override
    public DictionaryLine search(String key, DictionaryType selectedDictionary) throws RuntimeException{
        for (DictionaryLine dictionaryLine : dictionaryLines) {
            if (dictionaryLine.getKey().equals(key)) {
                return dictionaryLine;
            }
        }throw new RuntimeException(NO_KEY);
    }
}




