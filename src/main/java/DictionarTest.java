
import configuration.DictionaryFactory;
import service.DictionaryService;
import validator.ValidInterface;
import validator.Validation;
import view.Console;

public class DictionarTest {
    public static void main(String[] args) {
        ValidInterface validInterface = new Validation();
        DictionaryService dictionaryService = new DictionaryService(validInterface, DictionaryFactory.getDictonary(args[0]));
        Console test = new Console(dictionaryService);
        test.choice();
        test.actions();
    }
}
