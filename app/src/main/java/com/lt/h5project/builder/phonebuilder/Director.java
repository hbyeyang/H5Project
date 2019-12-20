package com.lt.h5project.builder.phonebuilder;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.build
 * @class describe
 * @time 2019-12-15 11:59
 * @change
 * @chang time
 * @class describe
 */
public class Director {
    private Builder mBuilder;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public void construct(String phoneNumber,String brand,String version){
        mBuilder.setPhoneNumber(phoneNumber);
        mBuilder.setBrand(brand);
        mBuilder.setVersion(version);
    }
}
