package dictionary.configuration;

import dictionary.storage.DictionaryStorage;
import dictionary.storage.FileStorage;
import dictionary.storage.MapStorage;

/**
 * Создаёт стораджи
 */
public class DictionaryFactory {

    private final static String MAP = "map";

    public static DictionaryStorage createDictionaryStorage(String arg) {
        if (arg.equals(MAP)) {
            return new MapStorage();
        } else {
            return new FileStorage();
        }
    }

}
