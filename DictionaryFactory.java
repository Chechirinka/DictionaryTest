
public class DictionaryFactory {

    public static Dictionary getDictionary(String inargs) {

        if (inargs.equalsIgnoreCase(InputTypes.MAP.name())) {
            return new WorkWithMap();
        } else {
            return new WorkWithFile();
        }
    }
    public static Dictionary createDefault() {

        return new WorkWithFile();
    }
}
