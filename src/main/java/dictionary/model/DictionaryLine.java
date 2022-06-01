package dictionary.model;

public class DictionaryLine {

    public DictionaryLine(String key, String value){
        this.key=key;
        this.value=value;
    }
    private final String key;
    private final String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
