import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WorkWithFile implements Dictionary {

    private static final String ADD_KEY = "added";
    private static final String SIMILARITY_TO_THE_PATTERN = "erorr";

    public static File file = new File("E:\\Library.txt");

    public List<String> read() {
        String line;
        List<String> result = new ArrayList<>();
        try (
                FileReader fr = new FileReader(path, StandardCharsets.UTF_8);
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
    public String add(String key, String value) {
        if (keyCheck(key) && valueCheck(value)) {
            BufferedWriter bufferedWriter = null;
            try {
                FileWriter fileWriter = new FileWriter(path, StandardCharsets.UTF_8, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n" + key + DictionaryType.getSymbol() + value);
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedWriter.close();
                } catch (Exception e) {
                }
            }
            return ADD_KEY;
        } else {
            return SIMILARITY_TO_THE_PATTERN;
        }
    }

    @Override
    public void remove(String key) {

        List<String> readLines = read();
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < readLines.size(); i++) {
                if (!key.equals(readLines.get(i).split(DictionaryType.getSymbol())[0])) {
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
            if (key.equals(searchLines.get(i).split(DictionaryType.getSymbol())[0])) {
                return searchLines.get(i);
            }
        }
        return null;
    }

    DictionaryType dictionaryType;
    private String path;

    @Override
    public void setDictionaryType(DictionaryType dictionaryType) {
        this.dictionaryType = dictionaryType;
        this.path = dictionaryType.getDictionaryPath();
    }

    @Override
    public boolean keyCheck(String key) {
        String patKey = dictionaryType.getPatternKey();
        return Pattern.matches(patKey, key);
    }

    @Override
    public boolean valueCheck(String value) {
        String patValue = dictionaryType.getPatternValue();
        return Pattern.matches(patValue, value);
    }

 }