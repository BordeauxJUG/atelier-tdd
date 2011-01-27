package org.bordeauxjug.guavademo.demo5predicates;

import java.util.List;

/**
 *
 * @author lforet
 */
public interface LoginService {


    /**
     * un mot de passe est considéré comme faible si ca longueur est < 5.
     * @param passwords
     * @return weakPasswords
     */
    List<String> extractWeakPasswords(List<String> passwords);

}
