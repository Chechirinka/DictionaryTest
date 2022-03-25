
public enum DictionaryType {
    DICTIONARY_ONE(1, "^[a-zA-Z]{4}$", "[a-zA-Z]+", "E:/DictionaryE.txt", "англо - англо"),
    DICTIONARY_TWO(2, "^[0-9]{5}$", "[a-zA-Z]+", "E:/DictionaryD.txt", "циферко - англо");

    private static final String splitChar = ":";
    private final Integer number;
    private final String patternKey;
    private final String patternValue;
    private final String dictionaryPath;
    private final String dictionaryName;

    DictionaryType(Integer number, String patternKey, String patternValue, String dictionaryPath, String dictionaryName) {
        this.number = number;
        this.patternKey = patternKey;
        this.patternValue = patternValue;
        this.dictionaryPath = dictionaryPath;
        this.dictionaryName = dictionaryName;
    }

    public static String getSymbol() {
        return splitChar;
    }

    public Integer getNumber() {
        return number;
    }

    public String getPatternKey() {
        return patternKey;
    }

    public String getPatternValue() {
        return patternValue;
    }

    public String dictionaryName() {
        return dictionaryName;
    }

    public String getDictionaryPath() {
        return dictionaryPath;
    }
}
