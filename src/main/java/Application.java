import java.util.List;

public class Application {
    public static void main(String[] args) {
        String path = FileLoader.getFile();
        CheckYourFile checkYourFile = new CheckYourFile();
        if (checkYourFile.checkFile(path)) {
            List<User> users = ListOfUsers.getUsersFromFile(path);
            TheOldestUser.findTheOldestUser(users);
        } else {
            System.out.println("Your file have faults. Chcek Your file!");
        }
    }
}
