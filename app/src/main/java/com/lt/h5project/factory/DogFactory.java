package com.lt.h5project.factory;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.factory
 * @class describe
 * @time 2019-12-15 17:06
 * @change
 * @chang time
 * @class describe
 */
public class DogFactory extends Factory {
    @Override
    public Animal create() {
        return new Dog();
    }
}
