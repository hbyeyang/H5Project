package com.lt.h5project.factory;

import com.lt.h5project.util.LogUtils;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.factory
 * @class describe
 * @time 2019-12-15 17:01
 * @change
 * @chang time
 * @class describe
 */
public class Dog extends Animal{
    @Override
    public void show() {
        LogUtils.d("Dog");
    }
}
