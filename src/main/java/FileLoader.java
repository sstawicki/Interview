import java.util.Scanner;

public class FileLoader {

    public static String getFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write the path to the fle txt:");
        String path = scanner.nextLine();
        while (path.equals("") || !path.contains(".txt")) {
            System.out.println("Your path is wrong!"+ "\nPlease write correct the path to the fle:");
            path = scanner.nextLine();
        }
        scanner.close();
        return path;
    }
}
