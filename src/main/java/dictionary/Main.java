package dictionary;

import dictionary.configuration.DictionaryFactory;
import dictionary.service.DictionaryService;
import dictionary.validator.Validator;
import dictionary.validator.RegularExpressionValidator;
import dictionary.view.Console;

public class Main {
    public static void main(String[] args) {
        Validator validator = new RegularExpressionValidator();
        DictionaryService dictionaryService = new DictionaryService(validator, DictionaryFactory.createDictionaryStorage(args[0]));
        Console test = new Console(dictionaryService);
        test.choice();
        test.actions();
    }
}
