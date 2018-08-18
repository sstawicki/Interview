import org.junit.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TheOldestUserTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("You have: " + testCounter + " tests. All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
    }

    @Test
    public void findTheOldestUserWhereUsersWithoutPhone() {
        //Given
        List<User> users = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        users.add(new User("Jan", "Nowak", LocalDate.parse("1955-02-12",formatter), "0"));
        users.add(new User("Anna", "Kowalska", LocalDate.parse("1999-07-22",formatter), "0"));
        //When
        int age = TheOldestUser.findTheOldestUser(users);
        //Then
        Assert.assertEquals(63, age);
    }

    @Test
    public void findTheOldestUser() {
        //Given
        List<User> users = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        users.add(new User("Jan", "Nowak", LocalDate.parse("1955-02-12",formatter), "0"));
        users.add(new User("Anna", "Kowalska", LocalDate.parse("1999-07-22",formatter), "512314200"));
        //When
        int age = TheOldestUser.findTheOldestUser(users);
        //Then
        Assert.assertEquals(19, age);
    }
}