package dictionary.service;

import dictionary.model.DictionaryLine;

import java.util.ArrayList;
import java.util.List;

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
     *
     * @param line полученная строка из FileStorage
     * @return объект DictionaryLine
     */
    public DictionaryLine encode(String line) {
        String[] words = line.split(getSplitChar());
        return new DictionaryLine(words[0], words[1]);
    }

    /**
     * Метод отвечает за кодирование Листа строк в Лист объектов
     *
     * @param lines список строк
     * @return список строк объектов
     */
    public List<DictionaryLine> encode(List<String> lines) {
        List<DictionaryLine> dictionaryLines = new ArrayList<>();
        for (String line : lines) {
            dictionaryLines.add(encode(line));
        }
        return dictionaryLines;
    }

    public String decode(DictionaryLine dictionaryLine) {
        return dictionaryLine.getKey() + splitChar + dictionaryLine.getValue();
    }

    /**
     * Метод отвечает за декодирования Лист обьектов в Лист строк
     *
     * @param dictionaryLines список объектов строк
     * @return список строк
     */
    public List<String> decode(List<DictionaryLine> dictionaryLines) {
        List<String> lines = new ArrayList<>();
        for (DictionaryLine dictionaryLine : dictionaryLines) {
            lines.add(decode(dictionaryLine));
        }
        return lines;
    }
}
