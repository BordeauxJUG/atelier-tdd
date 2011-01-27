package org.bordeauxjug.guavademo.demo4characters;

/**
 * Exemple tiré de http://www.touilleur-express.fr/2010/11/03/google-guava-partie-1/
 * @since 1.0
 * @author lforet
 */
public interface LoginChecker {

    /**
     * 
     * @param login
     * @return true si le login ne contient pas les caractères suivants : !@?(,)
     */
    boolean check(String login);

}
