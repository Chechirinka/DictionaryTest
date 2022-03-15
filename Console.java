import java.util.Scanner;

public class Console {

    Scanner in = new Scanner(System.in);
    DictionaryFactory factory = new DictionaryFactory();

    public void actions(String inargs){

        switch (inargs) {
            case "map":
                    System.out.println("map");
                    Dictionary map = factory.getDictionary(InputTypes.MAP);
                while(true) {
                    System.out.println("Введите действие: 1-add; 2 - read; 3 - remove; 4 - search");
                    int inaction = in.nextInt();
                    switch (inaction) {
                        case 1:
                            System.out.println("Введите ключ");
                            String key = in.next();
                            System.out.println("Введите значение");
                            String value = in.next();
                            map.add(key, value);
                            break;
                        case 2:
                            for (String mapa : map.read()) {
                                System.out.println(mapa);
                            }
                            break;
                        case 3:
                            System.out.println("Введите ключ");
                            key = in.next();
                            map.remove(key);
                            break;
                        case 4:
                            System.out.println("Введите ключ");
                            key = in.next();
                            map.search(key);
                            break;
                    }
                }
            case "file":
                System.out.println("file");
                Dictionary file = factory.getDictionary(InputTypes.FILE);
                    while(true) {
                        System.out.println("Введите действие: 1-add; 2 - read; 3 - remove; 4 - search");
                        int inactionf = in.nextInt();
                        switch (inactionf) {
                            case 1:
                                System.out.println("Введите ключ");
                                String key = in.next();
                                System.out.println("Введите значение");
                                String value = in.next();
                                file.add(key, value);
                                break;
                            case 2:
                                System.out.println(file.read());
                                break;
                            case 3:
                                System.out.println("Введите ключ");
                                key = in.next();
                                file.remove(key);
                                break;
                            case 4:
                                System.out.println("Введите ключ");
                                key = in.next();
                                System.out.println(file.search(key));
                                break;
                        }
                    }
            default:
                throw new IllegalStateException("Unexpected value: " + inargs);
        }
    }
}
