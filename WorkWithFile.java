import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkWithFile {

    public static File file = new File(StorageDictionary.LIBRARY);
    public static int value = 1;

    public static Map<String, Integer> map = new HashMap<String, Integer>();
    public static void readFile()  {
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
        ) {
            while (br.ready()) {
                String line = br.readLine();
                if (line != null) {
                    System.out.println(line);

                    ArrayList<String> result = new ArrayList<>();
                    result.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}