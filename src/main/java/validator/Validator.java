package validator;

import configuration.DictionaryType;

public interface Validator {
    boolean isValidPair(String key, String value, DictionaryType dictionaryType);
}
