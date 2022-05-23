package configuration;

public enum DictionaryType {
    DICTIONARY_ONE(1, "^[a-zA-Z]{4}$", "[a-zA-Z]+", "src/main/resources/DictionaryE.txt", "English"),
    DICTIONARY_TWO(2, "^[0-9]{5}$", "[a-zA-Z]+", "src/main/resources/DictionaryD.txt", "Digital");

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

<<<<<<< Updated upstream
    public Integer getNumber() {
        return number;
    }
=======
    public Integer getNumber() {return number;}
>>>>>>> Stashed changes

    public String getPatternKey() {return patternKey;}

    public String getPatternValue() {return patternValue;}

    public String getDictionaryName() {return dictionaryName;
    }

    public String getDictionaryPath() {
        return dictionaryPath;
    }
    }

