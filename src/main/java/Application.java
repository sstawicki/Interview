import java.util.List;

public class Application {
    public static void main(String[] args) {
        String path = FileLoader.getFile();
        List<User> users = ListOfUsers.getUserFromFile(path);
        TheOldestUser.findTheOldestUser(users);
    }
}