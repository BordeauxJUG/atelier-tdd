package org.bordeauxjug.guavademo.demo1collections;

/**
 * Recherche dans un ensemble de clé,valeur par la clé et/ou par la valeur.
 * 
 * @since 1.0
 * @author lforet
 */
public interface DealWithMap {

    /**
     * Recherche par clé
     * @param key
     * @return la value correspondante
     */
    String findByKey(String key);
    /**
     * Recherche par valeur
     * @param value
     * @return la key correspondante
     */
    String findByValue(String value);
    /**
     *
     * @param key
     * @param value unique
     */
    void put(String key, String value);

}
