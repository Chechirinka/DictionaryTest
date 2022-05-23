package view;

import java.util.Scanner;

import service.DictionaryException;
import service.DictionaryService;
import storage.Dictionary;

public class Console {

DictionaryService dictionaryService = new DictionaryService();

private Dictionary dictionary;
    public void choice(String selection){
        System.out.println("Select lang: 1 - English; 2 - Digital;");
        try{
            dictionary = new Dictionary(selection, in.nextInt());
        }
            catch(DictionaryException dictionaryException) {
                System.err.println(dictionaryException.getMessage());
            }
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
                    System.out.println(dictionaryService.addService(key, value, dictionary));
                    break;
                case 2:
                    System.out.println(dictionaryService.readService(dictionary));
                    break;
                case 3:
                    System.out.println("Enter key");
                    key = in.next();
                    dictionaryService.removeService(key, dictionary);
                    break;
                case 4:
                    System.out.println("Enter key");
                    key = in.next();
                    System.out.println(dictionaryService.searchService(key, dictionary));
                    break;
                case 5:
                    a = false;
            }
        }
    }
}



