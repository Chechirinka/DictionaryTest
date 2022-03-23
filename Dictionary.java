import java.util.List;

interface Dictionary {
    List<String> read();
    String add(String key, String value);
    void remove(String key) ;
    String search(String key);
    void setDictionaryType(DictionaryType dictionaryType);
    boolean keyCheck(String key);
    boolean valueCheck(String value);
}
