package dictionary.validator;

import dictionary.configuration.DictionaryType;

public interface Validator {
    boolean isValidPair(String key, String value, DictionaryType dictionaryType);
}
