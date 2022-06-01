package dictionary.service;

import dictionary.exeption.SearchException;
import dictionary.configuration.DictionaryType;
import dictionary.model.DictionaryLine;
import dictionary.storage.*;
import dictionary.validator.Validator;
import java.util.List;

public class DictionaryService {

    private final Validator validator;
    private final DictionaryStorage dictionaryStorage;

    public DictionaryService(Validator validator, DictionaryStorage dictionaryStorage) {
        this.validator = validator;
        this.dictionaryStorage= dictionaryStorage;
    }


    public boolean addService(String key, String value, DictionaryType selectedDictionary) {
        if (validator.isValidPair(key, value, selectedDictionary)) {
            dictionaryStorage.addAll(key, value, selectedDictionary);
            return true;
        } else {
            return false;
        }
    }

    public List<DictionaryLine> readService(DictionaryType selectedDictionary) {
        return dictionaryStorage.read(selectedDictionary);
    }

    public boolean removeService(String key, DictionaryType selectedDictionary) {
        return dictionaryStorage.remove(key, selectedDictionary);
    }

    public DictionaryLine searchService(String key, DictionaryType selectedDictionary) throws SearchException{
        return dictionaryStorage.search(key, selectedDictionary);
    }
}
