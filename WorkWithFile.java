import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkWithFile implements Dictionary {

    public static File file = new File(StorageDictionary.LIBRARY);
    @Override
    public void read() {
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

    @Override
    public void write(String wd) {
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file, true));
            bf.write(wd);
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (Exception e){
            }
        }
    }
}

