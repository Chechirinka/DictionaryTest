package service;

import configuration.DictionaryType;
import storage.*;
import validator.ValidInterface;
import validator.Validation;

import java.util.List;

public class DictionaryService {


    public String addService(String key, String value) {
        if (validInterface.isValidPair(key, value)) {
            return dictionaryStorage.add(key, value);
        } else {
            return "Error";
        }
    }

    public List<String> readService() {
        return dictionaryStorage.read();
    }

    public void removeService(String key) {
        dictionaryStorage.remove(key);
    }

    public String searchService(String key) {
        return dictionaryStorage.search(key);
    }

    private DictionaryType dictionaryType;
    private final ValidInterface validInterface;
    private final DictionaryStorage dictionaryStorage;

    public DictionaryService(String type, int dictionary) throws DictionaryException{
        for (DictionaryType dictionaryType : DictionaryType.values()) {
            if (dictionaryType.getNumber() == dictionary) {
                this.dictionaryType = dictionaryType;
            }
        }
        if(dictionaryType==null){
            throw new DictionaryException("Словарь не найден");
        }
        validInterface = new Validation(dictionaryType.getPatternValue(), dictionaryType.getPatternKey());
        if (type.equals("map")) {
            dictionaryStorage = new MapStorage();
        } else {
            dictionaryStorage = new FileStorage(new FileReader(dictionaryType.getDictionaryPath()));
        }
    }
}