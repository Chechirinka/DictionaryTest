package storage;

import configuration.DictionaryType;

import java.util.*;

public class MapStorage implements DictionaryStorage {

    public static final String NO_KEY = "No key found!";
    public static final String KEY_DOES_NOT_EXIST = "This key does not exist!";

    public static Map<String, String> map = new HashMap<>();

    @Override
    public String getSymbol() {
        return ":";
    }

    @Override
    public List<String> read(DictionaryType selectedDictionary) {
        List<String> mapRead = new ArrayList<>();
        for (String mapper : map.keySet()) {
            mapRead.add(mapper + " " + map.get(mapper));
        }
        return mapRead;
    }

    @Override
    public String add(String key, String value, DictionaryType selectedDictionary) {
        return map.put(key, value);
    }

    @Override
    public void remove(String key, DictionaryType selectedDictionary) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            try {
                throw new Exception(NO_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String search(String key, DictionaryType selectedDictionary) {
        String search = map.get(key);
        if (search != null) {
            String searchResult = key + getSymbol() + search;
            return searchResult;
        } else {
            return KEY_DOES_NOT_EXIST;
        }
    }

}




