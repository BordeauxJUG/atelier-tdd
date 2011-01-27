package org.bordeauxjug.guavademo.demo6functions;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.util.List;

/**
 *
 * @author lforet
 */
public class LoginServiceGuava implements LoginService {

    @Override
    public List<String> strongifyPasswords(List<String> passwords) {
        Function<String, String> strongifyPasswordFunction = new Function<String, String>() {

            @Override
            public String apply(String input) {
                return input.length() < 5 ? "12345" : input;
            }
        };

        return Lists.transform(passwords, strongifyPasswordFunction);
    }



}
