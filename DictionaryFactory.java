import java.util.Scanner;

public class DictionaryFactory {

    public Dictionary getDictionary (InputTypes type) {
        Dictionary dictionary = null;
        switch (type) {
            case MAP:
                dictionary = new WorkWithMap();
                break;
            case FILE:
                dictionary = new WorkWithFile();
                break;
        }
        return dictionary;
    }
}

