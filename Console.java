import java.util.Scanner;

public class Console {

    public static Scanner in = new Scanner(System.in);
    String wd = in.next();

    Dictionary dictionaryConsole;
    public Console (Dictionary dc){
        dictionaryConsole = dc;
    }
    public void read() {
       dictionaryConsole.read();
    }
        public void write(String wd){
        dictionaryConsole.write(wd);
    }
}
