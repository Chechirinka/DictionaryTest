package dictionarySpring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class DictionaryLine {

    private final String key;
    private final String value;

    public DictionaryLine(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
