package org.bordeauxjug.guavademo.demo4characters;

/**
 *
 * @since 1.0
 * @author lforet
 */
public class LoginCheckerBefore implements LoginChecker {

    @Override
    public boolean check(String login) {
        throw new UnsupportedOperationException("TODO : pas le temps passe à Guava direct");
    }

}
