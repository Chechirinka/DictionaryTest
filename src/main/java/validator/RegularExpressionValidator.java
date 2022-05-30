package validator;

import configuration.DictionaryType;

import java.util.regex.Pattern;

/**
 * Класс ответственен за проверку вводимых данных пользователем
 */

public class RegularExpressionValidator implements Validator {

    /**
     * Метод проверяет совпадение введенного ключа с регулярным выражением
     * @param key
     * @param keyPattern
     * @return boolean соответствует ли ключ регулярному выражению
     */
    private boolean isValidKey(String key,  String keyPattern) {
        return Pattern.matches(keyPattern, key);
    }

    /**
     * Метод проверяет совпадение введенного значения с регулярным выражением
     * @param value
     * @param valuePattern
     * @return boolean соответствует ли значение регулярному выражению
     */
    private boolean isValidValue(String value, String valuePattern) {
        return Pattern.matches(valuePattern, value);
    }

    /**
     * Метод проверяет совпадени пары <ключ, значение> выбранному языку
     * @param key
     * @param value
     * @param dictionaryType
     * @return boolean соответствует ли введенная пара <ключ,значение> выбранному языку
     */
    @Override
    public boolean isValidPair(String key, String value, DictionaryType dictionaryType) {
        return isValidKey(key, dictionaryType.getPatternKey()) && isValidValue(value, dictionaryType.getPatternValue());
    }
}
