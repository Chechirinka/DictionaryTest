package configuration;

import storage.DictionaryStorage;
import storage.FileStorage;
import storage.MapStorage;

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
