import java.util.Scanner;

public class Console {

    public static Scanner in = new Scanner(System.in);


    Dictionary dictionaryConsoleFile;
    Dictionary dictionaryConsoleMap;

    public Console(Dictionary dcf, Dictionary dcm) {
        dictionaryConsoleFile = dcf;
        dictionaryConsoleMap = dcm;
    }
    int choice = in.nextInt();
    public void actions() {
        switch (choice) {
            case 1:
                String wd = in.next();
        dictionaryConsoleFile.write(wd);
        break;
            case 2:
                String wd1 = in.next();
        dictionaryConsoleMap.write(wd1);
        break;
    }
    }
}

