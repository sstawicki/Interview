import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheOldestUser {

    public static int findTheOldestUser(List<User> users) {
        List<User> usersWithNumber = new ArrayList<>();
        for (User user : users) {
            if (user.getPhoneNumber().equals("0")) {
                continue;
            } else {
                usersWithNumber.add(user);
            }
        }
        if (usersWithNumber.size() == 0) {
            Collections.sort(users, new SortByBirthDay());
            User theOldestUserWithoutPhone = users.get(0);
            int age = Period.between(theOldestUserWithoutPhone.getDateOfBirth(), LocalDate.now()).getYears();
            System.out.println("You don`t have users with phone number. The oldest user without phone number is: " + theOldestUserWithoutPhone.toString() + " age: " + age);
            return age;
        } else {
            Collections.sort(usersWithNumber, new SortByBirthDay());
            User theOldestUser = usersWithNumber.get(0);
            int age = Period.between(theOldestUser.getDateOfBirth(), LocalDate.now()).getYears();
            System.out.println("The oldest user is: " + theOldestUser.toString() + " age: " + age);
            return age;
        }
    }
}
