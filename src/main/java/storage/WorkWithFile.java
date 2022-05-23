package storage;
import configuration.DictionaryType;
import service.FileService;
import validator.ValidInterface;
import validator.Validation;

import java.util.List;

public class WorkWithFile implements Dictionary {

    private static final String ADD_KEY = "added";
    private static final String SIMILARITY_TO_THE_PATTERN = "erorr";

    FileService fileService;
    private ValidInterface validInterface;


    public List<String> read() {
        return fileService.read();
    }

    @Override
    public String add(String key, String value) {
        if (validInterface.isValidPair(key, value)) {
            return fileService.write(key, value);
        }
        else {
                return SIMILARITY_TO_THE_PATTERN;
            }
    }

    @Override
    public void remove(String key) {

        List<String> readLines = fileService.read();
        for (int i = 0; i < readLines.size(); i++) {
            if (key.equals(readLines.get(i).split(DictionaryType.getSymbol())[0])) {
                readLines.remove(i);
                break;
            }
        }
        fileService.fileClear();
        for (String readLine : readLines) {
            String[] keyAndValue = readLine.split(DictionaryType.getSymbol());
            fileService.write(keyAndValue[0], keyAndValue[1]);
        }
    }

    public String search(String key) {
        List<String> searchLines = fileService.read();
        for (int i = 0; i < searchLines.size(); i++) {
            if (key.equals(searchLines.get(i).split(DictionaryType.getSymbol())[0])) {
                return searchLines.get(i);
            }
        }
        return null;
    }

    @Override
    public void setDictionaryType(DictionaryType dictionaryType) {
        fileService = new FileService(dictionaryType.getDictionaryPath());
        validInterface = new Validation(dictionaryType.getPatternValue(), dictionaryType.getPatternKey());
    }
}