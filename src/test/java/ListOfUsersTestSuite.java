import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListOfUsersTestSuite {
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
    public void getUsersFromEmptyFile() {
        //Given
        ClassLoader classLoader = getClass().getClassLoader();
        String file = (classLoader.getResource("userEmpty.txt").getPath());
        //When
        List<User> users = ListOfUsers.getUsersFromFile(file);
        //Then
        Assert.assertEquals(0, users.size());
    }

    @Test
    public void getUsersFromFile() {
        //Given
        ClassLoader classLoader = getClass().getClassLoader();
        String file = (classLoader.getResource("users.txt").getPath());
        //When
        List<User> users = ListOfUsers.getUsersFromFile(file);
        //Then
        Assert.assertEquals(3, users.size());
    }

    @Test
    public void usersSizeWithOneUser() {
        //Given
        List<User> users = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        users.add(new User("Jan", "Nowak", LocalDate.parse("1955-02-12",formatter), "617800900"));
        //When
        String result = ListOfUsers.usersSize(users);
        //Then
        Assert.assertEquals("In the file is one user", result);
    }

    @Test
    public void usersSizeWithManyUsers() {
        //Given
        List<User> users = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        users.add(new User("Jan", "Nowak", LocalDate.parse("1955-02-12",formatter), "617800900"));
        users.add(new User("Anna", "Kowalska", LocalDate.parse("1999-07-22",formatter), "0"));
        //When
        String result = ListOfUsers.usersSize(users);
        //Then
        Assert.assertEquals("Number of users in the file: 2", result);
    }

    @Test
    public void usersWithoutPhoneOnTheFile() {
        //Given
        ClassLoader classLoader = getClass().getClassLoader();
        String file = (classLoader.getResource("usersNoPhone").getPath());
        //When
        List<User> users = ListOfUsers.getUsersFromFile(file);
        //Then
        Assert.assertEquals("0", users.get(0).getPhoneNumber());

    }
}