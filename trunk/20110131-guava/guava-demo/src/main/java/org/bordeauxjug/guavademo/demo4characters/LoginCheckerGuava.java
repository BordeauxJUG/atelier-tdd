package org.bordeauxjug.guavademo.demo4characters;

import com.google.common.base.CharMatcher;

public class LoginCheckerGuava implements LoginChecker {

    @Override
    public boolean check(String login) {
        CharMatcher specialChars = CharMatcher.anyOf("!@?(,)");
        return specialChars.matchesNoneOf(login);
    }
}
