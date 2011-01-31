package bordeauxjug.guava5predicates;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 1.0
 * @author lfo
 */
public class LoginServiceBefore implements LoginService {

    @Override
    public List<String> extractWeakPasswords(List<String> passwords) {
        List<String> toReturn = new ArrayList<String>();
        for (String password : passwords) {
            if (password.length() < 5) {
                toReturn.add(password);
            }
        }
        return toReturn;
    }
}
