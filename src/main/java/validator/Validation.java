package validator;

import configuration.DictionaryType;

import java.util.regex.Pattern;

public class Validation implements ValidInterface{

    private boolean isValidKey(String key,  String keyPattern) {
        return Pattern.matches(keyPattern, key);
    }

    private boolean isValidValue(String value, String valuePattern) {
        return Pattern.matches(valuePattern, value);
    }

    @Override
    public boolean isValidPair(String key, String value, DictionaryType dictionaryType) {
        return isValidKey(key, dictionaryType.getPatternKey()) && isValidValue(value, dictionaryType.getPatternValue());
    }
}
