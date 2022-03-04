
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkWithMap {
    public static final String ERROR_FIND= "Ничего не найдено";

  
    public static int value = 1;
    private static Scanner input;
   
    public static Map<String, Integer> map = new HashMap<String, Integer>();
    public static void readFile() throws FileNotFoundException {
 

        int value = 1;

        while (input.hasNext()) {
            String word = input.next().toLowerCase();
            String[] line = word.split("[,\\s]+");
            for (int j = 0; j < line.length; j++) {
                map.put(line[j], value);
                value++;
            }
        }

    }

    public static void add(String wd) {

        String word = wd.toLowerCase();
        String[] line = word.split("[,\\s]+");
        for (int j = 0; j < line.length; j++) {
            if (!map.containsKey(line[j])) {
                map.put(line[j], value);
                value++;
            }
        }
    }


    public static String find(String wd) {
        String resultFind = "";//результат функции по поиску ключа

        String keyFind = wd.toLowerCase();
        for (Map.Entry<String, Integer> key : map.entrySet()) {
            if (key.getKey().startsWith(keyFind)) {
                resultFind = key.getKey();//если ключ найден мы присвоиваем результату этот ключ
            } else {
                resultFind = ERROR_FIND;//если он не найден присваиваем результату ошибку
            }
        }
        return resultFind;
    }



    public static void remove(String wd) {
        boolean done = false;
        String word = wd.toLowerCase();
        String[] line = word.split("[,\\s]+");
        for (int j = 0; j < line.length; j++) {
            for (Map.Entry<String, Integer> key : map.entrySet()) {
                if (key.getKey().equals(line[j])) {
                    map.remove(key.getKey(), key.getValue());
                   
                }
            }

        }

    }
}
