import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheOldestUser {

    public static void findTheOldestUser(List<User> users) {
        List<User> usersWithNumber = new ArrayList<>();
        for (User user : users) {
            if (user.getPhoneNumber().equals("0")) {
                continue;
            } else {
                usersWithNumber.add(user);
            }
        }
        Collections.sort(usersWithNumber, new SortByBirthDay());
        User theOldestUser = usersWithNumber.get(0);
        int age = Period.between(theOldestUser.getDateOfBirth(), LocalDate.now()).getYears();
        System.out.println("The oldest user is: " + theOldestUser.toString() + " age: " + age);
    }
}
