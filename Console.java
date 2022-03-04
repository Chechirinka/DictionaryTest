import java.util.Scanner;

public class Console {

    public static Scanner in = new Scanner(System.in);

    public static void actions()  {

        WorkWithMap worker = new WorkWithMap();
        System.out.println("Enter number of function wanted" + "\n1 Adding an entry"
                + "\n2 Record search" + "\n3 Deleting an entry");

        int choice = in.nextInt();
        System.out.println("Please enter the key");
        String wd = in.next();

        switch(choice) {

            case 1:
                worker.add(wd);
                System.out.println("The key has been successfully added!");
                break;

            case 2:

                System.out.println( worker.find(wd));
                break;

            case 3:

                worker.remove(wd);
                System.out.println("The line has been successfully deleted!");

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

    }
}