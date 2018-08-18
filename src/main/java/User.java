import java.time.LocalDate;

public class User {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;

    public User(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return  firstName + " " + lastName + " " + phoneNumber;
    }
}
