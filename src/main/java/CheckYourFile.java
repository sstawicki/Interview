import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckYourFile {
    private static List<String> listsFromFile(String pathFile) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            list = reader.lines().collect(Collectors.toList());
            reader.close();
        } catch (IOException e) {
            System.out.println("File read error: " + e);
        }
        return list;
    }

    public static boolean checkFirstName(List<String> list) {
        boolean result = false;
        for (String line : list) {
            String date[] = line.split(",");
            if (date[0].matches(".*\\d+.*") || date[0].equals("")) {
                result = false;
                break;
            }  else {
                result = true;
            }
        }
        return result;
    }

    public static boolean checkLastName(List<String> list) {
        boolean result = false;
        for (String line : list) {
            String date[] = line.split(",");

            if  (date[1].matches(".*\\d+.*") || date[1].equals("")) {
                result = false;
                break;
            }  else {
                result = true;
            }
        }
        return result;
    }

    public static boolean checkDateOfBrth(List<String> list) {
        boolean result = false;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        for (String line : list) {
            String date[] = line.split(",");
            try {
                LocalDate.parse(date[2],formatter);
                result = true;
            } catch (Exception e) {
                System.out.println("Wrong File!");
                break;
            }

        }
        return result;
    }

    public static boolean checkPhoneNumber(List<String> list) {
        boolean result = false;
        for (String line : list) {
            String date[] = line.split(",");
            if (date.length < 4) {
                continue;
            }
            if (date[3].matches("\\d+")){
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
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

    public static boolean checkAll(String path){
        List<String> list = listsFromFile(path);
        if (checkFirstName(list) && checkLastName(list) && checkDateOfBrth(list) && checkPhoneNumber(list) && howManyData(list)) {
            return true;
        } else {
            return false;
        }
    }
}
