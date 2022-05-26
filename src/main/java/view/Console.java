package view;

import java.util.Scanner;

import configuration.DictionaryType;
import service.DictionaryException;
import service.DictionaryService;
import storage.DictionaryStorage;
import validator.ValidInterface;
import validator.Validation;

public class Console {


    private DictionaryService dictionaryService;
    private DictionaryStorage dictionaryStorage;
    DictionaryType selectedDictonary;

    public void choice() {
        System.out.println("Select lang: 1 - English; 2 - Digital;");

        try {
            selectedDictonary = DictionaryType.getDictionaryTypeByNumber(in.nextInt());
        } catch(DictionaryException e){
            System.out.println("Ошибка, такого языка не существует");
        }

    }
    public Console(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    Scanner in = new Scanner(System.in);

    public void actions() {
        boolean a = true;
        while (a) {
            System.out.println("Enter action: 1-add; 2 - read; 3 - remove; 4 - search; 5-exit");
            int inaction = in.nextInt();
            switch (inaction) {
                case 1:
                    System.out.println("Enter key");
                    String key = in.next();
                    System.out.println("Enter value");
                    String value = in.next();
                    System.out.println(dictionaryService.addService(key, value, selectedDictonary));
                    break;
                case 2:
                    System.out.println(dictionaryService.readService(selectedDictonary));
                    break;
                case 3:
                    System.out.println("Enter key");
                    key = in.next();
                    dictionaryService.removeService(key, selectedDictonary);
                    break;
                case 4:
                    System.out.println("Enter key");
                    key = in.next();
                    System.out.println(dictionaryService.searchService(key, selectedDictonary));
                    break;
                case 5:
                    a = false;
            }
        }
    }
}


