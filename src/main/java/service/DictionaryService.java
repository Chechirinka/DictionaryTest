package service;

import DictionaryException.RemoveException;
import DictionaryException.SearchException;
import configuration.DictionaryType;
import model.DictionaryLine;
import storage.*;
import validator.Validator;
import java.util.List;

import static storage.MapStorage.NO_KEY;

public class DictionaryService {

    private final Validator validator;
    private final DictionaryStorage dictionaryStorage;

    public DictionaryService(Validator validator, DictionaryStorage dictionaryStorage) {
        this.validator = validator;
        this.dictionaryStorage= dictionaryStorage;
    }


    public String addService(String key, String value, DictionaryType selectedDictionary) {
        if (validator.isValidPair(key, value, selectedDictionary)) {
            dictionaryStorage.add(key, value, selectedDictionary);
            return "Success";
        } else {
            return "Error";
        }
    }

    public List<DictionaryLine> readService(DictionaryType selectedDictionary) {
        return dictionaryStorage.read(selectedDictionary);
    }

    public void removeService(String key, DictionaryType selectedDictionary) throws RemoveException {
        dictionaryStorage.remove(key, selectedDictionary);
    }

    public DictionaryLine searchService(String key, DictionaryType selectedDictionary) throws SearchException{
        return dictionaryStorage.search(key, selectedDictionary);
    }
}
