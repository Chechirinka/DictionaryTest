package configuration;

import storage.DictionaryStorage;
import storage.FileStorage;
import storage.MapStorage;

public class DictionaryFactory {
    public static DictionaryStorage getDictonary(String arg) {
        if(arg.equals("map")){
            return new MapStorage();
        }else{
            return new FileStorage();
        }
    }

}
