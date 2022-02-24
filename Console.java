import java.util.Scanner;

public class Console {

    public static Scanner in = new Scanner(System.in);

    public static void actions()  {

        WorkWithFile worker = new WorkWithFile();
        System.out.println("Enter number of function wanted" + "\n1 Adding an entry"
                + "\n2 Record search" + "\n3 Deleting an entry");
        int choice = in.nextInt();
        String wd = in.next();
        switch(choice) {

            case 1:
                System.out.println("Please enter the key");
                worker.add(wd);
                break;

            case 2:
                System.out.println("Please enter the key");
                worker.find(wd);
                break;

            case 3:
                System.out.println("Please enter the key");
                worker.remove(wd);
                break;
        }

    }


}