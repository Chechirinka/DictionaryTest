package dictionary.service;

import dictionary.model.DictionaryLine;

/**
 * Класс отвечает за работу над строкой с помощью разделителя
 */
public class DictionaryLineCodec {

    private static final String splitChar = ":";

    public static String getSplitChar() {
        return splitChar;
    }

    /**
     * Метод разбивает заданную строку на совпадения с заданным регулярным выражением
     * @param line полученная строка из FileStorage
     * @return объект DictionaryLine
     */
    public static DictionaryLine encode(String line){
        String[] words = line.split(getSplitChar());
        return new DictionaryLine(words[0], words[1]);
    }

    public static String decode(DictionaryLine dictionaryLine){
        return dictionaryLine.toString();
    }
}
