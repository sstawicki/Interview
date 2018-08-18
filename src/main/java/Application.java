import java.util.List;

public class Application {
    public static void main(String[] args) {
        String path = FileLoader.getFile();
        if (CheckYourFile.checkAll(path)) {
            List<User> users = ListOfUsers.getUsersFromFile(path);
            TheOldestUser.findTheOldestUser(users);
        } else {
            System.out.println("Your file have faults. Chcek Your file!");
        }
    }
}
