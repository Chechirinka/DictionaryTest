import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class WorkWithFile implements Dictionary {

    public static File file = new File("E:\\Library.txt");


    public List<String> read() {
        String line = null;
        List<String> result = new ArrayList<>();
        try (
                FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(fr)
        ) {
            while (br.ready()) {
                line = br.readLine();
                if (line != null) {
                    result.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void add(String key, String value) {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file,StandardCharsets.UTF_8 ,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + key + ":" + value);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void remove(String key) {

        List<String> readLines = read();
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < readLines.size(); i++) {
                if (!key.equals(readLines.get(i).split(":")[0])) {
                    bufferedWriter.write(readLines.get(i) + "\n");
                }
            }
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (Exception e) {
            }
        }
    }

    public String search(String key) {
        List<String> searchLines = read();
            for (int i = 0; i < searchLines.size(); i++) {
                if (key.equals(searchLines.get(i).split(":")[0])) {
                    return searchLines.get(i);
                }
            }
        return null;
    }
}
