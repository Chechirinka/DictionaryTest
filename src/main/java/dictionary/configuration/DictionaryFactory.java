package dictionary.configuration;

import dictionary.storage.DictionaryStorage;
import dictionary.storage.FileStorage;
import dictionary.storage.MapStorage;

/**
 * Создаёт стораджи
 */
public class DictionaryFactory {

    public static DictionaryStorage createDictionaryStorage(String arg) {
        if(arg.equals("map")){
            return new MapStorage();
        }else{
            return new FileStorage();
        }
    }

}
