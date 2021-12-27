import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {
   public  final Pattern emailRegex =
           Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public  boolean eslestir(String emailStr) {
        Matcher matcher = emailRegex.matcher(emailStr);
        return matcher.find();
    }
}
