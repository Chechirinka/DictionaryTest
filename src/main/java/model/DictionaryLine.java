package model;


public class DictionaryLine {

    public DictionaryLine(String key, String value){
        this.key=key;
        this.value=value;
    }
    private final String key;
    private final String value;
    private static final String splitChar = ":";

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static String getSplitChar() {
        return splitChar;
    }

    @Override
    public String toString(){
        return key+splitChar+value;
    }
}
