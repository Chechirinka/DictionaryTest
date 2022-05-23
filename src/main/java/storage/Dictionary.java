package storage;

import configuration.DictionaryType;
import service.DictionaryException;
import validator.ValidInterface;
import validator.Validation;

public class Dictionary {

    private DictionaryType dictionaryType;
    private final ValidInterface validInterface;
    private final DictionaryStorage dictionaryStorage;

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
            dictionaryStorage = new MapStorage();
        } else {
            dictionaryStorage = new FileStorage(new FileReader(dictionaryType.getDictionaryPath()));
        }
    }

    public ValidInterface getValidInterface() {
        return validInterface;
    }

    public DictionaryStorage getDictionaryStorage() {
        return dictionaryStorage;
    }
}