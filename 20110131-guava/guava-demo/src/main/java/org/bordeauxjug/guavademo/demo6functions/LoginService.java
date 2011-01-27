package org.bordeauxjug.guavademo.demo6functions;

import java.util.List;

/**
 *
 * @since 1.0
 * @author lforet
 */
public interface LoginService {

    /**
     * Faire en sorte que les mots de passe fassent plus de 5 characteres.
     * @param passwords
     * @return
     */
    public List<String> strongifyPasswords(List<String> passwords);

}
