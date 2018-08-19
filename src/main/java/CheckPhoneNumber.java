import java.util.List;
import java.util.regex.Pattern;

public class CheckPhoneNumber {
    private static final String INIT_PATTERN = "\\d+";
    private final Pattern patternTwo = Pattern.compile(INIT_PATTERN);

    public boolean checkPhoneNumber(List<String> list) {
        boolean result = false;
        for (String line : list) {
            String date[] = line.split(",");
            if (date.length < 4) {
                continue;
            }
            if (patternTwo.matcher(date[3]).matches()){
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
