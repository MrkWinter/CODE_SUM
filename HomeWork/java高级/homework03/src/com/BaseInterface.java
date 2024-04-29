package com;

/**
 * @author MrkWinter
 * @version 1.0
 */
public interface BaseInterface<K, V> {
    public <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2);
}
