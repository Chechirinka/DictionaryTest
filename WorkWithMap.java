import java.util.*;

public class WorkWithMap implements Dictionary{
    public static Map<String, String> map = new HashMap<>();
    @Override
    public List<String> read() {
        List<String> mapRead = new ArrayList<>();
        for(String mapper: map.keySet()) {
            mapRead.add(mapper+":"+ map.get(mapper));
            System.out.println(mapRead);
                    }
        return mapRead;
    }
    @Override
    public void write(String wd) {
        String[] line = wd.split(":");
        map.put(line[0], line[1]);

    }
}