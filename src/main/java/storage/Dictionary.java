package storage;

import configuration.DictionaryType;

import java.util.List;

public interface Dictionary {
    List<String> read();
    String add(String key, String value);
    void remove(String key) ;
    String search(String key);
    void setDictionaryType(DictionaryType dictionaryType);

}
