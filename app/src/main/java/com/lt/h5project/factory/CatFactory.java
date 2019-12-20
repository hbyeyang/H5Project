package com.lt.h5project.factory;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.factory
 * @class describe
 * @time 2019-12-15 17:04
 * @change
 * @chang time
 * @class describe
 */
public class CatFactory extends Factory{
    @Override
    public Animal create() {
        return new Cat();
    }
}
