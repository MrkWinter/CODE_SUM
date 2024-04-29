package com.work02;

public class PairUtil<K,V>implements BaseInterfase<K,V> {


    @Override
    public <K1, V1> boolean compare(Pair<K1, V1> p1, Pair<K1, V1> p2) {
        return (p1.getKey().equals(p2.getKey()))&&(p1.getValue().equals(p2.getValue()));
    }
}
