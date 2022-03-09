import java.io.FileNotFoundException;

public class DictionarTest {

    public static void main(String[] args) throws FileNotFoundException {
        Console test = new Console(new WorkWithFile());
        test.write(test.wd);
        test.read();
    }
}



