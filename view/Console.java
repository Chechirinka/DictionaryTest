package view;

import configuration.DictionaryType;
import controller.Dictionary;




import java.util.Scanner;


public class Console {

    public void choice(){
        System.out.println(DictionaryType.DICTIONARY_ONE.dictionaryName());
        System.out.println(DictionaryType.DICTIONARY_TWO.dictionaryName());
        if (in.nextInt()==1){
            dictionary.setDictionaryType(DictionaryType.DICTIONARY_ONE);
        }
        else {
            dictionary.setDictionaryType(DictionaryType.DICTIONARY_TWO);
        }
    }

    private Dictionary dictionary;

    Scanner in = new Scanner(System.in);

    public Console(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void actions() {
        boolean a = true;
        Dictionary choice = getDictionary();
        while (a) {
            System.out.println("Введите действие: 1-add; 2 - read; 3 - remove; 4 - search; 5-exit");
            int inaction = in.nextInt();
            switch (inaction) {
                case 1:
                    System.out.println("Введите ключ");
                    String key = in.next();
                    System.out.println("Введите значение");
                    String value = in.next();
                    System.out.println(choice.add(key, value));
                    break;
                case 2:
                    System.out.println(choice.read());
                    break;
                case 3:
                    System.out.println("Введите ключ");
                    key = in.next();
                    choice.remove(key);
                    break;
                case 4:
                    System.out.println("Введите ключ");
                    key = in.next();
                    System.out.println(choice.search(key));
                    break;
                case 5:
                    a = false;
            }
        }
    }
    private Dictionary getDictionary(){
        return dictionary;
    }
}



