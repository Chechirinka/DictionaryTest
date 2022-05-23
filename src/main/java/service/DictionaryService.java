package service;

import storage.Dictionary;

import java.util.List;

public class DictionaryService {


    public String addService(String key, String value, Dictionary dictionary) {
        if (dictionary.getValidInterface().isValidPair(key, value)) {
            return dictionary.getDictionaryStorage().add(key, value);
        } else {
            return "Error";
        }
    }

    public List<String> readService(Dictionary dictionary) {
        return dictionary.getDictionaryStorage().read();
    }

    public void removeService(String key, Dictionary dictionary) {
        dictionary.getDictionaryStorage().remove(key);
    }

    public String searchService(String key, Dictionary dictionary) {
        return dictionary.getDictionaryStorage().search(key);
    }

}