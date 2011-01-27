package org.bordeauxjug.guavademo.demo1collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 *
 * @since 1.0
 * @author lforet
 */
public class DealWithMapGuavaBiMap implements DealWithMap {

    private BiMap<String, String> STATIC_MAP = HashBiMap.create();

    @Override
    public String findByKey(String key) {
        return STATIC_MAP.get(key);
    }

    @Override
    public String findByValue(String value) {
        return STATIC_MAP.inverse().get(value);
    }

    @Override
    public void put(String key, String value) {
        STATIC_MAP.forcePut(key, value);  // An alternate form of put that silently removes any existing entry with the value
    }

}
