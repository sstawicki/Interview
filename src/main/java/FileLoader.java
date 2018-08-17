import java.util.Scanner;

public class FileLoader {

    public static String getFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write the path to the fle:");
        String path = scanner.nextLine();
        while (path.equals("")) {
            System.out.println("Path must be not null!"+ "\nPlease write correct the path to the fle:");
            path = scanner.nextLine();
        }
        scanner.close();
        return path;
    }
}
