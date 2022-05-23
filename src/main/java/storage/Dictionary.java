package storage;

import configuration.DictionaryType;

import java.util.List;

<<<<<<< Updated upstream:src/main/java/controller/Dictionary.java
public interface Dictionary {
    List<String> read();
    String add(String key, String value);
    void remove(String key) ;
    String search(String key);
    void setDictionaryType(DictionaryType dictionaryType);

=======
    private DictionaryType dictionaryType;
    private final ValidInterface validInterface;
    private final storage.DictionaryStorage dictionaryStorage;

    public Dictionary(String type, int dictionary) throws DictionaryException{
        for (DictionaryType dictionaryType : DictionaryType.values()) {
            if (dictionaryType.getNumber() == dictionary) {
                this.dictionaryType = dictionaryType;
            }
        }
        if(dictionaryType==null){
            throw new DictionaryException("Словарь не найден");
        }
        validInterface = new Validation(dictionaryType.getPatternValue(), dictionaryType.getPatternKey());
        if (type.equals("map")) {
            dictionaryStorage = new storage.MapStorage();
        } else {
            dictionaryStorage = new storage.FileStorage(new storage.FileReader(dictionaryType.getDictionaryPath()));
        }
    }

    public ValidInterface getValidInterface() {
        return validInterface;
    }

    public storage.DictionaryStorage getDictionaryStorage() {
        return dictionaryStorage;
    }
>>>>>>> Stashed changes:src/main/java/storage/Dictionary.java
}
