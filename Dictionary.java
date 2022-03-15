import java.util.List;

interface Dictionary {
    List<String> read();
    void add(String key, String value);
    void remove(String key) ;
    String search(String key);
}
