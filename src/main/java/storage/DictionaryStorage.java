package storage;

import DictionaryException.RemoveException;
import DictionaryException.SearchException;
import configuration.DictionaryType;
import model.DictionaryLine;

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
