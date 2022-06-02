package dictionary.service;

import dictionary.exeption.SearchException;
import dictionary.configuration.DictionaryType;
import dictionary.model.DictionaryLine;
import dictionary.storage.*;
import dictionary.validator.Validator;
import java.util.List;

/**
 * Класс отвечает за разделение слоя хранения и слоя представления
 */
public class DictionaryService {

    DictionaryLineCodec dictionaryLineCodec = new DictionaryLineCodec();
    private final Validator validator;
    private final DictionaryStorage dictionaryStorage;



    public DictionaryService(Validator validator, DictionaryStorage dictionaryStorage) {
        this.validator = validator;
        this.dictionaryStorage= dictionaryStorage;
    }

    /**
     * Метод отвечает за валидацию введенный данных, и при успехе обращается к методу добавления относительно выбранного способа хранения
     * и выбранного языка
     * и возвращает true, при ошибке валидации возвращает false
     * @param key ключ, введенный пользователем
     * @param value, значение введенное пользователем
     * @param selectedDictionary выбранный язык словаря
     * @return логическое значение
     */
    public boolean addService(String key, String value, DictionaryType selectedDictionary) {
        if (validator.isValidPair(key, value, selectedDictionary)) {
            dictionaryStorage.addAll(key, value, selectedDictionary);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод отвечает за обращение к методу чтения данных относительно способа хранения и выбранного языка
     * @param selectedDictionary выбранный язык словаря
     * @return строки из хранилища
     */
    public List<String> readService(DictionaryType selectedDictionary) {
        return dictionaryLineCodec.decode(dictionaryStorage.read(selectedDictionary));
    }

    /**
     * Метод отвечает за оборащение к методу удаление данных относительно способа хранения и выбранного языка
     * @param key ключ, введенный пользователем
     * @param selectedDictionary выбранный язык словаря
     * @return логическое значение
     */
    public boolean removeService(String key, DictionaryType selectedDictionary) {
        return dictionaryStorage.remove(key, selectedDictionary);
    }


    /**
     * Метод отвечает за обращение к методу поиска значения по ключу и вывод строки относительно способа хранения выбранного языка
     * @param key ключ, введенный пользователем
     * @param selectedDictionary выбранный язык словаря
     * @return объект типа DictionaryLine
     * @throws SearchException ошибка поиска
     */
    public DictionaryLine searchService(String key, DictionaryType selectedDictionary) throws SearchException{
        return dictionaryStorage.search(key, selectedDictionary);
    }
}
