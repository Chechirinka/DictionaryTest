package dictionary.service;

import dictionary.model.DictionaryLine;


public class DictionaryLineCodec {

    public static DictionaryLine encode(String line){
        String[] words = line.split(DictionaryLine.getSplitChar());
        return new DictionaryLine(words[0], words[1]);

    }
}
