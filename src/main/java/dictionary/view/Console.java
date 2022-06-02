package dictionary.view;

import java.util.List;
import java.util.Scanner;

import dictionary.exeption.SearchException;
import dictionary.configuration.DictionaryType;
import dictionary.exeption.TypeNotFoundException;
import dictionary.model.DictionaryLine;
import dictionary.service.DictionaryLineCodec;
import dictionary.service.DictionaryService;

import static dictionary.storage.MapStorage.NO_KEY;


public class Console {


    private DictionaryService dictionaryService;
    private DictionaryType selectedDictionary;
    private final static String SELECT_LANGUAGE = "Select lang: 1 - English; 2 - Digital;";
    private final static String SELECT_ACTIONS = "Enter action: 1-add; 2 - read; 3 - remove; 4 - search; 5-exit";
    private final static String ENTER_KEY = "Enter key";
    private final static String ENTER_VALUE = "Enter value";
    private final static String NO_EXIST_LANGUAGE = "Ошибка, такого языка не существует";
    private final DictionaryLineCodec dictionaryLineCodec = new DictionaryLineCodec();

    public void choice() {
        System.out.println(SELECT_LANGUAGE);

        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(in.nextInt());
        } catch(TypeNotFoundException e){
            System.out.println(NO_EXIST_LANGUAGE);
        }

    }

    public Console(DictionaryService dictionaryService) {

        this.dictionaryService = dictionaryService;
    }

    Scanner in = new Scanner(System.in);

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
                    try {
                        System.out.println(searchPair(key, selectedDictionary));
                    } catch (SearchException e) {
                        System.out.println(NO_KEY);
                    }
                    break;
                case 5:
                    isMenuActive = false;
            }
        }
    }

    private String addPair(String key, String value, DictionaryType selectedDictionary){
        if (dictionaryService.addService(key, value, selectedDictionary)){
            return "Success";
        }
        return "Error";
    }

    private List<String> readPair(DictionaryType selectedDictionary){
       return dictionaryService.readService(selectedDictionary);
    }

    private DictionaryLine searchPair(String key, DictionaryType selectedDictionary) throws SearchException {
        return dictionaryService.searchService(key, selectedDictionary);
    }

    private String removePair(String key, DictionaryType selectedDictionary) {
      if(dictionaryService.removeService(key, selectedDictionary)){
          return "Удалено";
      }
      return "Не удалено";
    }
}


