package configuration;

import controller.Dictionary;
import controller.WorkWithFile;
import controller.WorkWithMap;

public class DictionaryFactory {

    public static Dictionary getDictionary(String inargs) {

        if (inargs.equalsIgnoreCase(InputTypes.MAP.name())) {
            return new WorkWithMap();
        } else {
            return new WorkWithFile();
        }
    }
}
