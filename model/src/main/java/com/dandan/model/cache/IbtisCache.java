package com.dandan.model.cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by dandan On 八月 28 2019
 */
public interface IbtisCache {

    String getId();//缓存编号
    void putObject(Object var1, Object var2);//保存对象
    Object getObject(Object var1);//获取对象
    Object removeObject(Object var1);//移除对象
    void clear();//清空缓存
    int getSize();//获取缓存对象大小
    ReadWriteLock getReadWriteLock();//获取缓存的读写锁

}
