package com.dandan.other.generics.contains;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Description 自定义Map接口
 * K、V是类型参数
 * @Author dandan
 * @Date 2019-10-22
 */
public interface MyMap<K,V> {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void putAll(MyMap<? extends K, ? extends V> m);

    void clear();

    Set<K> keySet();

    Collection<V> values();

    Set<MyMap.Entry<K,V>> entrySet();

    interface Entry<K,V>{

        K getKey();

        V getValue();

        V setValue(V value);

        @Override
        boolean equals(Object o);

        @Override
        int hashCode();

    }

}
