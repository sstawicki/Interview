import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CheckYourFileTestSuite {

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
    public void wrongFirstName() {
        //Given
        List<String> list = new ArrayList<>();
        list.add("w1,Kowalski,1998-02-12,876453211");
        list.add("Jan,Maci,1928-02-12,900500600");
        //When
        boolean result = CheckYourFile.checkFirstName(list);
        //Then
        Assert.assertEquals(false, result);
    }

    @Test
    public void wrongLastName() {
        //Given
        List<String> list = new ArrayList<>();
        list.add("Jan,Kowalski,1998-02-12,876453211");
        list.add("Anna,2,2000-04-12,567890234");
        //When
        boolean result = CheckYourFile.checkLastName(list);
        //Then
        Assert.assertEquals(false, result);
    }

    @Test
    public void wrongBirthDay() {
        //Given
        List<String> list = new ArrayList<>();
        list.add("Jan,Kowalski,w-02-12,876453211");
        list.add("Jan,Maci,1928-02-12,900500600");
        //When
        boolean result = CheckYourFile.checkDateOfBrth(list);
        //Then
        Assert.assertEquals(false, result);
    }

    @Test
    public void wrongPhone() {
        //Given
        List<String> list = new ArrayList<>();
        list.add("Adrian,Kowalski,1998-02-12,aaa");
        list.add("Jan,Maci,1928-02-12,900500600");
        //When
        boolean result = CheckYourFile.checkPhoneNumber(list);
        //Then
        Assert.assertEquals(false, result);
    }

    @Test
    public void toManyData() {
        //Given
        List<String> list = new ArrayList<>();
        list.add("Adrian,Kowalski,1998-02-12,888433211,200");
        list.add("Jan,Maci,1928-02-12,900500600");
        //When
        boolean result = CheckYourFile.howManyData(list);
        //Then
        Assert.assertEquals(false, result);
    }

    @Test
    public void correctData() {
        //Given
        ClassLoader classLoader = getClass().getClassLoader();
        String file = (classLoader.getResource("users.txt").getPath());
        //When
        boolean result = CheckYourFile.checkAll(file);
        //Then
        Assert.assertEquals(true, result);
    }
}