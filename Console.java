import java.util.Scanner;

public class Console {

    Scanner in = new Scanner(System.in);
    DictionaryFactory factory = new DictionaryFactory();
    Dictionary dictionaryConsoleFile;

    public void actions(String inargs){
        switch (inargs) {
            case "map":
                System.out.println("map");
                Dictionary map = factory.getDictionary(InputTypes.MAP);
                System.out.println("Введите действие: 1-write; 2 - read");
                int inactionm = in.nextInt();
                switch (inactionm){
                    case 1:
                        System.out.println("Введите значение : ключ");
                        String wd = in.next();
                        map.write(wd);
                        break;
                    case 2:
                        for(String mapa: map.read()) {
                            System.out.println(mapa);
                        }
                    break;
                }
                break;
            case "file":
                System.out.println("file");
                Dictionary file = factory.getDictionary(InputTypes.FILE);
                System.out.println("Введите действие: 1-write; 2 - read");
                int inactionf = in.nextInt();
                switch (inactionf){
                    case 1:
                        System.out.println("Введите значение : ключ");
                        String wd = in.next();
                        file.write(wd);
                        break;
                    case 2:
                        file.read();
                        break;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + inargs);
        }
    }
}
