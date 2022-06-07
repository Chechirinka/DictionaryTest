package dictionary.view;

import java.util.List;
import java.util.Scanner;

import dictionary.configuration.DictionaryType;
import dictionary.exeption.TypeNotFoundException;
import dictionary.model.DictionaryLine;
import dictionary.service.DictionaryService;

import static dictionary.storage.MapStorage.NO_KEY;


public class Console {


    private final static String SELECT_LANGUAGE = "Select lang: 1 - English; 2 - Digital;";
    private final static String SELECT_ACTIONS = "Enter action: 1-add; 2 - read; 3 - remove; 4 - search; 5-exit";
    private final static String ENTER_KEY = "Enter key";
    private final static String ENTER_VALUE = "Enter value";
    private final static String NO_EXIST_LANGUAGE = "Ошибка, такого языка не существует";

    private final static String SUCCESS = "Success";

    private final static String ERROR = "Error";

    private final static String NO_EXIST_KEY = "Ключ не найден";

    private final static String DELETE = "Удалено";

    private final static String NO_DELETE = "Не удалено";

    Scanner in = new Scanner(System.in);
    private DictionaryService dictionaryService;
    private DictionaryType selectedDictionary;

    public Console(DictionaryService dictionaryService) {

        this.dictionaryService = dictionaryService;
    }

    public void choice() {
        System.out.println(SELECT_LANGUAGE);

        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(in.nextInt());
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }

    }

    public void actions() {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println(SELECT_ACTIONS);
            int inaction = in.nextInt();
            switch (inaction) {
                case 1:
                    System.out.println(ENTER_KEY);
                    String key = in.next();
                    System.out.println(ENTER_VALUE);
                    String value = in.next();
                    System.out.println(addPair(key, value, selectedDictionary));
                    break;
                case 2:
                    System.out.println(readPair(selectedDictionary));
                    break;
                case 3:
                    System.out.println(ENTER_KEY);
                    key = in.next();
                    System.out.println(removePair(key, selectedDictionary));
                    break;
                case 4:
                    System.out.println(ENTER_KEY);
                    key = in.next();
                        System.out.println(searchPair(key, selectedDictionary));
                    break;
                case 5:
                    isMenuActive = false;
            }
        }
    }

    private String addPair(String key, String value, DictionaryType selectedDictionary) {
        if (dictionaryService.addService(key, value, selectedDictionary)) {
            return SUCCESS;
        }
        return ERROR;
    }

    private List<String> readPair(DictionaryType selectedDictionary) {
        return dictionaryService.readService(selectedDictionary);
    }

    private String searchPair(String key, DictionaryType selectedDictionary){
        if (dictionaryService.searchService(key, selectedDictionary) != null){
            return dictionaryService.searchService(key, selectedDictionary);
        }
        return NO_EXIST_KEY;
    }

    private String removePair(String key, DictionaryType selectedDictionary) {
        if (dictionaryService.removeService(key, selectedDictionary)) {
            return DELETE;
        }
        return NO_DELETE;
    }
}


