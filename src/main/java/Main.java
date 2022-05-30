
import configuration.DictionaryFactory;
import service.DictionaryService;
import validator.Validator;
import validator.RegularExpressionValidator;
import view.Console;

public class Main {
    public static void main(String[] args) {
        Validator validator = new RegularExpressionValidator();
        DictionaryService dictionaryService = new DictionaryService(validator, DictionaryFactory.createDictionaryStorage(args[0]));
        Console test = new Console(dictionaryService);
        test.choice();
        test.actions();
    }
}
