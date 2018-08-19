import java.util.List;
import java.util.regex.Pattern;

public class CheckFirstName {
    private static final String STRING_PATTERN = ".*\\d+.*";
    private final Pattern pattern = Pattern.compile(STRING_PATTERN);

    public boolean checkFirstName(List<String> list) {
        boolean result = false;
        for (String line : list) {
            String date[] = line.split(",");
            if (pattern.matcher(date[0]).matches()|| date[0].equals("")) {
                result = false;
                break;
            }  else {
                result = true;
            }
        }
        return result;
    }

}
