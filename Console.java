
import java.util.Scanner;


public class Console {

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
                    choice.add(key, value);
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


