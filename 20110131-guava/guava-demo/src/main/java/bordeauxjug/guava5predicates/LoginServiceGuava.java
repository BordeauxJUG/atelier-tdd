package bordeauxjug.guava5predicates;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import java.util.List;

/**
 *
 * @since 1.0
 * @author lforet
 */
public class LoginServiceGuava implements LoginService {

    @Override
    public List<String> extractWeakPasswords(List<String> passwords) {
        Predicate isWeakPasswordPredicate = new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return input.length() < 5;
            }
        };

        return (List<String>)Collections2.filter(passwords, isWeakPasswordPredicate);
    }

}
