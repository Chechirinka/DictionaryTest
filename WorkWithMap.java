import java.util.*;

public class WorkWithMap implements Dictionary{

    public static final String NO_KEY = "No key found!";
    public static final String KEY_DOES_NOT_EXIST = "This key does not exist!";

    public static Map<String, String> map = new HashMap<>();
    @Override
    public List<String> read() {
        List<String> mapRead = new ArrayList<>();
        for(String mapper: map.keySet()) {
            mapRead.add(mapper+":"+ map.get(mapper));
        }
        return mapRead;
    }

    @Override
    public void add(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void remove(String key) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            try {
                throw new Exception(NO_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String search(String key) {
        String search = map.get(key);
        if (search != null) {
            String searchResult = key + ":" + search;
            return searchResult;
        } else {
            return KEY_DOES_NOT_EXIST;
            }
        }
    }

