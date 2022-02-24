import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkWithFile {

    public static File file = new File( "E:\\Examples\\Library.txt");
    public static int value = 1;
    private static Scanner input;
    public static Scanner in = new Scanner(System.in);
    public static Map<String, Integer> map = new HashMap<String, Integer>();
    public static void readFile() throws FileNotFoundException {
        input = new Scanner(file);
        boolean done = false;

        int value = 1;

        while (input.hasNext()) {
            String word = input.next().toLowerCase();
            String[] line = word.split("[,\\s]+");
            for (int j = 0; j < line.length; j++) {
                map.put(line[j], value);
                value++;
                done = true;
            }
        }
        if (done == true) {
            System.out.println("Success");
        }
    }
    public static void add(String wd) {
        boolean done = false;
        String word = wd.toLowerCase();
        String[] line = word.split("[,\\s]+");
        for (int j = 0; j < line.length; j++) {
            if (!map.containsKey(line[j])) {
                map.put(line[j], value);
                value++;

                try {
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(map.toString());
                    bw.close();
                    done = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                continue;
            }
        }

        if (done == true) {
            System.out.println("The key has been successfully added!");
        }

    }

    public static void find(String wd) {
        System.out.println("Please enter the key");
        String keyFind = wd.toLowerCase();
        for (Map.Entry<String, Integer> key : map.entrySet()) {
            if (key.getKey().startsWith(keyFind)) {
                System.out.println(key.getKey());
            }
        }

    }

    public static void remove(String wd) {
        boolean done = false;
        String word = wd.toLowerCase();
        String[] line = word.split("[,\\s]+");
        for (int j = 0; j < line.length; j++) {
            for (Map.Entry<String, Integer> key : map.entrySet()) {
                if (key.getKey().equals(line[j])) {
                    map.remove(key.getKey(), key.getValue());
                    try {
                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(map.toString());
                        bw.close();
                        done = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    continue;
                }
            }

        }
        if (done == true) {
            System.out.println("The line has been successfully deleted!");
        }
    }
}
