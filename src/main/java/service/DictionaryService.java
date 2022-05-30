package service;

import configuration.DictionaryType;
import storage.*;
import validator.Validator;
import java.util.List;

public class DictionaryService {

    private final Validator validator;
    private final DictionaryStorage dictionaryStorage;

    public DictionaryService(Validator validator, DictionaryStorage dictionaryStorage) {
        this.validator = validator;
        this.dictionaryStorage= dictionaryStorage;
    }


    public String addService(String key, String value, DictionaryType selectedDictionary) {
        if (validator.isValidPair(key, value, selectedDictionary)) {
            return dictionaryStorage.add(key, value, selectedDictionary);
        } else {
            return "Error";
        }
    }

    public List<String> readService(DictionaryType selectedDictionary) {
        return dictionaryStorage.read(selectedDictionary);
    }

    public void removeService(String key, DictionaryType selectedDictionary) {
        dictionaryStorage.remove(key, selectedDictionary);
    }

    public String searchService(String key, DictionaryType selectedDictionary) {
        return dictionaryStorage.search(key, selectedDictionary);
    }
    }
