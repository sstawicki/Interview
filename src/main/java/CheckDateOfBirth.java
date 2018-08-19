import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckDateOfBirth {

    public boolean checkDateOfBrth(List<String> list) {
        boolean result = false;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        for (String line : list) {
            String date[] = line.split(",");
            try {
                LocalDate dateBirth = LocalDate.parse(date[2], formatter);
                if (dateBirth.isBefore(LocalDate.now())) {
                    result = true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Wrong File!");
                break;
            }

        }
        return result;
    }
}
