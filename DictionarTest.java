public class DictionarTest {
       public static void main(String[] args) {

        DictionaryFactory factory = new DictionaryFactory();
        for(int i = 0; i<args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);

            switch (args[i]) {
                case "map":
                    System.out.println("map");
                    Dictionary map = factory.getDictionary(InputTypes.MAP);
                    map.read();
                    break;
                case "file":
                    System.out.println("file");
                    Dictionary file = factory.getDictionary(InputTypes.FILE);
                    file.read();
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + args[i]);
            }
        }

    }
}
