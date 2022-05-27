package dictionarySpring.validator;

import dictionarySpring.configuration.DictionaryType;

public interface ValidInterface {
    boolean isValidPair(String key, String value, DictionaryType dictionaryType);
}
