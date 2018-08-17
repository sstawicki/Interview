import javafx.scene.input.DataFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ListOfUsers {
    private static final String DEFAULT_NUMBER = "0";
    public static List<User> getUserFromFile(String pathFile) {
        List<User> users = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String date[] = line.split(",");
                if (date.length == 3) {
                    users.add(new User(date[0], date[1], LocalDate.parse(date[2],formatter), DEFAULT_NUMBER));
                } else {
                    users.add(new User(date[0], date[1], LocalDate.parse(date[2],formatter), date[3]));
                }
            }
            System.out.println(usersSize(users));
            reader.close();
        } catch (IOException e) {
            System.out.println("File read error: " + e);
        }
        return users;
    }

    public static String usersSize(List<User> users){
        if (users.size() == 1) {
            return "In the file is one user";
        } else {
            return "Number of users in the file: " + users.size();
        }
    }
}
