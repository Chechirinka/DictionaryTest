package storage;

import configuration.DictionaryType;

import java.util.List;

public interface DictionaryStorage {
    List<String> read(DictionaryType selectedDictionary);
    String add(String key, String value, DictionaryType selectedDictionary);
    void remove(String key, DictionaryType selectedDictionary) ;
    String search(String key, DictionaryType selectedDictionary);
    String getSymbol();
}
