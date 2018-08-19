import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CheckYourFile {
    private CheckFirstName checkFirstName = new CheckFirstName();
    private CheckLastName checkLastName = new CheckLastName();
    private CheckDateOfBirth checkDateOfBirth = new CheckDateOfBirth();
    private CheckPhoneNumber checkPhoneNumber = new CheckPhoneNumber();

    public boolean checkFile(String pathFile) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            list = reader.lines().collect(Collectors.toList());
            reader.close();
        } catch (IOException e) {
            System.out.println("File read error: " + e);
        }
        if(checkFirstName.checkFirstName(list) && checkLastName.checkLastName(list)
                && checkDateOfBirth.checkDateOfBrth(list) && checkPhoneNumber.checkPhoneNumber(list)
                && howManyData(list)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean howManyData(List<String> list) {
        boolean result = false;
        for (String line : list) {
            String date[] = line.split(",");
            if (line.isEmpty() || date.length > 4 || date.length < 2) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}
