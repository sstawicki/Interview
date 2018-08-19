import java.util.List;
import java.util.regex.Pattern;

public class CheckLastName {
    private static final String STRING_PATTERN = ".*\\d+.*";
    private final Pattern pattern = Pattern.compile(STRING_PATTERN);

    public boolean checkLastName(List<String> list) {
        boolean result = false;
        for (String line : list) {
            String date[] = line.split(",");
            if (pattern.matcher(date[1]).matches()|| date[1].equals("")) {
                result = false;
                break;
            }  else {
                result = true;
            }
        }
        return result;
    }
}
