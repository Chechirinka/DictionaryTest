package validator;

import configuration.DictionaryType;

public interface ValidInterface {
    boolean isValidPair(String key, String value, DictionaryType dictionaryType);
}
