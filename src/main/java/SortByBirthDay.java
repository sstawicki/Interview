import java.util.Comparator;

public class SortByBirthDay implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
