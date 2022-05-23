package configuration;

import storage.Dictionary;
import storage.WorkWithFile;
import storage.WorkWithMap;

public class DictionaryFactory {

    public static Dictionary getDictionary(String inargs) {

        if (inargs.equalsIgnoreCase(InputTypes.MAP.name())) {
            return new WorkWithMap();
        } else {
            return new WorkWithFile();
        }
    }
}
