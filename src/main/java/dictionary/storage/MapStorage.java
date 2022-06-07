package dictionary.storage;

import dictionary.configuration.DictionaryType;
import dictionary.model.DictionaryLine;

import java.util.*;

/**
 * Класс отвечающий за хранение словаря в оперативной памяти
 */
public class MapStorage implements DictionaryStorage {

    public static final String NO_KEY = "No key found!";
    public static Map<String, DictionaryLine> map = new HashMap<>();

    /**
     * Метод, который отвечает за чтение данных из мапы
     *
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <Ключ, Значение>
     */
    @Override
    public List<DictionaryLine> read(DictionaryType selectedDictionary) {

        return new ArrayList<>(map.values());
    }

    /**
     * Метод, который отвечает за добавление данных в мапу
     *
     * @param key                - ключ
     * @param value              - значение
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <Ключ, Значение>
     */
    @Override
    public boolean addAll(String key, String value, DictionaryType selectedDictionary) {
        map.put(key, new DictionaryLine(key, value));
        return true;
    }

    /**
     * Метод, который отвечает за удаление данных из мапы
     *
     * @param key                - ключ
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <Ключ, Значение>
     */
    @Override
    public boolean remove(String key, DictionaryType selectedDictionary) {

        if (map.containsKey(key)) {
            map.remove(key);
            return true;
        }
        return false;
    }
     /**
     * Метод, который отвечает за поиск данных в мапе
     *
     * @param key                - ключ
     * @param selectedDictionary - принимает вид языка с которым работает
     * @return mapRead - возвращает список пар <Ключ, Значение>
     */
    @Override
    public DictionaryLine search(String key, DictionaryType selectedDictionary){

        DictionaryLine search = map.get(key);
        if (search != null) {
            return search;
        } else {
            return null;
        }
    }
}




