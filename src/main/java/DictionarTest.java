import configuration.DictionaryFactory;
import view.Console;

public class DictionarTest {
    public static void main(String[] args) {
        Console test = new Console(DictionaryFactory.getDictionary(args[0]));
        test.choice();
        test.actions();

    }
}
