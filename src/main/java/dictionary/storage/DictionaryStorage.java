package dictionary.storage;

import dictionary.exeption.RemoveException;
import dictionary.exeption.SearchException;
import dictionary.configuration.DictionaryType;
import dictionary.model.DictionaryLine;

import java.util.List;

/**
 * Интерфейс предоставляющий метододы для работы с данными словаря
 */
public interface DictionaryStorage {

    List<DictionaryLine> read(DictionaryType selectedDictionary);
    void add(String key, String value, DictionaryType selectedDictionary);
    void remove(String key, DictionaryType selectedDictionary) throws RemoveException;
    DictionaryLine search(String key, DictionaryType selectedDictionary) throws SearchException;

}
