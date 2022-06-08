package dictionary.view;

import java.util.List;
import java.util.Scanner;

import dictionary.configuration.DictionaryType;
import dictionary.exception.TypeNotFoundException;
import dictionary.service.DictionaryService;


public class Console {
    private final static String SELECT_LANGUAGE = "Select lang: 1 - English; 2 - Digital;";
    private final static String SELECT_ACTIONS = "Enter action: 1-add; 2 - read; 3 - remove; 4 - search; 5-exit";
    private final static String ENTER_KEY = "Enter key";
    private final static String ENTER_VALUE = "Enter value";
    private final static String NO_EXIST_LANGUAGE = "Ошибка, такого языка не существует, повторите ввод!";
    private final static String SUCCESS = "Success";
    private final static String ERROR = "Error";
    public final static String NO_EXIST_KEY = "Ключ не найден";
    private final static String DELETE = "Удалено";
    private final static String NO_DELETE = "Не удалено";
    private final static int ACTION_ADD = 1;
    private final static int ACTION_READ = 2;
    private final static int ACTION_REMOVE = 3;
    private final static int ACTION_SEARCH = 4;
    private final static int EXIT = 5;

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
            in.nextInt();
        }
    }

    public void actions() {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println(SELECT_ACTIONS);
            int inaction = in.nextInt();
            switch (inaction) {
                case ACTION_ADD:
                    System.out.println(ENTER_KEY);
                    String key = in.next();
                    System.out.println(ENTER_VALUE);
                    String value = in.next();
                    System.out.println(addPair(key, value, selectedDictionary));
                    break;
                case ACTION_READ:
                    System.out.println(readPair(selectedDictionary));
                    break;
                case ACTION_REMOVE:
                    System.out.println(ENTER_KEY);
                    key = in.next();
                    System.out.println(removePair(key, selectedDictionary));
                    break;
                case ACTION_SEARCH:
                    System.out.println(ENTER_KEY);
                    key = in.next();
                    System.out.println(searchPair(key, selectedDictionary));
                    break;
                case EXIT:
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
            return dictionaryService.searchService(key, selectedDictionary);
        }

    private String removePair(String key, DictionaryType selectedDictionary) {
        if (dictionaryService.removeService(key, selectedDictionary)) {
            return DELETE;
        }
        return NO_DELETE;
    }
}


