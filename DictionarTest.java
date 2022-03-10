
public class DictionarTest {

    public static void main(String[] args) {
        Console test = new Console(new WorkWithFile(), new WorkWithMap());
        test.actions();
           }
}